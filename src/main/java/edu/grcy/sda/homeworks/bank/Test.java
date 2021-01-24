package edu.grcy.sda.homeworks.bank;

import java.util.Arrays;
import java.util.List;

public class Test {
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
