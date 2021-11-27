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


        Team ardaKardzhali = new Team();
        ardaKardzhali.setPlayers(reader.loadPlayersFromTeam(teamAddresses.get("Arda Kardzhali")));

        for (Player player : ardaKardzhali.getPlayers()) {
            System.out.println(player.toString());
        }
    }
}
