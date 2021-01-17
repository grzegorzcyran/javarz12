package edu.grcy.sda.multithreading.basics;

import static edu.grcy.sda.multithreading.ThreadColor.ANSI_RED;

public class RunnableSample implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Runnable sample working as well!");
    }
}
