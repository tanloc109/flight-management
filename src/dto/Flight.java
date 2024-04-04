package dto;

import java.util.Date;

public class Flight {
    private String flightNumber, departureCity, destinationCity;
    private java.util.Date departureTime, arrivalTime;
    private int avalableSeat;
    private Crew crew;
    private int seats;
    private int[] seatsArray;

    public Flight() {
    }

    public Flight(String flightNumber, String departureCity, String destinationCity, java.util.Date departureTime, java.util.Date arrivalTime, int seats) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
        this.avalableSeat = seats;
        seatsArray = new int[seats];
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getAvalableSeat() {
        return avalableSeat;
    }

    public void setAvalableSeat(int avalableSeat) {
        this.avalableSeat = avalableSeat;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public int[] getSeatsArray() {
        return seatsArray;
    }

    public void setSeatsArray(int[] seatsArray) {
        this.seatsArray = seatsArray;
    }
    
    @Override
    public String toString() {
        return flightNumber + ", " + departureCity + ", " + destinationCity + ", " + departureTime + ", " + arrivalTime + ", " + avalableSeat;
    }
    
    
}
