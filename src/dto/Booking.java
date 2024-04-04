package dto;

public class Booking {
    private static int bookingId = 999999;
    private Customer customer;
    private Flight flight;

    public Booking() {
    }

    public Booking(Customer customer, Flight flight) {
        this.bookingId = ++bookingId;
        this.customer = customer;
        this.flight = flight;
        flight.setAvalableSeat(flight.getAvalableSeat() - 1);
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return bookingId + ", " + customer.toString() + ", " + flight.toString();
    }
    
    
}
