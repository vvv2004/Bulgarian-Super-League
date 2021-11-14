import Classes.Player;
import ProjectUtils.Position;
import ReaderWriter.*;

import java.io.IOException;

public class TestTeams {
    public static void main(String[] args) {
        Player testPlayer = new Player("Ivan", 16, "Bulgarian", Position.MIDFIELDER, 75);

        System.out.println(testPlayer.getPosition());

        Reader read = new Reader();
        String teamInfo = "";
        String goalDifference = "";

        try {
            teamInfo = read.getTeamInfo("WEST", "Bdin Vidin");
            goalDifference = read.getSpecificTeamInfo(teamInfo, "goalDifference");
        }catch(IOException e){
            System.out.println(e);
        }
        System.out.println(teamInfo);
        System.out.println("\nGoal difference only: " + goalDifference);


    }
}
