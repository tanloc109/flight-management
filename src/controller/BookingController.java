package controller;

import dto.Booking;
import dto.Customer;
import dto.Flight;
import java.util.ArrayList;
import java.util.List;

public class BookingController {
    private List<Booking> listBooking = new ArrayList();

    public BookingController() {
    }

    public List<Booking> getListBooking() {
        return listBooking;
    }
    
    public boolean addBooking(Customer customer, Flight flight) {
        try {
            listBooking.add(new Booking(customer, flight));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteBooking(int bookingId) {
        try {
            for (Booking booking : listBooking) {
                if (booking.getBookingId() == bookingId) {
                    listBooking.remove(booking);
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void addBooking(Booking newBooking) {
        listBooking.add(newBooking);
    }
}
