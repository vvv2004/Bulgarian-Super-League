package ReaderWriter;
import Classes.*;
import ProjectUtils.Position;

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

    public Player[] getPlayersFromTeam(String pathToTeam) throws IOException {
        Player[] players = new Player[16];
        String pathToPlayers = pathToTeam + "/Players";

        File file = new File(pathToPlayers);
        File[] playersAsFiles = file.listFiles();
        int i = 0;

        for(File player : playersAsFiles){
            players[i] = new Player();
            //Gets the full player info
            String currentPlayerInfo = getPlayerInfo(pathToPlayers + "/" + player.getName());
            //Sets the name of the player
            players[i].setName(getSpecificPlayerInfo(currentPlayerInfo, "name"));
            //Sets the overall of the player
            players[i].setOverall(Integer.parseInt(getSpecificPlayerInfo(currentPlayerInfo, "overall")));
            //Sets the age of the player
            players[i].setAge(Integer.parseInt(getSpecificPlayerInfo(currentPlayerInfo, "age")));
            //Sets the position of the player
            String position = getSpecificPlayerInfo(currentPlayerInfo, "position");
            switch (position){
                case "f":
                    players[i].setPosition(Position.FORWARD);
                    break;
                case "m":
                    players[i].setPosition(Position.MIDFIELDER);
                    break;
                case "d":
                    players[i].setPosition(Position.DEFENDER);
                    break;
                case "g":
                    players[i].setPosition(Position.GOALKEEPER);
                    break;
            }

            //Sets the number of the player
            players[i].setNumber(getSpecificPlayerInfo(currentPlayerInfo, "number"));
            //Sets the number of the player
            players[i].setNationality(getSpecificPlayerInfo(currentPlayerInfo, "nationality"));


            i++;
        }

        return players;
    }

    //Взима цялостната информация за играч
    public String getPlayerInfo(String path) throws IOException{
        String pathToPlayer = path;


        String playerInfo = "";

        scan = new Scanner(new File(pathToPlayer));

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
}
