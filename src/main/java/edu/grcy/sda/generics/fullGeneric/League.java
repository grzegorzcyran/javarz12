package edu.grcy.sda.generics.fullGeneric;

import edu.grcy.sda.generics.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * League<T> oznacza że do klasy będzie przekazywany jakiś
 * obiekt o niekoreślonym na ten moment typie
 */
public class League<T> {
    private String leagueName;
    private List<T> teams; // lista obiektów o typie przekazanym do klasy - OK

    public League(String leagueName) {
        this.leagueName = leagueName;
        this.teams = new ArrayList<>();
    }

    /**
     * metoda bez problemu przyjmuje generyczny (nieokreślony typ) - OK
     */
    public boolean addTeam(T team) {
        if (!teams.contains(team)) {
            return teams.add(team);
        }
        return false;
    }

    /**
     * metoda wymusza rzutowanie typu generycznego - NIE OK
     * metoda nie nadaje się do klasy generycznej
     */
    public void printTable() {
        //musimy rzutować bo kompilator nie wie
        //czy typ T da się sorotwać, a klasa Team implementuje Comparable więc
        //wiadomo że się da
        Collections.sort((List<Team>) teams);
        System.out.println(leagueName + " table:");
        //analogicznie poniżej, typ T niekoniecznie ma metody getName() i getPoints()
        //dlatego konieczne jest określenie tego przed kompilacją
        teams.forEach(x -> System.out.println(((Team) x).getName() + " " + ((Team) x).getPoints()));
    }
}
