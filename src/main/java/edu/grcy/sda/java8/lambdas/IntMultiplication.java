package edu.grcy.sda.java8.lambdas;

@FunctionalInterface
public interface IntMultiplication {
    //zdefiniować że to interfejs funkcyjny
    //dodać metodę ktora pomnoży 2 przekazane liczby
    //wywołać ją jako lambdę

    int multiply(int a, int b);
}
