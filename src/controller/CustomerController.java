package controller;

import dto.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private List<Customer> customers = new ArrayList();

    public CustomerController() {
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    
    public boolean addCustomer(Customer customer) {
        try {
            customers.add(customer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteCustomer(int customerId) {
        try {
            for (Customer customer : customers) {
                if(customer.getCustomerId() ==  customerId) {
                    customers.remove(customer);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
