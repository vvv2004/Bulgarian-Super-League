package ReaderWriter;

import Classes.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


public class Writer{
    public void writeAllTeamData(Team team) throws IOException{
        writeCoachesData(team);
        writePlayersData(team);
        writeTeamInfo(team);
    }

    public void writeCoachesData(Team team) throws IOException{
        Coach[] coachesInTeam = team.getCoaches();
        Reader read = new Reader();
        File file = new File(team.getPathToTeamData() + "/Coaches");
        File[] coachesAsFiles = file.listFiles();
        int i = 0;

        for (File playerAsFile : coachesAsFiles) {
            for (Coach coach : coachesInTeam) {
                //If player name equals the name in the file
                if(coach.getName().equals(read.getSpecificInfo(read.getInfo(team.getPathToTeamData() + "/Coaches/" + playerAsFile.getName()), "name"))){
                    FileWriter fw = new FileWriter(playerAsFile);
                    String writePlayerInfo = coach.toString();
                    fw.write(writePlayerInfo);
                    fw.close();
                }
            }
        }
    }


    public void writePlayersData(Team team) throws IOException{
        Player[] playersInTeam = team.getPlayers();
        Reader read = new Reader();
        File file = new File(team.getPathToTeamData() + "/Players");
        File[] playersAsFiles = file.listFiles();
        int i = 0;

        for (File playerAsFile : playersAsFiles) {
            for (Player player : playersInTeam) {
                //If player name equals the name in the file
                if(player.getName().equals(read.getSpecificInfo(read.getInfo(team.getPathToTeamData() + "/Players/" + playerAsFile.getName()), "name"))){
                    FileWriter fw = new FileWriter(playerAsFile);
                    String writePlayerInfo = player.toString();
                    fw.write(writePlayerInfo);
                    fw.close();
                }
            }
        }
    }

    public void writeTeamInfo(Team team) throws IOException{
        File file = new File(team.getPathToTeamData() + "/team_info.txt");
        FileWriter fw = new FileWriter(file);
        String writeTeamInfo = team.toString();
        fw.write(writeTeamInfo);
        fw.close();
    }
}
