package edu.grcy.sda.java8.functionalInterfaces.function;

import edu.grcy.sda.java8.Car;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Car familyCar = new Car("Ford SMax", "1.6");
        Car sportCar = new Car("Ford Mustang", "5.4");
        Car volvoCar = new Car("Volvo V50", "1.7");

        /**
         * Function przyjmuje obiekt i zwraca inny obiekt
         */
        Function<Car, String> getEngine = (x) -> x.getEngine();
        Function<Car, String> nameUpperCase = x -> x.getName().toUpperCase();

        System.out.println("=================");
        System.out.println(getEngine.apply(familyCar));

        System.out.println("=================");
        System.out.println(nameUpperCase.apply(sportCar));

        Function<Car, Car> upgradeCar = car -> {
            return new Car(car.getName() + " upgraded"
            ,car.getEngine() + " TURBO");
        };

        Car newCar = upgradeCar.apply(volvoCar);
        System.out.println("=================");
        System.out.println(newCar);
    }
}
