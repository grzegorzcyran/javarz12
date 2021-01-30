package edu.grcy.sda.generics.withBoundaries;

import edu.grcy.sda.generics.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * League<T extends Team> oznacza że do klasy będzie przekazywany jakiś
 * obiekt dziedziczący po Team lub sama klasa Team
 *
 * !!W naszym przypadku klasy Team nie można przekazać bo jest abstrakcyjna
 */
public class League<T extends Team> {
    private String leagueName;
    private List<T> teams; // lista obiektów o typie przekazanym do klasy - OK

    public League(String leagueName) {
        this.leagueName = leagueName;
        this.teams = new ArrayList<>();
    }

    /**
     * metoda bez problemu przyjmuje generyczny typ rozszerzający Team - OK
     */
    public boolean addTeam(T team) {
        if (!teams.contains(team)) {
            return teams.add(team);
        }
        return false;
    }

    /**
     * metoda nie wymusza już rzutowania bo wiadomo że "pochodna" klasy Team
     * będzie miała możliwość sortowania, będzie miała dostęp do metod
     * getName i getPoints
     *
     * TERAZ TA METODA JEST OK - JEŚLI MAMY TYP GENERYCZNY Z OGRANICZENIEM
     */
    public void printTable() {
        Collections.sort(teams);
        System.out.println(leagueName + " table:");
        teams.forEach(x -> System.out.println(x.getName() + " " + x.getPoints()));
    }
}
