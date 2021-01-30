package edu.grcy.sda.homeworks.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Customer {
    private String name;
    private String surname;
    private String id;
    private List<Account> accountList;

    //na potrzeby sprawdzania czy klient już jest na liście
    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Customer(String name, String surname, String id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        accountList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public boolean addAccount(String accountNo, AccountType accountType) {
        return accountList.add(new Account(accountType, accountNo));
    }

    public boolean removeAccount(String accountNo) {
        Account accountToDelete = new Account(accountNo);
        for (Account account : accountList) {
            if(account.equals(accountToDelete)) {
                if (account.getBalance().equals(BigDecimal.ZERO)) {
                    return accountList.remove(account);
                }
                return false;
            }
        }
        return false;
    }

    //wpłata
    public boolean depositOnGivenAccount(String accountNo, BigDecimal amount) {
        for (Account account : accountList) {
            if(accountNo.equals(account.getAccountNo())) {
                return account.deposit(amount);
            }
        }
        //nie ma takiego konta
        return false;
    }

    //wypłata
    public boolean withdrawFromGivenAccount(String accountNo, BigDecimal amount) {
        for (Account account : accountList) {
            if(accountNo.equals(account.getAccountNo())) {
                //true albo false zależnie od tego czy udało się wypłacić czy nie
                return account.withdraw(amount);
            }
        }
        //nie ma takiego konta
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name) &&
                surname.equals(customer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public Optional<Account> findAccount(String accountNo) {
        return accountList.stream()
                .filter(x -> x.getAccountNo().equals(accountNo))
                .findFirst();
    }

    public StringBuilder getCustomerInfo(boolean withAccounts, boolean withBalance) {
        return new StringBuilder("\n\n")
                .append(surname)
                .append(" ")
                .append(name)
                .append(withAccounts ? getAccountsInfo(withBalance) : "");
    }

    private StringBuilder getAccountsInfo(boolean withBalance) {
        StringBuilder accountsInfo = new StringBuilder();
        accountList.stream()
                .forEach(x -> accountsInfo.append(x.getSingleAccountInfo(withBalance)));
        return accountsInfo;
    }
}
