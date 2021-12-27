package Classes;

import java.util.HashMap;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private String resultAsString;
    private int[] resultAsIntegerArray = new int[2];
    HashMap<Integer, Double> scoringChanceTable;


    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Match() {
    }

    public static boolean playAttack(Team attackingTeam, Team defendingTeam){


        return false;
    }

    public static void playMatch(){

    }
}
