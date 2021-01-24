package edu.grcy.sda.java8.streams;

import java.util.Comparator;

public class HumanComparedByName implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        //pobieramy imię z human1 i human2
        //imiona to obiekty klasy String
        //klasa String implementuje interfejs Comparable
        //więc do porównania stringów wywołujemy metodę compareTo()
        return human1.getName().compareTo(human2.getName());
    }
}
