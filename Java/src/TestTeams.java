import Classes.*;
import ProjectUtils.*;
import ReaderWriter.*;
import Addresses.*;

import java.io.IOException;
import java.util.Arrays;
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
        Team[] teams = loadAllTeamFromData();
        System.out.println("Done loading!");

        teams[14].setNickname("Silnite");
        teams[14].setCity("QKiq grad");

        int exit = scan.nextInt();

        System.out.println("Saving teams data...");
        saveAllTeamData(teams);
        System.out.println("Done saving!");
        System.out.println(read.getTeamInfo(teams[14].getPathToTeamData()));
    }

    public static void saveAllTeamData(Team[] teams) throws IOException{
        Writer write = new Writer();

        for (Team team : teams) {
            write.writeAllTeamData(team);
        }
    }

    public static Team[] loadAllTeamFromData() throws IOException {
        Reader read = new Reader();
        Team[] output = new Team[20];


        for (Map.Entry<String, String> items: TeamAddresses.loadTeamAddresses().entrySet()){
            for (int i = 0; i < output.length; i++) {
                output[i] = Team.loadTeamFromDatabase(items.getValue());
            }
        }


        return output;
    }
}
