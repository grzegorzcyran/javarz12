package edu.grcy.sda.generics;

public class FootballTeam extends Team {
    private TeamLevel teamLevel;

    public FootballTeam(String name, TeamLevel teamLevel) {
        //this(name) sięga do innego konstruktora tej samej klasy
        this(name);
        this.teamLevel = teamLevel;
    }

    public FootballTeam(String name) {
        //super(name) sięga do konstruktora klasy którą rozszerzamy
        super(name);
    }
}
