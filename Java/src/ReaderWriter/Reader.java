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


    //Взима цялостната информация за отбор
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


    //Изкарва специфична информация за играч
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


    //Взима цялостната информация за играч
    public String getPlayerInfo(String conference, String team, String player) throws IOException{
        String path = this.path + '/' + conference + '/' + team + "/Players/" + player + ".txt";


        String playerInfo = "";

        scan = new Scanner(new File(path));

        while(scan.hasNextLine()){
            playerInfo += scan.nextLine();
            playerInfo += '\n';
        }

        return playerInfo;
    }

    //Изкарва конкретна информация зза играч
    public String getSpecificPlayerInfo(String playerInfo, String typeOfInfo) {
        String output = "";

        Scanner scan = new Scanner(playerInfo);

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

    //Взима пълната информация за човек от щаба
    public String getStaffInfo(String conference, String team, String staff) throws IOException{
        String path = this.path + '/' + conference + '/' + team + "/Staff/" + staff + ".txt";


        String staffInfo = "";

        scan = new Scanner(new File(path));

        while(scan.hasNextLine()){
            staffInfo += scan.nextLine();
            staffInfo += '\n';
        }

        return staffInfo;
    }

    //Изкарва конкретна информация за човек от щаба
    public String getSpecificStaffInfo(String staffInfo, String typeOfInfo) {
        String output = "";

        Scanner scan = new Scanner(staffInfo);

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
