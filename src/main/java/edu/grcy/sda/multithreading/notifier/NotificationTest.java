package edu.grcy.sda.multithreading.notifier;

public class NotificationTest {
    public static void main(String[] args) {
        Message message = new Message();

        /**
         * Każdy z wątków ma własny stos pamięci,
         * ale korzystają ze wspólnej sterty pamięci.
         *
         * Na stosie odkłada się zmienne lokalne (int, double, char[], short, long)
         * Na stercie odkłada się wszelkie obiekty (w naszym przykładzie Message)
         * Na stercie będą też obiekty typu Integer, Double, Long... czyli Wrappery
         * Czyli obiekt klasy Message jest WSPÓLNY dla wątków Reader i Writer
         *
         * String nie jest odkładany na wspólnej stercie
         * Ma on dedykowany obszar pamięci zwany StringPool
         *
         */


        //przy wątkach pamiętamy że nadpisujemy metodę run()
        //ale watek uruchamiamy metodą start
        (new Thread(new Writer(message))).start(); // anonimowe wywołanie wątku na klasie Writer

        //jawne wywołanie wątku
        Thread readerThread = new Thread(new Reader(message));
        readerThread.start();

        /**
         * Cykl życia :
         * 1. Writer próbuje wykonać metodę message.write()
         *  - jeśli w message nie ma innej wiadomości czekającej na obsłużenie
         *    to zapisuje i powiadamia innych że skończył
         *  - jeśli w message jest inna wiadomość to czeka aż ta poprzednia
         *    wiadomość zostanie obsłużona i wtedy zapisuje i powiadamia innych
         *
         * 2. Reader próbuje wykonać message.read()
         *  - jeśli w message nie ma wiadomości do odczytania to czeka aż taka
         *    wiadomość się pojawi
         *  - jeśli w message jest wiadomość to ją odczytuje i powiadamia innych
         *    że skończył, a do obiektu message można wpisać kolejną wiadomość
         *  - jak wiadomość = "EOF" to reader kończy wszelkie odczyty
         */
    }
}
