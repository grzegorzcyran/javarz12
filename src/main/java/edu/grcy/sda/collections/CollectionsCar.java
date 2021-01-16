package edu.grcy.sda.collections;

import java.util.Objects;

public class CollectionsCar implements Comparable<CollectionsCar> {
    private String name;
    private String engine;
    private Integer maxSpeed;
    private String color;

    //Autoboxing (opakowanie) maxSpeed -> z inta robimy Integer
    public CollectionsCar(String name, String engine, int maxSpeed) {
        this.name = name;
        this.engine = engine;
        this.maxSpeed = maxSpeed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color != null //jeśli kolor nie jest nullem
                ? getColorAsExists() //to go zwrócić
                : ""; //a jak nie to coś innego
    }

    private String getColorAsExists() {
        //System.out.println("Kolor istnieje to go wypisujemy");
        return color;
    }

    private String getColorNotExists() {
        return "Not specified";
    }

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "CollectionsCar{" +
                "name='" + name + '\'' +
                ", engine='" + engine + '\'' +
                ", maxSpeed='" + maxSpeed + '\'' +
                //color wypiszemy o ile nie jest nullem
                (color != null ? ", color='" + color + '\'' : ", color='" + getColorNotExists()) + "'" +
                '}';
    }

    //zwraca numer identyfikujący nasz obiekt
    //może być unikalny ale niekoniecznie
    //powinien pozwalać na podział obiektów tej samej klasy
    //na mniejsze podzbiory
    @Override
    public int hashCode() {
        //wyliczamy na podstawie pól
        //o których wiemy że będą niepuste
        //i decydują o niepowtarzalności obiektu
        //w ramach naszych kryteriów
        return Objects.hash(name, engine, maxSpeed);
    }

    //ma za zadanie jednoznacznie porównać obiekt "nasz" z podanym w parametrze
    @Override
    public boolean equals(Object obj) {

        //porównanie referencji, czyli miejsca w pamięci
        //w którym leży nasz obiekt z miejscem w pamięci
        //gdzie leży obiekt do porównania, jeśli to
        //to samo miejsce to jest to też ten sam obiekt
        if(this == obj) {
            return true;
        }

        //jeśli do porównania przekazany null
        //albo klasa naszego obiektu i przekazanego obiektu
        //są różne, to nie jest to ten sam obiekt
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        //nie wywaliło się w poprzednim sprawdzaniu więc
        // to rzutowanie jest bezpieczne
        CollectionsCar car = (CollectionsCar) obj;

        return maxSpeed == car.maxSpeed &&
                name.equals(car.name) &&
                engine.equalsIgnoreCase(car.engine);
    }

    @Override
    public int compareTo(CollectionsCar anotherCar) {
        return engine.compareTo(anotherCar.engine);

        //domyślne sortowanie od największego do najmniejszego silnika:
        //return anotherCar.getEngine().compareTo(this.engine);
    }
}
