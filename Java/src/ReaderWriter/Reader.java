package ReaderWriter;
import Classes.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    private String path;
    private String teamInfoFile;
    Scanner scan;

    public Reader(){
        path = "../Teams";
        teamInfoFile  = "team_info.txt";
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

    public String getSpecificTeamInfo(String teamInfo, String typeOfInfo) {
        String output = "";

        Scanner scan = new Scanner(teamInfo);

        while(scan.hasNextLine()){
            String dataInRow = scan.nextLine();

            if(dataInRow.contains(typeOfInfo)){
                output += dataInRow;
                break;
            }
        }

        String[] splitData = output.split("=");

        return splitData[1];
    }
}
