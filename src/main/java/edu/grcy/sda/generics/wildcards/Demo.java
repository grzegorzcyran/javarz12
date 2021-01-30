package edu.grcy.sda.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Image image1 = new Image("Obrazek 1");
        Image image2 = new Image("Zdjęcie 1");
        Memento memento1 = new Memento(new Note("Pamiątka z wakacji"));
        Memento memento2 = new Memento(new Note("Pamiątka z ferii zimowych"));
        Picture picture1 = new Picture(new Note("Fotka znad morza"), image1);
        Picture picture2 = new Picture(new Note("Fotka z gór"), image2);

        List<Memento> memories = new ArrayList<>();
        memories.add(memento1);
        memories.add(memento2);
        memories.add(picture1);
        memories.add(picture2);

        MemoriesSaver<Memento> album = new MemoriesSaver<>();
        album.printAllMemories(memories);
        System.out.println("+++++++++++++++++++++++++++");
        album.addAllMemories(memories);
        album.printInternalMemories();
        System.out.println("+++++++++++++++++++++++++++");
        List<Picture> picturesOnly = new ArrayList<>();
        picturesOnly.add(picture1);
        picturesOnly.add(picture2);
        /**
         * Wywołanie printAllMemories dla picturesOnly nie zadziała bo
         * JVM spodziewa się listy List<Memento>
         *     a dostaje List<Picture>
         * i mimo że Picture jest klasą pochodną od Memento to nie umie tego obsłużyć
         * bo List<Picture> nie jest klasą pochodną od List<Memento>
         *
         * czyli nawet jak klasa B rozszerza klasę A
         * to Kolekcja(B) nie rozszerza Kolejcja(A)
         *
         * i do tego właśnie potrzebny jest operator wildcard czyli ? (pytajnik - typ nieokreślony)
         *
         */
        //album.printAllMemories(picturesOnly);
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("Drukujemy tylko obrazkowe pamiątki:");
        album.printWildcardAllMemories(picturesOnly);
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("Drukujemy wszystkie pamiątki:");
        album.printWildcardAllMemories(memories);
    }
}
