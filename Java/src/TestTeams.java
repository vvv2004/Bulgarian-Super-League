import Classes.*;
import ProjectUtils.*;
import ReaderWriter.*;
import Addresses.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class TestTeams {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> teamAddresses = TeamAddresses.loadTeamAddresses();
        Reader reader = new Reader();


        Team dunavRuse = Team.loadTeamFromDatabase(teamAddresses.get("Botev Plovdiv"));


        for (Player player : dunavRuse.getPlayers()) {
            System.out.println(player.toString());
        }

        for (Coach coach : dunavRuse.getCoaches()) {
            System.out.println(coach.toString());
        }

        System.out.println(dunavRuse.teamInfo());
    }
}
