package edu.grcy.sda.multithreading.notifier;

import java.util.Random;

public class Writer implements Runnable {
    private Message message;
    private String[] messagesToWrite = {"Linia 1", "Linia 2", "Linia 3", "Linia 4"};

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();

        //prześlij wszystkie wiadomości z tabeli
        for(int i = 0; i < messagesToWrite.length; i++) {
            message.write(messagesToWrite[i]);
            try {
                //usypiamy wątek na nie więcej niż 4 sekundy
                Thread.sleep(random.nextInt(4000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //na koniec transmisji wyślij wiadomość "EOF"
        message.write("EOF");
    }
}
