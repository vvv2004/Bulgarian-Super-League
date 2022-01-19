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

        System.out.println("ЗАРЕЖДАНЕ НА ОТБОРИТЕ...");
        Team[] teams = LoadingAndSaving.loadAllTeamFromData();
        System.out.println("ОТБОРИТЕ СА ЗАРЕДЕНИ!\n");

        printTeams(teams);

        System.out.println("\nМОЛЯ ИЗБЕРЕТЕ ИНДЕКСИТЕ НА ДВАТА ОТБОРА, КОИТО ИСКАТЕ ДА СЕ ИЗПРАВЯТ ЕДИН СРЕЩУ ДРУГ!");
        Match match1 = new Match(teams[scan.nextInt()], teams[scan.nextInt()]);
        match1.playMatch();


        System.out.println("Краен резултат: \n" + match1.getResult() + '\n' + match1.getWinningMessage());
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
