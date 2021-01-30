package edu.grcy.sda.generics;

public abstract class Team implements Comparable<Team> {
    private String name;
    private int points;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(Team otherTeam) {
        //porównanie drużyn ilością zdobytych punktów
        return otherTeam.getPoints() - points;
    }
}
