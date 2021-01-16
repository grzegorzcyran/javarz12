package edu.grcy.sda.collections.maps;

import edu.grcy.sda.collections.CollectionsCar;

import java.util.HashMap;
import java.util.Map;

public class MapsDemo {
    public static void main(String[] args) {
        CollectionsCar car1 = new CollectionsCar("Volvo", "Diesel 2.0", 220);
        CollectionsCar car2 = new CollectionsCar("Ford", "Gasoline 1.6", 215);
        CollectionsCar car3 = new CollectionsCar("BMW", "Gasoline 3.0", 260);
        CollectionsCar car4 = new CollectionsCar("Fiat", "Diesel 1.4", 180);

        //Mapa<klucz, wartość>
        //klucze muszą być unikalne
        Map<String, CollectionsCar> mapOfCarsByName = new HashMap<>();
        mapOfCarsByName.put(car1.getName(), car1);
        mapOfCarsByName.put(car1.getName(), car1);
        //jak klucz jest inny to można pod nim przechować
        //kolejny raz tą samą wartość
        mapOfCarsByName.put("Other Volvo", car1);
        mapOfCarsByName.put(car2.getName(), car2);
        mapOfCarsByName.put(car3.getName(), car3);
        mapOfCarsByName.put(car4.getName(), car4);

        System.out.println("Drukujemy zawartość mapy pobierając zestaw values()");
        for (CollectionsCar car : mapOfCarsByName.values()) {
            System.out.println(car);
        }

        System.out.println("\n======\nDrukujemy zestaw kluczy");
        for (String key : mapOfCarsByName.keySet()) {
            System.out.println(key);
        }

        System.out.println("\n======\nDrukujemy zestaw wartości pobierając je kluczami");
        for (String key : mapOfCarsByName.keySet()) {
            //pobierz wartość z mapy dla której klucz jest...
            System.out.println(mapOfCarsByName.get(key));
        }

        System.out.println("\n======\nDrukowanie po zestawie klucz + wartość");
        for (Map.Entry<String, CollectionsCar> carEntry : mapOfCarsByName.entrySet()) {
            System.out.println("Klucz : " + carEntry.getKey());
            System.out.println("Wartość : \n" + carEntry.getValue() + "\n");
        }


        mapOfCarsByName.put(car4.getName(), car4); //taki element już jest pod kluczem car4.getName
        CollectionsCar car5 = new CollectionsCar("VW Passat", "2.0TDi", 240);
        mapOfCarsByName.put(car4.getName(), car5);

        System.out.println("Drukujemy zawartość mapy pobierając zestaw values() - kolejny raz");
        for (CollectionsCar car : mapOfCarsByName.values()) {
            System.out.println(car);
        }

        //usuwamy jak zgadza się klucz
        mapOfCarsByName.remove("Volvo");
        System.out.println("\nPróbujemy usunąć element z kluczem Volvo");
        for (CollectionsCar car : mapOfCarsByName.values()) {
            System.out.println(car);
        }

        //usuwamy jak zgadza się para klucz i wartość
        mapOfCarsByName.remove("Ford", car1);
        System.out.println("\nPróbujemy usunąć Ford car1");
        for (CollectionsCar car : mapOfCarsByName.values()) {
            System.out.println(car);
        }

        //usuwamy jak zgadza się para klucz i wartość
        mapOfCarsByName.remove("Fiat", car5);
        //mapOfCarsByName.remove("Fiat");
        System.out.println("\nPróbujemy usunąć Fiat car5");
        for (CollectionsCar car : mapOfCarsByName.values()) {
            System.out.println(car);
        }



    }
}
