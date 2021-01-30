package edu.grcy.sda.generics.fullGeneric;

import edu.grcy.sda.generics.FootballTeam;
import edu.grcy.sda.generics.Team;
import edu.grcy.sda.generics.TeamLevel;
import edu.grcy.sda.generics.VolleyballTeam;

public class LeagueMain {
    public static void main(String[] args) {
        League league = new League("Pirmiera Division");

        Team team1 = new FootballTeam("FC Barcelona", TeamLevel.PROFESSIONAL);
        Team team2 = new FootballTeam("Atletico de Madrid", TeamLevel.PROFESSIONAL);
        Team team3 = new FootballTeam("Real Madrid CF", TeamLevel.PROFESSIONAL);
        Team team4 = new FootballTeam("Valencia CF", TeamLevel.PROFESSIONAL);
        team1.setPoints(20);
        team2.setPoints(25);
        team3.setPoints(28);
        team4.setPoints(29);
        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);
        league.addTeam(team4);
        league.printTable();
        System.out.println(" = = = = = = = = = = = ");
        Team team5 = new VolleyballTeam("Asseco Resovia", TeamLevel.PROFESSIONAL);
        team5.setPoints(27);
        league.addTeam(team5);
        league.printTable();

    }
}
