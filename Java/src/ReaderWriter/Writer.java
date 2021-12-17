package ReaderWriter;

import Classes.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Writer {
    public void writeAllTeamData(){}

    public void writePlayerData(){}
    public void writeCoachesData(){}

    public void writeTeamInfo(Team team) throws IOException{
        File file = new File(team.getPathToTeamData() + "/team_info.txt");
        FileWriter fw = new FileWriter(file);
        String writeTeamInfo = team.teamInfo();
    }
}
