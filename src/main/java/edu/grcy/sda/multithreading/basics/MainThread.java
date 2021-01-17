package edu.grcy.sda.multithreading.basics;

import static edu.grcy.sda.multithreading.ThreadColor.*;

public class MainThread {
    public static void main(String[] args) {

        /**
         * Kolejność działania wątków, a co z tym związane
         * kolejność wyświetlania na ekranie jest nieokreślona
         */
        System.out.println(ANSI_PURPLE + "Main thread in action!");

        OtherThread otherThread = new OtherThread();
        otherThread.setName("=== Nowy zajefajny wątek ===");
        /**
         * Metoda start()
         * Powołuje nowy wątek, zapewnia zasoby czasu procesora i pamięć
         * Jak to wszystko jest gotowe to uruchamia run() już w osobnym wątku
         * Metoda start() nie powinna zawierać kodu użytkownika
         */
        //do uruchomienia nowego wątku zawsze metoda start();
        otherThread.start();

        /**
         * Metoda run()
         * Zawiera kod do wywołania w osobnym wątku
         * Sama nie powołuje wątku, jeśli zostanie wywołana bez osobnego wątku
         * To też się wykona
         */
        //otherThread.run();

        //Uruchomienie wątku z klasy implementującej Runnable
        Thread runnableSample = new Thread(new RunnableSample());
        runnableSample.start();

        //Jednorazowa akcja do wykonania w osobnym wątku - na klasie anonimowej
        /**
         *  klasa anonimowa to taka konstrukcja gdzie tworzymy nowy obiekt
         *  nie nadając mu nazwy - czyli obiekt jest i działa, ale ponieważ
         *  nie ma nazwy to nie można się do niego później wcale odnieść,
         *  nie da się go znaleźć, więc jest na jednorazowe akcje typu
         *  "odpal i zapomnij"
         */
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Anonymous class can run thread too!");
            }
        }.start();

        //Przerwanie wątku
        //otherThread.interrupt();

        //łączenie watków metodą join();
        //nadpiszemy (jednorazowo) istniejący kod RunnableSample
        runnableSample = new Thread(new RunnableSample() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Overwritten RunnableSample working!!");
                try {
                    /**
                     * join() powoduje że runnableSample zatrzymuje się i czeka aż
                     * otherThread skończy swoje działanie i dopiero później kontunuuje
                     *
                     * przykład z generowaniem raportu do pliku:
                     * runnableSample zapisuje do pliku nagłówek i dane, nagłówek jest znany
                     * a dane są obliczane przez otherThread
                     * runnableSample robi plik i zapisuje nagłówek
                     * i czeka aż dostanie dane z otherThread żeby uzupełnić plik
                     * jak już ma dane to kontynuuje zapisywanie
                     */
                    otherThread.join(6000);
                    System.out.println(ANSI_RED + "Overwritten RunnableSample working as OtherThread finished!");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "INTERRRUPTED Overwritten RunnableSample :(");
                }
            }
        });
        runnableSample.start();

        /**
         * runnableSample.interrupt() powoduje że nie czekamy na zakończenie otherThread
         * tylko kontynuujemy działanie naszego wątku runnableSample
         *
         * jednocześnie nie przerywa to działania wątku otherThread, on sobie działa,
         * tyle że już na nie czekamy
         */
        //runnableSample.interrupt();

        System.out.println(ANSI_PURPLE + "End of main thread");
    }
}
