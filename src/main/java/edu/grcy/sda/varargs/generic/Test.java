package edu.grcy.sda.varargs.generic;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Cat> cats = Lists.createArrayList(new Cat("Mruczek"), new Cat("Filemon"));
        cats.forEach(x -> System.out.println(x.getName()));

    }
}
