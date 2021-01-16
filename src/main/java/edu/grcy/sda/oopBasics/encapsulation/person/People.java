package edu.grcy.sda.oopBasics.encapsulation.person;

public class People {

    public static void main(String[] args) {
        Person person = new Person();

        /**
         * Inna klasa, ten sam pakiet : mamy dostęp do pól / metod
         * pakietowych, protected i prywatnych
         */
        person.age = 22; //package access
        System.out.println(person.age);

        person.lastName = "Kowalski"; //protected access
        System.out.println(person.lastName);

        person.noOfChildren = 3; //public access
        System.out.println(person.noOfChildren);

    }
}
