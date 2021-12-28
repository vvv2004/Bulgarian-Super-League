package ProjectUtils;

import Addresses.TeamAddresses;
import Classes.Team;
import ReaderWriter.Reader;
import ReaderWriter.Writer;

import java.io.IOException;
import java.util.Map;

public class LoadingAndSaving {
    public static void saveAllTeamData(Team[] teams) throws IOException {
        Writer write = new Writer();

        for (Team team : teams) {
            write.writeAllTeamData(team);
        }
    }

    public static Team[] loadAllTeamFromData() throws IOException {
        Reader read = new Reader();
        Team[] output = new Team[20];

        int i = 0;
        for (Map.Entry<String, String> items: TeamAddresses.loadTeamAddresses().entrySet()){
            output[i] = Team.loadTeamFromDatabase(items.getValue());
            i++;
        }


        return output;
    }
}
