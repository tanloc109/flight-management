package viewer;

import controller.BookingController;
import controller.FlightController;
import controller.StaffController;
import dbo.FlightFileManagement;
import dto.Booking;
import dto.Crew;
import dto.Customer;
import dto.Flight;
import dto.Staff;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FlightService {

    public static Scanner sc = new Scanner(System.in);
    FlightController flightController = new FlightController();
    FlightFileManagement fileManager = new FlightFileManagement();
    BookingController bookingController = new BookingController();
    StaffController staffController = new StaffController();

    public void flightScheduleManagement() {
        int subChoice;
        do {
            System.out.println("----------Flight Management-----------");
            System.out.println("|1 - Add new flight                  |");
            System.out.println("|2 - Delete flight                   |");
            System.out.println("|3 - Show flight schedule            |");
            System.out.println("-------------------------------------");
            System.out.print("Input your choice: ");
            subChoice = Integer.parseInt(sc.nextLine());
            while (subChoice < 1 || subChoice > 3) {
                System.out.println("Invalid choice. Please try again.");
                System.out.print("Input your choice: ");
                subChoice = Integer.parseInt(sc.nextLine());
            }
            switch (subChoice) {
                case 1:
                    addNewFlight();
                    break;
                case 2:
                    deleteFlight();
                    break;
                case 3:
                    showFlightSchedule();
                    break;
            }
        } while (subChoice != 1 && subChoice != 2 && subChoice != 3);
    }

    private void addNewFlight() {

        System.out.println("Input information of new flight.");
        boolean flag = false;
        String newFlightNumber;
        do {
            newFlightNumber = utils.Util.getString("Input new Flight number: ", "F\\d{4}");
            for (Flight flight : flightController.getFlights()) {
                if (flight.getFlightNumber().equalsIgnoreCase(newFlightNumber)) {
                    System.out.println("Flight number cannot duplicate.");
                    flag = true;
                }
            }
        } while (flag);
        String departureCity = utils.Util.getString("Input departure city: ");
        String destinationCity = utils.Util.getString("Input destination city: ");
        Date departureTime = utils.Util.inputDate("Input departure time: ", tomorrow(), sixMonthLater(currentDate()));
        Date arrivalTime = utils.Util.inputDate("Input arrival time: ", departureTime, sixMonthLater(currentDate()));

        int availableSeats = utils.Util.getInt("Input available Seats: ", 0, 500);
        Flight newFlight = new Flight(newFlightNumber, departureCity, destinationCity, departureTime, arrivalTime, availableSeats);
        if (flightController.addFlight(newFlight)) {
            System.out.println("Add new Flight successful.");
        } else {
            System.out.println("Add new Flight failed.");
        }

    }

    private void deleteFlight() {
        String idDeletedFlight = utils.Util.getString("Input Flight number you want to delete: ");
        if (utils.Util.confirmYesNo("Are you sure want to delete Flight have Flight number " + idDeletedFlight + "(y/n): ")) {
            if (flightController.deleteFlight(idDeletedFlight)) {
                System.out.println("Flight " + idDeletedFlight + " is deleted success.");
            } else {
                System.out.println("Flight " + idDeletedFlight + " is deleted failed. Because doesn't exist flight " + idDeletedFlight);
            }
        } else {
            System.out.println("Request delete flight is cancelled.");
        }
    }

    private void showFlightSchedule() {
        flightController.printAll((ArrayList<Flight>) flightController.getFlights());
    }

    private Date sixMonthLater(Date inputDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputDate);
        calendar.add(Calendar.MONTH, 6);
        return calendar.getTime();
    }

    private Date tomorrow() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    private Date currentDate() {
        Date currentDate = new Date();
        return currentDate;
    }

    public void passengerReservationAndBooking() {
        int subChoice;
        do {
            System.out.println("-------Reservation And Booking--------");
            System.out.println("|1 - Search avalable flights         |");
            System.out.println("|2 - Reservation                     |");
            System.out.println("-------------------------------------");
            System.out.print("Input your choice: ");
            subChoice = Integer.parseInt(sc.nextLine());
            while (subChoice < 1 || subChoice > 2) {
                System.out.println("Invalid choice. Please try again.");
                System.out.print("Input your choice: ");
                subChoice = Integer.parseInt(sc.nextLine());
            }
            switch (subChoice) {
                case 1:
                    searchAvalableFlights();
                    break;
                case 2:
                    bookingSeats();
                    break;
            }
        } while (subChoice != 1 && subChoice != 2);
    }

    private void searchAvalableFlights() {
        String departure = utils.Util.getString("Input departure city: ");
        String arrival = utils.Util.getString("Input arrival city: ");
        Date date = utils.Util.inputDate("Input date you want to book to fight: ", tomorrow());
        List<Flight> listAvalableFlight = flightController.searchAvalableFlight(departure, arrival, date);
        if (!listAvalableFlight.isEmpty()) {
            flightController.printAll((ArrayList<Flight>) listAvalableFlight);
            boolean bookingOrNot = utils.Util.confirmYesNo("Do you want booking now ? (y/n): ");
            if (bookingOrNot) {
                bookingSeats();
            } else {
                return;
            }
        } else {
            System.out.println("Don't have any flight from " + departure + " to " + arrival + " at " + date);
            System.out.println("Hope you will find a suitable flight soon.");
        }

    }

    private void bookingSeats() {
        boolean haveFlightNumberOrNot = utils.Util.confirmYesNo("Does you have flight number you want booking (y/n): ");
        String nameCustomer = utils.Util.getString("Input name of customer: ");
        String phoneNumber = utils.Util.getString("Input phone number of customer: ");
        String email = utils.Util.getString("Input email of customer: ");
        Customer customer = new Customer(email, phoneNumber, email);
        if (haveFlightNumberOrNot) {
            String flightNumberToBooking = utils.Util.getString("Input flight number you want booking: ");
            if (flightController.checkValidFlight(flightNumberToBooking)) {
                Booking newBooking = new Booking(customer, flightController.findFlightById(flightNumberToBooking));
                bookingController.addBooking(newBooking);
                System.out.println("Booking successful flight: " + flightNumberToBooking + ", booking id: " + newBooking.getBookingId());
            } else {
                System.out.println("Sorry. This Flight not availble to booking.");
            }
        } else {
            searchAvalableFlights();
        }
    }

    public void crewManagement() {
        String flightNumberToCrewManagement = utils.Util.getString("Input flight number you want crew management: ");
        if (flightController.checkValidFlight(flightNumberToCrewManagement)) {
            for (Staff staff : staffController.getStaffs()) {
                System.out.println(staff.toString());
            }
            int captionId = utils.Util.getInt("Input staff id of caption: ", 0, 20);
            int copilotId = utils.Util.getInt("Input staff id of co-pilot: ", 0, 20);
            int flightAttendant1 = utils.Util.getInt("Input staff id of first flight attendant: ", 0, 20);
            int flightAttendant2 = utils.Util.getInt("Input staff id of second flight attendant: ", 0, 20);
            int flightAttendant3 = utils.Util.getInt("Input staff id of third flight attendant: ", 0, 20);
            Crew crew = new Crew(staffController.getStaffById(captionId), staffController.getStaffById(copilotId),
                    staffController.getStaffById(flightAttendant1), staffController.getStaffById(flightAttendant2), staffController.getStaffById(flightAttendant3));
            flightController.setCrew(flightNumberToCrewManagement, crew);
            System.out.println("Set crew for flight number: " + flightNumberToCrewManagement + " is success.");
        } else {
            System.out.println("Sorry. This Flight not availble to booking.");
        }
    }

    public void checkIn() {
        String flightNumberYouWantCheckIn = utils.Util.getString("Input flight number you want check-in: ");
        if (flightController.checkValidFlight(flightNumberYouWantCheckIn)) {
            int bookingCheck = utils.Util.getInt("Please give me your booking id: ", 999999, 9999999);
            if (checkBookingCheckedInOrYet(flightNumberYouWantCheckIn, bookingCheck)) {
                for (Booking booking : bookingController.getListBooking()) {
                    if (booking.getBookingId() == bookingCheck) {
                        int c = 0;
                        for (Integer arr : flightController.findFlightById(flightNumberYouWantCheckIn).getSeatsArray()) {
                            c++;
                            if (arr == 0) {
                                System.out.println("Seat[" + c + "]");
                            }
                        }
                        int seatCheckIn = utils.Util.getInt("Please choose favorite seat: ", 0, flightController.findFlightById(flightNumberYouWantCheckIn).getSeats() + 1);
                        flightController.findFlightById(flightNumberYouWantCheckIn).getSeatsArray()[seatCheckIn - 1] = booking.getBookingId();
                        System.out.println("Check-in Flight " + flightNumberYouWantCheckIn + " is success.");
                        System.out.println("Boarding pass is printing...");
                        System.out.println("Customer information: ");
                        System.out.println(booking.getCustomer().toString());
                        System.out.println("Booking id: " + booking.getBookingId());
                        System.out.println("Flight information: ");
                        System.out.println(booking.getFlight().toString());
                        System.out.println("Your seat is: " + seatCheckIn);
                    }
                    return;
                }
                System.out.println("Your booking id does not exist.");
            } else {
                System.out.println("This booking is checked-in.");
            }
        }
    }

    private boolean checkBookingCheckedInOrYet(String flightId, int bookingId) {
        for (Integer arr : flightController.findFlightById(flightId).getSeatsArray()) {
            if (arr == bookingId) {
                return false;
            }
        }
        return true;
    }

    public void saveToFile() {
        try {
            fileManager.writeFile((ArrayList) flightController.getFlights());
            System.out.println("Save to File is success.");
        } catch (Exception e) {
            System.out.println("Save to file is failed.");
        }
    }

    public void printFromFile() {
        try {
            flightController.printAll(fileManager.readFile());
            System.out.println("Print from file is success.");
        } catch (Exception e) {
            System.out.println("Print from file is failed.");
        }
    }

}
