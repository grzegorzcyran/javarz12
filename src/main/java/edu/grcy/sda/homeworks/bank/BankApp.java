package edu.grcy.sda.homeworks.bank;

import java.math.BigDecimal;

public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank("GC Bank");

        bank.addCustomer("Jan", "Kowalski");
        bank.addCustomer("Anna", "Nowak");

        bank.addAccountForCustomer("Jan", "Kowalski", AccountType.CURRENT);
        bank.addAccountForCustomer("Jan", "Kowalski", AccountType.SAVINGS);
        bank.addAccountForCustomer("Anna", "Nowak", AccountType.CURRENT);
        bank.addAccountForCustomer("Anna", "Nowak", AccountType.CURRENT);
        bank.addAccountForCustomer("Anna", "Nowak", AccountType.SAVINGS);

        System.out.println(bank.getAllCustomersInfo(true, false));

        bank.deposit("Jan", "Kowalski", "1", BigDecimal.valueOf(100));
        bank.deposit("Anna", "Nowak", "3", BigDecimal.valueOf(20));
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++");

        System.out.println(bank.getAllCustomersInfo(true, true));
    }
}
