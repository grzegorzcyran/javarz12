package edu.grcy.sda.io.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {

    /**
     * Serializacja to zamiana obiektu na strumień danych
     * który można następnie zapisać do pliku, wysłać siecią,
     * itp...
     *
     * Można dzięki temu zrobić np backup (kopię zapasową danych)
     * albo przesłać obiekty do innego komputera (albo kontenera)
     * i tam utworzyć (!!!niemal!!!)dokładnie taki sam obiekt
     * bez klepania go od początku
     *
     * Żeby na obiekcie można było zrobić serializację, konieczne jest
     * aby implementował interfejs Serializable
     * Jest to interfejs tzw. znacznikowy, czyli nie wymusza
     * implementacji żadnej metody, tylko oznacza obiekt jako spełniający
     * jego kryteria
     */
    public static void main(String[] args) {

        SerializedPerson person = new SerializedPerson(22, "Jan", "Kowalski", 33);
        try {
            FileOutputStream fOut = new FileOutputStream("SerializedPerson.data");
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);

            oOut.writeObject(person);

            //przy try-with-resources niepotrzebne bo klasa po której
            //dziedziczy ObjectOutputStream implementuje Closeable
            oOut.close();
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
