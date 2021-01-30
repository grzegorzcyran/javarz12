package edu.grcy.sda.homeworks.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank {
    private static Integer customerNumber = 0;
    private static Integer accountNumber = 0;

    private String name;
    private List<Customer> customers;

    private String getNextCustomerNumber() {
        String newCustomerNumber = customerNumber.toString();
        customerNumber++;
        return newCustomerNumber;
    }

    private String getNextAccountNumber() {
        String newAccountNumber = accountNumber.toString();
        accountNumber++;
        return newAccountNumber;
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

    public boolean addAccountForCustomer(String name, String surname, AccountType accountType) {
        Optional<Customer> customerToFind = findCustomer(name, surname);
        if(customerToFind.isPresent()) {
            return customerToFind.get().addAccount(getNextAccountNumber(), accountType);
        }
        return false;
    }

    public boolean removeAccountForCustomer(String name, String surname, String accountNo) {
        Optional<Customer> customerToFind = findCustomer(name, surname);
        if(customerToFind.isPresent()) {
            return customerToFind.get().removeAccount(accountNo);
        }
        return false;
    }

    public boolean deposit(String name, String surname, String accountNo, BigDecimal amount) {
        Optional<Customer> customerToFind = findCustomer(name, surname);
        if(customerToFind.isPresent()) {
            Customer customerFound = customerToFind.get();
            Optional<Account> possibleAccount = customerFound.findAccount(accountNo);
            if(possibleAccount.isPresent()) {

                return customerFound.depositOnGivenAccount(accountNo, amount);
            }
        }
        return false;
    }

    public boolean withdraw(String name, String surname, String accountNo, BigDecimal amount) {
        Optional<Customer> customerToFind = findCustomer(name, surname);
        if(customerToFind.isPresent()) {
            Customer customerFound = customerToFind.get();
            Optional<Account> possibleAccount = customerFound.findAccount(accountNo);
            if(possibleAccount.isPresent()) {
                return customerFound.withdrawFromGivenAccount(accountNo, amount);
            }
        }
        return false;
    }

    private Optional<Customer> findCustomer(String name, String surname) {

        return customers.stream()
                .filter(x -> x.equals(new Customer(name, surname)))
                .findFirst();
    }

    public String getAllCustomersInfo(boolean withAccounts, boolean withBalance) {
        StringBuilder allCustomersInfo = new StringBuilder(name);
        customers.forEach(x -> allCustomersInfo.append(x.getCustomerInfo(withAccounts, withBalance)));

        return allCustomersInfo.toString();
    }
}
