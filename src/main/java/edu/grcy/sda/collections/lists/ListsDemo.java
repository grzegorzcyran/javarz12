package edu.grcy.sda.collections.lists;

import edu.grcy.sda.collections.CollectionsCar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsDemo {
    public static void main(String[] args) {
        CollectionsCar car1 = new CollectionsCar("Volvo", "Diesel 2.0", 220);
        CollectionsCar car2 = new CollectionsCar("Ford", "Gasoline 1.6", 215);
        CollectionsCar car3 = new CollectionsCar("BMW", "Gasoline 3.0", 260);
        CollectionsCar car4 = new CollectionsCar("Fiat", "Diesel 1.4", 180);

        //definicja kolekcji przed Java 1.7
        //po prawej w nawiasach ostrych trzeba było pisać typ
        List<CollectionsCar> oldStyleList = new ArrayList<CollectionsCar>();

        List<CollectionsCar> carArrayList = new ArrayList<>();
        carArrayList.add(car1);
        carArrayList.add(car2);
        carArrayList.add(car3);
        carArrayList.add(car4);
        carArrayList.add(car1);
        System.out.println("Drukujemy zawartość listy");
        //Arraylista więc można odnosić się po indeksie
        for (int i = 0; i < carArrayList.size(); i++) {
            System.out.println(carArrayList.get(i));
        }

        //Kolejność elementów za pomocą tzw węzłów
        List<CollectionsCar> linkedListCars = new LinkedList<>();
        linkedListCars.add(car1);
        linkedListCars.add(car4);
        linkedListCars.add(car2);
        linkedListCars.add(car3);
        linkedListCars.add(car4);
        System.out.println("\nDrukujemy elementy listy linkowanej");
        for (CollectionsCar linkedListCar : linkedListCars) {
            System.out.println(linkedListCar);
        }
    }
}
