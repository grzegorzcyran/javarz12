package edu.grcy.sda.homeworks.bank;

import java.util.Arrays;
import java.util.List;

public class Test {

    /**
     * Volatile czyli oznaczenie że wartość w polu jest ulotna,
     * największe zastosowanie w aplikacjach wielowątkowych
     * Jak oznaczymy tak pole to jest informacja dla JVMa
     * że przy jego użyciu (odczycie) ma za każdym razem
     * sięgnąć do oryginalnej wartości a nie np. do cache
     */
    private volatile String anyField;
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Dominik", "Tomek", "Krzysiek");

    }

    public String getStringFromList(List<String> list) {
        StringBuilder methodWord = new StringBuilder();
        for (String word : list) {
            methodWord.append(word) ;
        }
        return methodWord.toString();
    }
}
