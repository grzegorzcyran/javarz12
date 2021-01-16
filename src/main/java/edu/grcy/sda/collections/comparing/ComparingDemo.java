package edu.grcy.sda.collections.comparing;

import edu.grcy.sda.collections.CollectionsCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparingDemo {
    public static void main(String[] args) {
        CollectionsCar car1 = new CollectionsCar("Volvo", "Diesel 2.0", 220);
        CollectionsCar car2 = new CollectionsCar("Ford", "Gasoline 1.6", 215);
        CollectionsCar car3 = new CollectionsCar("BMW", "Gasoline 3.0", 260);
        CollectionsCar car4 = new CollectionsCar("Fiat", "Diesel 1.4", 180);

        car1.setColor("Niebieski");
        car2.setColor("Czarny");
        car3.setColor("Czerwony");
        car4.setColor("Zielony");

        List<CollectionsCar> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);

        System.out.println("Drugujemy elementy listy jak przyszły");
        for (CollectionsCar car : carList) {
            System.out.println(car);
        }

        System.out.println("\n==========\nDrugujemy elementy posortowane przy pomocy domyślnego komparatora");
        Collections.sort(carList);
        for (CollectionsCar car : carList) {
            System.out.println(car);
        }

        System.out.println("\n==========\nDrugujemy elementy posortowane przy pomocy domyślnego komparatora");
        System.out.println("Ale OD Końca");
        Collections.sort(carList, Collections.reverseOrder());
        for (CollectionsCar car : carList) {
            System.out.println(car);
        }

        System.out.println("\n==========\nDrukujemy elementy posortowane po max prędkości");
        Collections.sort(carList, new CollectionsCarComparedBySpeed());
        for (CollectionsCar car : carList) {
            System.out.println(car);
        }

        System.out.println("\n==========\nDrukujemy elementy posortowane po max prędkości");
        System.out.println("Ale OD Końca");
        Collections.sort(carList, new CollectionsCarComparedBySpeed().reversed());
        for (CollectionsCar car : carList) {
            System.out.println(car);
        }

        System.out.println("\n=========\nDrukujemy elementy posortowane po kolorze i prędkości");
        Collections.sort(carList, new CollectionsCarComparedByColorAndSpeed());
        for (CollectionsCar car : carList) {
            System.out.println(car);
        }


        car3.setColor("Czarny");
        System.out.println("\n=========\nDrukujemy elementy posortowane po kolorze i prędkości - ponownie");
        Collections.sort(carList, new CollectionsCarComparedByColorAndSpeed().reversed());
        for (CollectionsCar car : carList) {
            System.out.println(car);
        }
    }
}
