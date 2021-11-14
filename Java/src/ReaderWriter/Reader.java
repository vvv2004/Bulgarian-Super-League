package ReaderWriter;
import Classes.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    private String path;
    Scanner scan;

    public Reader(){
        path = "../Teams";
    }

    public String getTeamInfo(String conference, String team) throws IOException{
        String path = this.path + '/' + conference + '/' + team + "/team_info.txt";

        String teamInfo = "";

        scan = new Scanner(new File(path));

        while(scan.hasNextLine()){
            teamInfo += scan.nextLine();
            teamInfo += '\n';
        }

        return teamInfo;
    }

    public String getSpecificTeamInfo(String conference, String team, String typeOfInfo) throws IOException {
        String path = this.path + '/' + conference + '/' + team;

        scan = new Scanner(new File(path));

        return null;
    }
}
