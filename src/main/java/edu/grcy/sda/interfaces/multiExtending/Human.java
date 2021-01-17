package edu.grcy.sda.interfaces.multiExtending;

public class Human implements Student, Performer {
    @Override
    public void perform() {
        System.out.println("Perform method implementation");
    }

    @Override
    public void study() {
        System.out.println("Study method implementation");
    }

    /**
     * implementacja work() jest zarówno dla interfejsu Worker
     * jak i Trainer bo w obu mamy tą samą abstrakcyjną
     * metodę work()
     */
    @Override
    public void work() {
        System.out.println("Work method implementation");
    }

    @Override
    public void obtainPlan() {
        System.out.println("Obtain plan method implementation");
    }
}
