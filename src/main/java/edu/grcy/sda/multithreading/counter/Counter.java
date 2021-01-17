package edu.grcy.sda.multithreading.counter;

import static edu.grcy.sda.multithreading.ThreadColor.*;

public class Counter {
    private int i;

    /**
     * Można synchronizować całą "dużą" metodę ale to niezalecane
     * bo powinniśmy synchronizować najmniejsze możliwe, niezbędne
     * kawałki kodu - metody bądź bloki kodu
     *
     * W performCountdown wykonuje się wcześniej sporo innego kodu
     * który nie jest wrażliwy na zmianę wątku
     */
    //public synchronized void performCountdown() {
    public  void performCountdown() {
        String color;
        switch (Thread.currentThread().getName()) {
            case "Thread1" :
                color = ANSI_CYAN;
                break;
            case "Thread2" :
                color = ANSI_PURPLE;
                break;
            default:
                color = ANSI_GREEN;
         }

        /**
         * kod zadeklarowany jako synchronized musi się w całości wykonać
         * dla jednego wątku i dopiero później inny wątek może zacząć
         * wykonywać ten sam kawałek kodu dla siebie
         */
        synchronized (this) {
             doRealCountdown(color);
        }
    }

    //private synchronized void doRealCountdown(String color) {
    private void doRealCountdown(String color) {
        for(i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + " i=" + i);
        }
    }
}
