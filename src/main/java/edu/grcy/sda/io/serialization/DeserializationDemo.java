package edu.grcy.sda.io.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {

    /**
     * Deserializacja to proces odwrotny do serializacji
     * czyli tym razem zamieniamy strumień danych na obiekt
     *
     * !!!Jak mamy obiekt zserializowany do pliku czy gdzieś
     * i zmodyfikujemy klasę dodając metodę, zmieniając kod
     * czy cokolwiek, to już nie odczytamy tych obiektów
     * bo Java powie że to niezgodna klasa!!!
     */
    public static void main(String[] args) {
        SerializedPerson person = null;

        try (FileInputStream fis = new FileInputStream("SerializedPerson.data");
             ObjectInputStream ois = new ObjectInputStream(fis);
        ) {

            person = (SerializedPerson) ois.readObject();

            System.out.println(person);
            System.out.println(person.getFullName());
            System.out.println("Person id = " + person.getId());

            //zbędne jak zasoby deklarujemy w try(resources){
            //ois.close();
            //fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
