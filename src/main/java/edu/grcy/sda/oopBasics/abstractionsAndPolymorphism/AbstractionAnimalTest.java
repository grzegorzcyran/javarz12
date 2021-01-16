package edu.grcy.sda.oopBasics.abstractionsAndPolymorphism;

import java.lang.reflect.Field;

public class AbstractionAnimalTest {
    public static void main(String[] args) {
        //Animal animal = new Animal(); nie można zdefiniować obiektu z klasy abstrakcyjnej

        Animal animal; //to jest ok
        //ale niedopuszczalne jest new Animal();

        Bird bird = new Bird();
        bird.move();

        Fish fish = new Fish();
        fish.move();

        Penguin penguin = new Penguin();
        penguin.move();

        Bee bee = new Bee();
        bee.move();
    }
}
