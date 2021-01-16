package edu.grcy.sda.oopBasics.encapsulation;

import edu.grcy.sda.oopBasics.encapsulation.person.Person;

public class MorePeople {
    public static void main(String[] args) {
        Person person = new Person();
        /**
         * Klasa Person jest w innym pakiecie
         * więc mamy dostęp tylko do jej
         * metod / pól publicznych
         */
        person.noOfChildren = 22;
    }
}
