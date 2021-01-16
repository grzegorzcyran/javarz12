package edu.grcy.sda.oopBasics.encapsulation;

import edu.grcy.sda.oopBasics.encapsulation.person.Person;

public class PersonExtended extends Person {
    void process() {
        /**
         * dostęp do pól / metod protected i public
         * nie ma dostępu do package private klasy Person
         * bo to inny pakiet
         */
        this.lastName = "Woroszyłow";
        this.noOfChildren = 12;
    }
}
