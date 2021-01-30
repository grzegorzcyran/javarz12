package edu.grcy.sda.varargs.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Chcąc stworzyć listę i napełnić ją obiektami musimy robić:
 * List<Kot> cats = new ArrayList<>();cats.add(new Kot("Mruczek"));
 * cats.add(new Kot("Filemon"));
 *
 * Musicie przyznać że to dosyć niewygodne.
 * Napiszmy więc klasę Lists, a w niej statyczną metodę generyczną createArrayList,
 * która przyjmie dowolną liczbę parametrów (varargs) i utworzy z niej ArrayList,
 * która zostanie zwrócona.List<Kot> = Lists.createArrayList(new Kot("Mruczek"), new Kot("Filemon"));
 * W rezultacie chcemy, aby oba zapisy dały ten sam efekt.
 */
public class Lists {
    public static <T> List<T> createArrayList(T... elements) {
        List<T> returnList = new ArrayList<>();
        for (T element : elements) {
            returnList.add(element);
        }
        return returnList;
    }
}
