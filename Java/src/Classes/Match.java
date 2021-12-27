package Classes;

public class Match {
    private Team[] teamsPlaying = new Team[2];
    private String resultAsString;
    private int[] resultAsIntegerArray = new int[2];

    public Match(Team[] teamsPlaying, String resultAsString, int[] resultAsIntegerArray) {
        this.teamsPlaying = teamsPlaying;
        this.resultAsString = resultAsString;
        this.resultAsIntegerArray = resultAsIntegerArray;
    }

    public Match() {
    }

    public static boolean playAttack(){



        return false;
    }

    public static void playMatch(){

    }
}
