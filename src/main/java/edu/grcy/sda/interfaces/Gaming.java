package edu.grcy.sda.interfaces;

public interface Gaming {
    void playGame();

    //od Javy8 w interfejsie można definiować
    //tzw metody domyślne
    //czyli metody z domyślną implementacją
    default boolean isWinner(int points) {
        return true;
    }
}
