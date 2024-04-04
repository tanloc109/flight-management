 package viewer;

import static viewer.FlightService.sc;

public class Application {

    public static void main(String[] args) throws Exception {
        FlightService manager = new FlightService();
        System.out.println("Welcome to Flight Management - @ 2023 by SE171129 - Pham Tan Loc");
        int choice, subchoice;
        do {
            System.out.println("----------------MENU-------------------------------------------");
            System.out.println("|1 - Flight schedule management                               |");
            System.out.println("|2 - Passenger Reservation and Booking                        |");
            System.out.println("|3 - Passenger Check-In and Seat Allocation and Availability  |");
            System.out.println("|4 - Crew Management and Administrator Access                 |");
            System.out.println("|5 - Save to file                                             |");
            System.out.println("|6 - Print all lists from file                                |");
            System.out.println("|7 - Quit application                                         |");
            System.out.println("---------------------------------------------------------------");
            System.out.print("Input your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            while (choice < 1 || choice > 7) {
                System.out.println("Invalid choice. Please try again.");
                System.out.print("Input your choice: ");
                choice = Integer.parseInt(sc.nextLine());
            }
            switch (choice) {
                case 1:
                    manager.flightScheduleManagement();
                    break;
                case 2:
                    manager.passengerReservationAndBooking();
                    break;
                case 3:
                    manager.checkIn();
                    break;
                case 4:
                    manager.crewManagement();
                    break;
                case 5:
                    manager.saveToFile();
                    break;
                case 6:
                    manager.printFromFile();
                    break;
                case 7:
                    System.out.println("Goodbye ^.^");
                    break;
            }
        } while (choice != 7);
    }
}
