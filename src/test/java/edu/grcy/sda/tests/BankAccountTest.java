package edu.grcy.sda.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void setup() {
        bankAccount = new BankAccount("Jan", "Kowalski", 100.0, 1);
    }

    @Test
    public void testDeposit100() {
        double expected = 200.0;

        double balance = bankAccount.deposit(100.0, false);

        assertEquals(expected, balance, "Expected value 200.0 while " + balance + " was given");

    }

    @Test
    public void testDeposit600InBranch() {
        double expected = 700.0;

        double balance = bankAccount.deposit(600.0, true);

        assertEquals(expected, balance, "Expected value 700.0 while " + balance + " was given");

    }

    @Test
    public void testDeposit600NotInBranchThrowsException() {
        double expected = 700.0;

        try{
            double balance = bankAccount.deposit(600.0, false);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    public void testDeposit600NotInBranchWithAssertThrows() {
        //wywołanie metody bankAccount.deposit za pomocą interfejsu funkcyjnego Supplier
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(600.0, false));
    }

    @Test
    public void testWithdraw100() {
        double expected = 50.0;

        double balance = bankAccount.withdraw(50.0, false);

        assertEquals(expected, balance, "Expected value 50.0 while " + balance + " was given");

    }


}