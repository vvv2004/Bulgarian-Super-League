package ReaderWriter;
import Classes.*;

import java.util.Scanner;

public class Reader {
    private String path;
    Scanner scan;

    public Reader(){
        path = "../Teams";
    }

    public String getTeamInfo(String conference, String team){
        Team team1 = new Team();

        String teamInfo = team1.toString();

        Player[] player = new Player[16];


        return teamInfo;
    }
}
