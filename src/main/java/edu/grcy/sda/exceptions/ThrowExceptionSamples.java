package edu.grcy.sda.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowExceptionSamples {
    public void sleepThread() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void sleepThreadAndReadFile() throws InterruptedException, FileNotFoundException {
        Thread.sleep(5000);
        new FileReader("anyfile.ccc");
    }

    //jeden ogólny wyjątek zamiast 2 szczegółowych
    public void sleepAndReadFileOneException() throws Exception {
        Thread.sleep(5000);
        new FileReader("aaa.ccc");
    }

    //zestaw metod z wyjątkami
    public void sleepEx2() throws InterruptedException {
        Thread.sleep(5000);
        throw new InterruptedException();
    }

    public void readFileEx2() throws FileNotFoundException {
        new FileReader("aaa");
    }

    //mamy ogólny wyjątek
    //ale jak coś się wysypie to stos wywołań doprowadzi nas
    // do rzeczywistego powodu
    public  void sleepAndReadFileEx2() throws Exception {
        sleepEx2();
        readFileEx2();
    }

    public static void main(String[] args) {
        ThrowExceptionSamples samples = new ThrowExceptionSamples();
        try {
            samples.sleepAndReadFileEx2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
