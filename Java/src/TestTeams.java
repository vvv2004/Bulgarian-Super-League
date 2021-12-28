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

        Match match1 = new Match(teams[9], teams[16]);
        match1.playMatch();

        System.out.println(match1.getResult());

        /*
        int exit = scan.nextInt();
        System.out.println("Saving teams data...");
        LoadingAndSaving.saveAllTeamData(teams);
        System.out.println("Done saving!");
         */
    }




    public static void printTeams(Team[] teams){
        for (Team team :
                teams) {
            System.out.println(team.getName());
        }
    }

}
