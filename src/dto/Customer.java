package dto;

import java.util.List;

public class Customer {
    private int customerId = 0;
    private String name, phoneNumber, email;
    private List<Flight> flighHistory;
    
    public Customer() {
    }

    public Customer(String name, String phoneNumber, String email) {
        this.customerId = ++customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.flighHistory = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Flight> getFlighHistory() {
        return flighHistory;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return customerId + ", " + name + ", " + phoneNumber + ", " + email;
    } 


    
    
    
}
