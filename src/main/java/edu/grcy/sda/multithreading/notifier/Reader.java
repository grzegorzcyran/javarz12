package edu.grcy.sda.multithreading.notifier;

import java.util.Random;

import static edu.grcy.sda.multithreading.ThreadColor.ANSI_PURPLE;

public class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        //w pętli czytamy kolejne wiadomości z message.read()
        //dopóki nie wystąpi wiadomość "EOF"
        for(String latestMessage = message.read(); latestMessage != "EOF"; latestMessage = message.read()) {
            //wypisujemy na ekran
            System.out.println(ANSI_PURPLE + "Odczytano nową wiadomość:");
            System.out.println(ANSI_PURPLE + latestMessage);
            try {
                //usypiamy wątek na losowy okres czasu
                //ale nie więcej niż 4 sekundy
                //bo random.nextInt() przyjmuje okres w milisekundach
                Thread.sleep(random.nextInt(4000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
