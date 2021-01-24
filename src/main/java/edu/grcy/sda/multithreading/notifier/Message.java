package edu.grcy.sda.multithreading.notifier;

import static edu.grcy.sda.multithreading.ThreadColor.*;

public class Message {
    private String messageContent;
    //messageEmpty jest znacznikiem który mówi czy do obiektu klasy Message
    //można aktualnie przekazać nową wiadomość czy też
    //jakaś właśnie jest w trakcie przetwarzania
    private boolean messageEmpty = true;

    //odczytujemy wiadomość
    //synchronized więc odczytywać może tylko 1 wątek na raz
    public synchronized String read() {
        //dopóki nie ma nic do odczytu to czekaj
        //messageEmpty musi zostać ustawione na false w metodzie write()
        while(messageEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(ANSI_GREEN + "Błąd odczytu wiadomości");
            }
        }
        //jak tu doszliśmy to znaczy że messageEmpty jest równe false
        //czyli jest jakaś wiadomość do obsłużenia
        System.out.println(ANSI_GREEN + "Odczytujemy wiadomość:");
        System.out.println(ANSI_GREEN + messageContent);
        //po odczytaniu wiadomości ustaw znacznik spowrotem na true
        messageEmpty = true;
        //notifyAll powiadamia wszelkie inne wątki że bieżący kończy działanie
        //wszelkie inne na których działa metoda wait() mogą próbować działać
        notifyAll();
        //notify zamiast notifyAll powoduje powiadomienie 1 wątku który jest w trakcie wait()
        //i to jest losowy z czekających wątków
        //notify();
        return messageContent;
    }

    //synchronized czyli 1 wątek na raz może tą metodę wykonywać
    public synchronized void write(String newMessage) {
        //jeśli znacznik mówi że jest jakaś wiadomość to nie można wpisać nowej
        //i trzeba czekać na notify() / notifyAll() z innego wątku
        while(!messageEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(ANSI_BLUE + "Błąd zapisu wiadomości");
            }
        }
        //ktoś zrobił notify / notifyAll więc wpisujemy nową wiadomość
        System.out.println(ANSI_BLUE + "Nowa wiadomość zapisana:");
        System.out.println(ANSI_BLUE + newMessage);
        //ustawiamy znacznik że nowa wiadomość wpisana i należy ją obsłużyć
        messageEmpty = false;
        messageContent = newMessage;
        //powiadamiamy inne wątki że metoda write kończy działanie
        notifyAll();
    }
}
