package controller;

import dto.Crew;
import utils.DateComparison;
import dto.Flight;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightController {
    private final List<Flight> flights = new ArrayList<>();

    public List<Flight> getFlights() {
        return flights;
    }

    public boolean addFlight(Flight flight) {
        try {
            flights.add(flight);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteFlight(String id) {
        try {
            for (Flight flight: flights) {
                if (flight.getFlightNumber().equalsIgnoreCase(id)) {
                    flights.remove(flight);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void printAll(ArrayList<Flight> list) {
        for (Flight flight : list) {
            System.out.println(flight.toString());
        }
    }
    
    public List<Flight> searchAvalableFlight(String departureCity, String destinationCity, Date date) {
        List<Flight> avaibleFlights = new ArrayList();
        for (Flight flight : flights) {
            if(flight.getDepartureCity().equalsIgnoreCase(departureCity) 
                    && flight.getDestinationCity().equalsIgnoreCase(destinationCity) 
                    && DateComparison.isSameDate(date, flight.getDepartureTime())
                    ) {
                avaibleFlights.add(flight);
            }
        }
        return avaibleFlights;
    }
    
    public boolean checkValidFlight(String flightNumber) {
        Flight flightNeedCheck = findFlightById(flightNumber);
        if (flightNeedCheck.getAvalableSeat()<=0 || 
                DateComparison.isSameDate(flightNeedCheck.getDepartureTime(), DateComparison.currentDate())
                ) {
            return false;
        }
        return true;
    }
    
    public Flight findFlightById(String flightNumber) {
        for (Flight flight : flights) {
            if(flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
    
    public boolean setCrew (String flighNumber, Crew crew) {
        try {
            Flight flight = findFlightById(flighNumber);
            flight.setCrew(crew);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
