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
        Writer write = new Writer();


        Team dunavRuse = Team.loadTeamFromDatabase(teamAddresses.get("Dunav Ruse"));
        dunavRuse.setPathToTeamData(teamAddresses.get("Dunav Ruse"));

        for (Player player : dunavRuse.getPlayers()) {
            System.out.println(player.toString());
        }

        for (Coach coach : dunavRuse.getCoaches()) {
            System.out.println(coach.toString());
        }

        System.out.println(dunavRuse.teamInfo());

        dunavRuse.setName("Слабаците");
        dunavRuse.getPlayers()[2].setNationality("bulgarian");
        write.writeTeamInfo(dunavRuse);
        write.writePlayersData(dunavRuse);
        System.out.println("\n\n");

        for (Player player : dunavRuse.getPlayers()) {
            System.out.println(player.toString());
        }

        for (Coach coach : dunavRuse.getCoaches()) {
            System.out.println(coach.toString());
        }

        System.out.println(dunavRuse.teamInfo());
    }
}
