package edu.grcy.sda.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalsDemo {
    public static void main(String[] args) {
        List<Human> people = new ArrayList<>();
        //3 obiekty tworzone pierwszym konstruktorem, gdzie deklarujemy enum
        people.add(new Human("Jan", "Kowalski", 33, Gender.MAN));
        people.add(new Human("Adam", "Nowak", 44, Gender.MAN));
        people.add(new Human("Alicja", "Zioło", 25, Gender.WOMAN));

        //3 obiekty tworzone drugim konstruktorem gdzie podajemy jedno z pól enuma i korzystamy
        //z metody statycznej do znalezienia właściwego elementu Gender
        people.add(new Human("Marcin", "Kowalski", 18, "M"));
        people.add(new Human("Teresa", "Kowalski", 65, "K"));
        people.add(new Human("Marta", "Fideluk", 17, "K"));

        String findTrump = people.stream()
                .filter(check -> "Trump".equalsIgnoreCase(check.getSurname()))
                .map(Human::getSurname)
                .findAny()
                //orElse jeśli ma zwrócić stałą (String, int, double...)
                .orElse("Nie znam człowieka");
        System.out.println("Mamy Trumpa? : " + findTrump);

        Optional<String> findLechu = people.stream()
                .filter(sss -> "Lechu".equalsIgnoreCase(sss.getName()))
                .map(Human::getName)
                .findFirst();

        if(findLechu.isPresent()) {
            System.out.println("Lechu ? : " + findLechu.get());
        } else {
            System.out.println("Lecha nie ma");
        }
        System.out.println("=========================");
        System.out.println("Filter, optional i orElse");
        Human filteredHuman = people.stream()
                .filter(a -> "Marcin".equals(a.getName()))
                .findFirst()
                //jak mamy metodę to orElse jest słabszym rozwiązaniem
                //bo zawartość metody wykona się zawsze, niezależnie czy trzeba czy nie
                .orElse(getDefaultHuman("N", "N", 0, "M"));
        System.out.println("Filtered human:");
        System.out.println(filteredHuman);

        System.out.println("A teraz przy użyciu orElseGet");
        Human anotherFiltered = people.stream()
                .filter(c -> c.getName().equals("Marcin"))
                .findFirst()
                //jak mamy metodę to orElseGet jest preferowane
                //bo zawartość metody wykona się tylko jeśli będzie to niezbędne
                .orElseGet(() -> getDefaultHuman("N", "N", 0, "M"));
        System.out.println("Another filtered");
        System.out.println(anotherFiltered);

    }

    private static Human getDefaultHuman(String name, String surname, int age, String gender) {
        System.out.println("Jestem w metodzie dorabiającej domyślnego człowieka");
        return new Human(name, surname, age, gender);
    }
}
