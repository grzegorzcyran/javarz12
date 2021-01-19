package edu.grcy.sda.java8.functionalInterfaces.predicate;

import edu.grcy.sda.java8.Car;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Car familyCar = new Car("Ford SMax", "1.6");
        Car sportCar = new Car("Ford Mustang", "5.4");
        Car volvoCar = new Car("Volvo V50", "1.7");

        /**
         * Predykat służy do testowania warunku,
         * przyjmuje obiekt, zwraca boolean
         */
        Predicate<Car> isSmallEngine = x -> x.getEngine().compareTo("2.0") < 0;
        Predicate<Car> isFord = a -> a.getName().startsWith("Ford");

        if(isFord.test(volvoCar)) {
            System.out.println(familyCar);
        } else {
            System.out.println("Sprawdzany samochód nie jest Fordem");
        }

        printCar(familyCar, isSmallEngine);
        printCar(sportCar, isSmallEngine);
        printCar(sportCar, isFord);
        printCar(volvoCar, isFord);
    }

    private static void printCar(Car car, Predicate<Car> condition) {
        if(condition.test(car)) {
            System.out.println("Passed: " + car.getName() + " " + car.getEngine());
        }
    }
}
