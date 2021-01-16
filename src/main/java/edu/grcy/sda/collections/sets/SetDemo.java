package edu.grcy.sda.collections.sets;

import edu.grcy.sda.collections.CollectionsCar;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        CollectionsCar car1 = new CollectionsCar("Volvo", "Diesel 2.0", 220);
        CollectionsCar car2 = new CollectionsCar("Ford", "Gasoline 1.6", 215);
        CollectionsCar car3 = new CollectionsCar("BMW", "Gasoline 3.0", 260);
        CollectionsCar car4 = new CollectionsCar("Fiat", "Diesel 1.4", 180);

        Set<CollectionsCar> setOfCars = new HashSet<>();
        setOfCars.add(car1);
        setOfCars.add(car2);
        setOfCars.add(car3);
        setOfCars.add(car4);
        setOfCars.add(car2);
        setOfCars.add(car4);

        //kolejność elementów jest nieokreślona
        System.out.println("Set niepowtarzalnych elementów, z niezdefiniowaną kolejnością");
        for (CollectionsCar car : setOfCars) {
            System.out.println(car);
        }

        //LinkedHashSet trzyma elementy w kolejności wprowadzenia
        Set<CollectionsCar> linkedSet = new LinkedHashSet<>();
        linkedSet.add(car1);
        linkedSet.add(car2);
        linkedSet.add(car3);
        linkedSet.add(car4);
        System.out.println("\nLinkedHashSet przechowuje elementy w kolejności wprowadzania:");
        for (CollectionsCar car : linkedSet) {
            System.out.println(car);
        }

        //TreeSet trzyma elementy zgodnie z zaimplementowanym komparatorem w klasie CollectionsCar
        Set<CollectionsCar> sortedSet = new TreeSet<>();
        sortedSet.addAll(linkedSet);
        System.out.println("\nSet posortowany alfabetycznie po silniku");
        for (CollectionsCar car : sortedSet) {
            System.out.println(car);
        }
    }
}
