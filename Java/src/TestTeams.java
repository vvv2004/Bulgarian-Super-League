import Classes.Player;
import ProjectUtils.Position;
import ReaderWriter.*;

import java.io.IOException;

public class TestTeams {
    public static void main(String[] args) throws IOException {
        Player testPlayer = new Player("Ivan", 16, "Bulgarian", Position.MIDFIELDER, 75);

        System.out.println(testPlayer.getPosition());

        Reader read = new Reader();
        String teamInfo = "";
        String goalDifference = "";
        String playerInfo = "";

        try {
            teamInfo = read.getTeamInfo("WEST", "Bdin Vidin");
            goalDifference = read.getSpecificTeamInfo(teamInfo, "goalDifference");
            playerInfo = read.getPlayerInfo("WEST", "Botev Vratsa", "Dorian Babunski");
        }catch(IOException e){
            System.out.println(e);
        }
        System.out.println(teamInfo);
        System.out.println("\nGoal difference only: " + goalDifference);
        System.out.println(playerInfo);
        System.out.println("Dorian Babunski's overall + 5: " + (Integer.parseInt(read.getSpecificPlayerInfo(playerInfo, "overall")) + 5));
        System.out.println("Coach info: ");

        //System.out.println(read.getSpecificPlayerInfo(read.getPlayerInfo("WEST", "Botev Vratsa", "Dorian Babunski"), "position"));
    }
}
