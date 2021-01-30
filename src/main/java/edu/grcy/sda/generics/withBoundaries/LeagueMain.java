package edu.grcy.sda.generics.withBoundaries;

import edu.grcy.sda.generics.FootballTeam;
import edu.grcy.sda.generics.Team;
import edu.grcy.sda.generics.TeamLevel;
import edu.grcy.sda.generics.VolleyballTeam;

public class LeagueMain {
    public static void main(String[] args) {
        League<FootballTeam> league = new League("Pirmiera Division");

        FootballTeam team1 = new FootballTeam("FC Barcelona", TeamLevel.PROFESSIONAL);
        FootballTeam team2 = new FootballTeam("Atletico de Madrid", TeamLevel.PROFESSIONAL);
        Team team3 = new FootballTeam("Real Madrid CF", TeamLevel.PROFESSIONAL);
        Team team4 = new FootballTeam("Valencia CF", TeamLevel.PROFESSIONAL);
        team1.setPoints(20);
        team2.setPoints(25);
        team3.setPoints(28);
        team4.setPoints(29);
        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam((FootballTeam) team3);
        league.addTeam((FootballTeam) team4);
        league.printTable();
        System.out.println(" = = = = = = = = = = = ");

        VolleyballTeam team5 = new VolleyballTeam("Asseco Resovia", TeamLevel.PROFESSIONAL);
        team5.setPoints(27);
        //league.addTeam(team5); nie zadziała bo team5 jest typu VooleyballTeam
        //league.addTeam((FootballTeam) team5); nie zadziała jak powyżej, rzutowanie ręczne też zgłasza błąd

        Team team6 = new VolleyballTeam("Zaksa", TeamLevel.PROFESSIONAL);
        team6.setPoints(35);
        //league.addTeam((FootballTeam) team6); // skompiluje się ale wywali przy wykonaniu


        //league.printTable();

        System.out.println(team6.getName());



    }
}
