package edu.grcy.sda.log4jDemo;

import org.apache.log4j.Logger;

public class Main {

    /**
     * pole finalne, czyli jak stała więc same duże litery
     *
     * Dobrą praktyką jest zakładanie osobnego Loggera w każdej klasie
     * czyli np w Banku osobne instancje w Bank, Customer, Account
     *
     */
    final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.error("This is error message");
        LOGGER.warn("This is warning");
        LOGGER.fatal("This is fatal error message");
        LOGGER.debug("This is debug");
        LOGGER.info("This is common info message!!");

        if(LOGGER.isInfoEnabled()) {
            LOGGER.info("Another info message");
        }

        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("And again debug message");
        }

        Main main = new Main();
        try {
            main.divide(3, 4);
        } catch (ArithmeticException ex) {
            LOGGER.error("Some error caught : " + ex.getMessage());
        }

    }

    private void divide(int a, int b) {
        LOGGER.info("Trying to divide " + a + " by " + b);
        int i = a / b;
    }

}
