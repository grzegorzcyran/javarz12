package edu.grcy.sda.interfaces.multiExtending;

public class TestMultiInterfaces {
    public static void main(String[] args) {
        Human human = new Human();

        human.work();
        human.perform();
        human.study();
        human.obtainPlan();
    }
}
