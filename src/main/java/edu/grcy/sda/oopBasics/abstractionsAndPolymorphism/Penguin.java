package edu.grcy.sda.oopBasics.abstractionsAndPolymorphism;

public class Penguin extends Bird {

    @Override
    public void move() {
        System.out.println("Penguin is a bird, yet cannot fly!");
    }
}
