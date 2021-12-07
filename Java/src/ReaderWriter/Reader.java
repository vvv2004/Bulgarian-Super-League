package ReaderWriter;
import Classes.*;
import ProjectUtils.CoachRoles;
import ProjectUtils.Position;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Reader {

    public Reader(){}



    //Взима цялостната информация за играч
    public String getInfo(String path) throws IOException{
        Scanner scan;

        String playerInfo = "";

        scan = new Scanner(new File(path));

        while(scan.hasNextLine()){
            playerInfo += scan.nextLine();
            playerInfo += '\n';
        }

        return playerInfo;
    }

    //Изкарва конкретна информация зза играч
    public String getSpecificInfo(String info, String typeOfInfo) {
        String output = "";

        Scanner scan = new Scanner(info);

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


    public Player[] loadPlayersFromTeam(String pathToTeam) throws IOException {
        Player[] players = new Player[16];
        String pathToPlayers = pathToTeam + "/Players";

        File file = new File(pathToPlayers);
        File[] playersAsFiles = file.listFiles();
        int i = 0;

        for(File player : playersAsFiles){
            players[i] = new Player();
            //Gets the full player info
            String currentPlayerInfo = getInfo(pathToPlayers + "/" + player.getName());
            //Sets the name of the player
            players[i].setName(getSpecificInfo(currentPlayerInfo, "name"));
            //Sets the overall of the player
            players[i].setOverall(Integer.parseInt(getSpecificInfo(currentPlayerInfo, "overall")));
            //Sets the age of the player
            players[i].setAge(Integer.parseInt(getSpecificInfo(currentPlayerInfo, "age")));
            //Sets the position of the player
            String position = getSpecificInfo(currentPlayerInfo, "position");
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
            players[i].setNumber(getSpecificInfo(currentPlayerInfo, "number"));
            //Sets the number of the player
            players[i].setNationality(getSpecificInfo(currentPlayerInfo, "nationality"));


            i++;
        }

        return players;
    }


    public Coach[] loadCoachesFromTeam(String pathToTeam) throws IOException {
        Coach[] output = new Coach[3];
        String pathToCoaches = pathToTeam + "/Coaches";

        File file = new File(pathToCoaches);
        File[] coachesAsFiles = file.listFiles();

        int i = 0;

        for (File coachAsFile : coachesAsFiles) {
            String currentCoachInfo = getInfo(pathToCoaches + '/' + coachAsFile.getName());
            output[i] = new Coach();

            output[i].setName(getSpecificInfo(currentCoachInfo, "name"));
            output[i].setAge(Integer.parseInt(getSpecificInfo(currentCoachInfo, "age")));
            output[i].setNationality(getSpecificInfo(currentCoachInfo, "nationality"));
            output[i].setOverall(Integer.parseInt(getSpecificInfo(currentCoachInfo, "overall")));
            switch (getSpecificInfo(currentCoachInfo, "role")){
                case "general":
                    output[i].setRole(CoachRoles.GENERAL);
                    break;
                case "assistant":
                    output[i].setRole(CoachRoles.ASSISTANT);
                    break;
                case "conditional":
                    output[i].setRole(CoachRoles.CONDITIONAL);
                    break;
                default:
                    System.out.println("Something went wrong!");
                    break;
            }

            i++;
        }

        return output;
    }

    public String
}
