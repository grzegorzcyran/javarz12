package edu.grcy.sda.homeworks.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static Integer customerNumber = 0;

    private String name;
    private List<Customer> customers;

    private String getNextCustomerNumber() {
        String newCustomerNumber = customerNumber.toString();
        customerNumber++;
        return newCustomerNumber;
    }

    public Bank(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomer(String name, String surname) {
        //jak klient już jest na liście to return false
        if(customers.contains(new Customer(name, surname))) {
            return false;
        }
        //identyfikator pobieramy z metody żeby się podbił do kolejnej
        //wartości dla następnego klienta
        return customers.add(new Customer(name, surname, getNextCustomerNumber()));
    }

    public boolean eraseCustomer(String name, String surname) {
        Customer customerToErase = new Customer(name, surname);
        for(Customer customer : customers) {
            if(customer.equals(customerToErase)){
                if(customer.getAccountList().isEmpty()) {
                    return customers.remove(customer);
                }
                //klient jest ale ma konta to go nie usuwamy
                return false;
            }
        }
        //
        return false;
    }
}
