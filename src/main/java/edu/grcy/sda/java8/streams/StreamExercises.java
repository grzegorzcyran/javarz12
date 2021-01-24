package edu.grcy.sda.java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Zasadą działania strumienia jest Pantha Rei
 * czyli "wszystko płynie"
 * czyli nie da się drugi raz wejść do tego samego strumienia
 *
 * Metody działające na strumieniach dzielimy na 3 grupy:
 * 1. Metody tworzące strumień - musi wystąpić jedna:
 *  - stream() na kolekcjach
 *  - of() na elementach wyliczonych
 *  - Arrays.stream(Object[]) na elementach tabeli
 *  - na danych z pliku, ...
 *  - ... z każdą kolejną Javą pojawia się coś nowego
 *
 * 2. Metody pośrednie - można łączyć, nie musi wystąpić żadna:
 *  - map - przekształcająca element strumienia w inny (np Human -> String, String -> String)
 *  - flatMap - spłaszczająca elementy z kilku strumieni do jednego strumienia z wszystkimi elementami
 *  - filter - filtrująca elementy strumienia wg zadanego kryterium
 *  - limit - ograniczająca ilość elementów do dalszego przetważania
 *  - sorted - sortująca wg domyślnego albo wskazanego komparatora
 *  - distinct - wybierająca elementy niepowtarzalne
 *  -...
 *
 * 3. Metody kończące strumień - musi wystąpić jedna:
 *  - toArray - tworzy tablicę z elementów strumienia
 *  - collect - tworzy kolekcję z elementów strumienia
 *  - reduce - zwraca jedną wartosć wg zadanego mechanizmu
 *  - count - zwraca ilość elementów
 *  - findFirst - zwraca optionala od pierwszego znalezionego obiektu (który spełnia wcześniejsze kryteria)
 *  - findAny - zwraca optionala od dowolnego znalezionego obiektu (który spełnia wcześniejsze kryteria)
 *  - forEach - nic nie zwraca, wykonuje działanie na elementach strumienia
 *  - ...
 */

public class StreamExercises {
    public static void main(String[] args) {

        //DTO czyli Data Transfer Object
        //czyli klasa pomocnicza która ma przechowywać wycinek większego obiektu
        //lub złożenia obiektów do wykorzystania w jakimś przetwarzaniu lub do
        //przesyłu danych gdzieś (sieć, inna baza danych, na stronę www)
        class HumanDTO {
            String name;
            String surname;

            public HumanDTO(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }

            public String getHumanData() {
                return surname + " " + name;
            }
        }

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

        //klasyczna postać for
//        System.out.println("===========================");
//        System.out.println("Klasyczny for po ludziach");
//        for(Human human : people) {
//            //sout(human) zawoła human.toString()
//            System.out.println(human);
//        }
//        System.out.println("===========================");
        //forEach (dla każdego)
        //System.out::println - to odwołanie do metody przez tzw. referencję
        //w naszym przypadku oznacza to:
        //weź każdy kolejny element kolekcji people
        //czyli kolejne obiekty Human
        //i na każdym z nich wywoła System.out.println
//        System.out.println("ForEach po ludziach, jeszcze z wywołaniem przez referencję");
//        people.forEach(System.out::println);
//        System.out.println("===========================");
//        System.out.println("ForEach po ludziach z użyciem lambdy");
//        //jeszcze postać z lambdą
//        people.forEach(x -> System.out.println(x));
        System.out.println("===========================");

        System.out.println("Ludzie którzy mają więcej niż 20 lat");
        System.out.println("!!!!Najpierw klasycznie!!!!");
        for (Human person : people) {
            if(person.getAge() > 20) {
                System.out.println(person);
            }
        }
        System.out.println("!!!!A TERAZ STREAM JAVA8!!!!");
        //stream() czyli z kolekcji (albo tablicy) zrób strumień obiektów
        //żeby po kolei wykonywać na nich następne operacje
        people.stream()
                //filter() pozwala odsiać obiekty strumienia
                //które nie spełniają zadanego kryterium
                //kryterium może być proste jak niżej, ale może też być
                //bardziej skomplikowane (przykłady za chwilę)
                .filter(x -> x.getAge() > 20)
                .forEach(System.out::println);
        System.out.println("===========================");
        System.out.println("Ludzie powyżej 20 lat, tylko mężczyźni");
        System.out.println("2 filtry");
        people.stream()
                .filter(x -> x.getAge() > 20)
                .filter(x -> Gender.MAN == x.getGender())
                .forEach(System.out::println);

        System.out.println("Ludzie powyżej 20 lat, tylko mężczyźni");
        System.out.println("filtr kombinowany i M zamiast Gender.MAN");
        people.stream()
                .filter(x -> x.getAge() > 20 && "M".equals(x.getGender().getShortcutPl()))
                .forEach(System.out::println);
        System.out.println("Ludzie powyżej 20 lat, tylko mężczyźni");
        System.out.println("!!!filtr kombinowany wywoływany z metody!!!");
        people.stream()
                //tożsame w sensie działania zapisy poniżej
                //.filter(Human::isOver20AndGenderMan)
                .filter(x -> x.isOver20AndGenderMan())
                .forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("Ze strumienia / kolekcji wypisać tylko 2 obiekty");
        int counter = 0;
        for (Human person : people) {
            System.out.println(person);
            counter++;
            if(counter >= 2) {
                break;
            }
        }
        System.out.println("!!A teraz to samo strumieniowo!!");
        people.stream()
                .limit(2) //metoda ograniczająca ilość obiektów na wyjściu
                .forEach(System.out::println);

        System.out.println("++!!++ 2 ludzi poniżej 30 lat ++!!++");
        people.stream()
                //limit zafiltruje nam do 2 pierwszych wyników
                //i jeśli pod spodem mamy filtrowanie
                //to ono już odbywa się na tych 2 elementach tylko
                //.limit(2)
                .filter(x -> x.getAge() < 30)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("Ludzie posortowani po nazwisku");
        System.out.println("++++ Klasycznie ++++");
        //Collections.sort(people); //tu metoda sort wykorzystuje domyślny komparator
        people.forEach(System.out::println);
        System.out.println("++++ Po nowemu ++++");
        people.stream()
                .sorted() //używamy domyślnego komparatora z klasy Human
                .forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("Ludzie posortowani po imonach");
        System.out.println("++++ Klasycznie ++++");
        //Collections.sort(people, new HumanComparedByName()); //tu metoda sort korzysta z komparatora zewnętrznego
        people.forEach(System.out::println);
        System.out.println("++++ Po nowemu ++++");
        System.out.println("++++++ Opcja 1 ++++++");
        people.stream()
                .sorted(new HumanComparedByName())
                .forEach(System.out::println);
        System.out.println("++++ Po nowemu ++++");
        System.out.println("++++++ Opcja 2 - bez klasy zewnętrznej++++++");
        people.stream()
                .sorted(Comparator.comparing(Human::getAge))
                .forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("Nowa kolekcja gdzie będą tylko mężczyźni");
        List<Human> menOnly = new ArrayList<>();
        for (Human person : people) {
            if (Gender.MAN == person.getGender()) {
                menOnly.add(person);
            }
        }
        menOnly.forEach(System.out::println);
        System.out.println("Nowa kolekcja gdzie będą tylko kobiety");
        System.out.println("Używamy metody collect()");
        List<Human> womanOnly = new ArrayList<>();
        womanOnly = people.stream()
                .filter(x -> Gender.WOMAN == x.getGender())
                //można posortować po wieku (reversed() zadziała malejąco)
                //.sorted(Comparator.comparing(Human::getAge).reversed())
                //poniżej filter() mamy już tylko obiekty - kobiety
                //ale to jest dalej stream i trzeba go przekształcić
                //do postaci wyjściowej (a my chcemy listę)
                .collect(Collectors.toList());
        womanOnly.forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("Wypisać tylko nazwisko i imię z people");
        System.out.println("++++ Pętlą for ++++");
        for (Human human : people) {
            System.out.println(human.getSurname() + " " + human.getName());
        }
        System.out.println("++++ Pętlą forEach ++++");
        people.forEach(x -> System.out.println(x.getSurname() + " " + x.getName()));
        System.out.println("++++ Stream ++++");
        System.out.println("++++ W samym forEach ++++");
        people.stream()
            .forEach(x -> System.out.println(x.getSurname() + " " + x.getName()));
        System.out.println("++++ Stream ++++");
        System.out.println("++++ Z przekształceniem obiektu ++++");
        people.stream()
                //metoda map() powoduje przekształcenie obiektu w inny
                //w naszym przypadku z obiektu Human robi String
                .map(x -> x.getSurname() + " " + x.getName())
                .forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("Przepisujemy wszystkich ludzi do HumanDTO");
        List<HumanDTO> humanDTOS = new ArrayList<>();
        //pętla po people
        for (Human human : people) {
            //możemy zrobić tak jak poniżej że do humanDTOs dodajemy obiekt bez nazwy
            //czyli inaczej klasę anonimową
            humanDTOS.add(new HumanDTO(human.getName(), human.getSurname()));
            //a możnaby zrobić tak:
            //HumanDTO localHumanDTO = new HumanDTO(human.getName(), human.getSurname());
            //humanDTOS.add(localHumanDTO);
        }
        System.out.println("Print z DTOS'ów");
        humanDTOS.forEach(x -> System.out.println(x.getHumanData()));

        System.out.println("++++ A teraz to samo ale streamem ++++");
        List<HumanDTO> humanDTOSfromStream = new ArrayList<>();
        humanDTOSfromStream = people.stream()
                //obiekt wejściowy Human, obiekt wyjściowy HumanDTO
                .map(x -> new HumanDTO(x.getName(), x.getSurname()))
                .collect(Collectors.toList());
        System.out.println("Print z DTOS'ów ze streama");
        humanDTOSfromStream.forEach(x -> System.out.println(x.getHumanData()));

        System.out.println("===========================");
        System.out.println("złączyć 2 kolekcje menOnly i womenOnly w nową i wypisać zawartość");
        List<Human> newCommonHumankind = new ArrayList<>();
        newCommonHumankind.addAll(womanOnly);
        newCommonHumankind.addAll(menOnly);
        newCommonHumankind.forEach(System.out::println);
        System.out.println("===========================");
        System.out.println("złączyć 2 kolekcje menOnly i womenOnly w nową i wypisać zawartość STREAMEM");
        List<Human> newFromStreamHumankind = new ArrayList<>();
        //Stream.of robi streama z podanych obiektów
        newFromStreamHumankind = Stream.of(menOnly, womanOnly)
                //po wyjściu ze Stream.of mamy strumień 2-elementowy
                //gdzie elementy strumienia to lista kobiet i lista mezczyzn
                //a metoda flatmap robi nam z tych dwóch elementów strumienia
                //nowy strumien ludzi
                //
                //inaczej: flatMap zamienia nam strumień list ludzi
                //na strumień ludzi
                //Stream(List<Human>) -> Stream(Human)
                //.flatMap(a -> a.stream())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        newFromStreamHumankind.forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("++++ Reduce - suma lat wszystich ludzi ++++");
        int sumOfAge = people.stream()
                .map(Human::getAge) // na wyjściu jest Stream<Integer>
                // Reduce:
                // 1. Zaczynamy od 0
                // 2. Dla każdego kolejnego elementu wykonujemy:
                //  - weź dotychczasową sumę
                //  - i dodaj nowyy element strumienia
                .reduce(0, (suma, nowy) -> suma + nowy);
        System.out.println("Suma lat wszystkich ludzi łącznie:" + sumOfAge);

        System.out.println("===========================");
        System.out.println("++++ Reduce - zwracamy 1 String łączący wszystkie imiona ++++");
        String namesJoined = people.stream()
                .map(Human::getName)
                .collect(Collectors.joining());
        System.out.println("Names joined: " + namesJoined);
        System.out.println("===========================");
        System.out.println("++++ Zwracamy 1 String łączący wszystkie nazwiska, z przecinkami ++++");
        String surnamesJoinedWithCommas = people.stream()
                .map(Human::getSurname)
                .collect(Collectors.joining(", "));
        System.out.println("Surnames joined with commas: " + surnamesJoinedWithCommas);

        System.out.println("===========================");
        System.out.println("++++ Zwracamy 1 String łączący wszystkie nazwiska, z przecinkami++++");
        System.out.println("++++ i nawiasami przed i po ++++");
        String jSonStyleSurnames = people.stream()
                .map(Human::getSurname)
                //.collect(Collectors.joining(", ", "{", "}"));
                .collect(Collectors.joining("), (", "{(", ")}"));
        System.out.println("Surnames with commas and brackets : " + jSonStyleSurnames);

        System.out.println("===========================");
        System.out.println("Z listy zrobimy mapę gdzie kluczem będzie imię a wartością obiekt Huma");
        Map<String, Human> mapPeopleByName = people.stream()
                .collect(Collectors.toMap(Human::getName, x -> x));
        System.out.println("klucze");
        mapPeopleByName.keySet().forEach(System.out::println);
        System.out.println("obiekty mapy");
        mapPeopleByName.values().forEach(System.out::println);
        System.out.println("klucz i pod spodem obiekt");
        mapPeopleByName.keySet().stream()
                .map(x -> x + "\n" + mapPeopleByName.get(x))
                .forEach(System.out::println);

        Map<String, List<Human>> peopleGroupedBySurname = new HashMap<>();
        //mamy listę ludzi, robimy mapę gdzie kluczem jest nazwisko i dla każdego nazwiska
        //możemy trzymać listę ludzi
        peopleGroupedBySurname = people.stream()
                .collect(Collectors.groupingBy(Human::getSurname, Collectors.toList()));
        System.out.println("++++++++");
        System.out.println("Odzyskujemy tylko Kowalskich do osobnej listy - jeśli nie ma to ");
        System.out.println("Zwracamy pustą listę");
        System.out.println("Drukujemy tylko Kowalskich");
        List<Human> kowalscy = peopleGroupedBySurname.entrySet()
                .stream()
                .filter(mapEntry -> mapEntry.getKey().equals("Kowalskii"))
                .map(aaa -> aaa.getValue())
                //findFirst zwraca Optional, jeśli nie znajdzie obiektu to wykona się orElseGet
                .findFirst()
                //w orElseGet zapewniamy to co ma się wykonać / podstawić jeśli nie znajdzie się
                //właściwy obiekt
                .orElseGet(() -> Collections.EMPTY_LIST);
        kowalscy.forEach(System.out::println);




    }
}
