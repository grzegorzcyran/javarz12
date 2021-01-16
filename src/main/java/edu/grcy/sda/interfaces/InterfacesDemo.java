package edu.grcy.sda.interfaces;

public class InterfacesDemo {

    public static void main(String[] args) {
        User user = new User("Witcher 3 Wild Hunt");
        user.playGame();
        user.code("C#");

        Coding coder = new User("RDR2");
        coder.code("Java");
        //rzutowanie żeby wywołać playGame
        ((User) coder).playGame();
    }
}
