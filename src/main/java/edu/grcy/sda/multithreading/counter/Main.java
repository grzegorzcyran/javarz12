package edu.grcy.sda.multithreading.counter;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        //Counter counter2 = new Counter();

        /**
         * jeśli wątki korzystają z wspólnego obiektu counter
         * to potrzebują synchronizacji
         *
         * jeśli mamy 2 obiekty counter i do dwóch threadCounter
         * przekazemy 2 countery to nie ma co synchronizować
         */
        ThreadCounter threadCounter1 = new ThreadCounter(counter);
        ThreadCounter threadCounter2 = new ThreadCounter(counter);
        threadCounter1.setName("Thread1");
        threadCounter2.setName("Thread2");

        threadCounter1.start();
        threadCounter2.start();
    }
}
