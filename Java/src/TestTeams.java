import Classes.*;
import ProjectUtils.*;
import ReaderWriter.*;
import Addresses.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestTeams {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> teamAddresses = TeamAddresses.loadTeamAddresses();
        Reader read = new Reader();
        Writer write = new Writer();

        System.out.println("Loading teams...");
        Team[] teams = LoadingAndSaving.loadAllTeamFromData();
        System.out.println("Done loading!\n");

        printTeams(teams);

        Match match1 = new Match(teams[scan.nextInt()], teams[scan.nextInt()]);
        match1.playMatch();


        System.out.println("Краен резултат: \n" + match1.getResult() + '\n' + match1.getWinningMessage());

        /*
        int exit = scan.nextInt();
        System.out.println("Saving teams data...");
        LoadingAndSaving.saveAllTeamData(teams);
        System.out.println("Done saving!");
         */
    }

    public static void printTeams(Team[] teams){
        int i = 0;
        for (Team team :
                teams) {
            System.out.println(i + " " + team.getName());
            i++;
        }
    }

}
