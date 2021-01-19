package edu.grcy.sda.java8.functionalInterfaces.optional;

import edu.grcy.sda.java8.Car;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Car familyCar = new Car("Ford SMax", "1.6");
        Car sportCar = new Car("Ford Mustang", "5.4");
        Car volvoCar = new Car("Volvo V50", "1.7");
        Car unknownCar = null;

        /**
         * Optional to kontener (opakowanie) na obiekt
         * Może zawierać ten obiekt ale może też być pusty
         */

        //pusty kontener na obiekt
        Optional<Car> carOptional = Optional.empty();

        //kontener z zawartością
        //metoda .of tworzy Optionala i wymaga żeby zawartość była
        Optional<Car> carOptionalFilled = Optional.of(familyCar);

        //metoda .ofNullable tworzy Optionala i dopuszcza pusta zawartość
        Optional<Car> optionalCarNullable = Optional.ofNullable(sportCar);

        Optional<Car> optionalOnUnknown = Optional.ofNullable(unknownCar);

        /**
         * Ale po co to panocku?
         */
        //pre optional
        if(volvoCar == null) {
            //do sth
        }

        //z optionalem
        //isPresent testuje czy w Optionalu jest obiekt
        if(carOptionalFilled.isPresent()) {
            // Metoda get() wyciąga właściwy obiekt z Optionala
            Car weKnowYouAreInThere = carOptionalFilled.get();
            System.out.println(weKnowYouAreInThere);
        }

        if(optionalOnUnknown.isEmpty()) {
            System.out.println("Tu nic nie ma w tym pudełku");
        }


    }
}
