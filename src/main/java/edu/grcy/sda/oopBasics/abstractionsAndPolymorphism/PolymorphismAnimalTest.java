package edu.grcy.sda.oopBasics.abstractionsAndPolymorphism;

public class PolymorphismAnimalTest {

    public static void main(String[] args) {
        //klasyka bez polimorfizmu
        Bee bee = new Bee();
        bee.move();
        bee.hibernate();

        Penguin penguin = new Penguin();
        penguin.move();

        //wywołania z polimorfizmem
        Animal polyBee = new Bee();
        polyBee.move();
        //Rzutowanie do Bee żeby wywołać hibernate
        ((Bee) polyBee).hibernate();

        Animal polyPenguin = new Penguin();
        polyPenguin.move();
        //to poniżej kończy się błędem bo pingwin nie może być pszczołą
        ((Bee) polyPenguin).hibernate();

        /**
         * Polimorfizm działa w tą stronę że pingwin albo pszczoła są zwierzętami
         * ale nie każde zwierze jest pingwinem / pszczołą
         */
        //Bee anotherBee = new Animal();



    }
}
