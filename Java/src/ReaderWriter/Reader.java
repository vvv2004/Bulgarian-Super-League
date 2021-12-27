package ReaderWriter;
import Classes.*;
import ProjectUtils.CoachRoles;
import ProjectUtils.Position;

import java.io.File;
import java.io.IOException;
import java.security.spec.ECField;
import java.util.Scanner;

public class Reader {

    public Reader(){}


    public String getInfo(String path) throws IOException{
        Scanner scan;

        String info = "";

        scan = new Scanner(new File(path));

        while(scan.hasNextLine()){
            info += scan.nextLine();
            info += '\n';
        }

        return info;
    }

    //Изкарва конкретна информация
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

        if(splitData.length > 1){
            return splitData[1];
        }

        return null;
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
            output[i].setNationality(getSpecificInfo(currentCoachInfo, "nationality"));
            output[i].setOverall(Integer.parseInt(getSpecificInfo(currentCoachInfo, "overall")));
            output[i].setAge(Integer.parseInt(getSpecificInfo(currentCoachInfo, "age")));

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
                    System.out.println(coachAsFile.getName() + pathToCoaches);
                    break;
            }

            i++;
        }

        return output;
    }

    public String getTeamInfo(String pathToTeam) throws IOException{
        String output = "";
        String pathToInfo = pathToTeam + "/team_info.txt";

        output = getInfo(pathToInfo);


        return output;
    }
}