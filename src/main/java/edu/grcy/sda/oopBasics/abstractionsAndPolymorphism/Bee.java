package edu.grcy.sda.oopBasics.abstractionsAndPolymorphism;

public class Bee extends Worm {
    @Override
    public void hibernate() {
        System.out.println("Winter is coming, let's sleep!");
    }

    @Override
    public void move() {
        System.out.println("Bee is flying");
    }
}
