package League;
import Classes.*;
import ReaderWriter.*;
import ProjectUtils.*;
import Addresses.*;

import java.io.IOException;

public class League{
    private Team[] teams = new Team[20];

    public League(){
        try {
            teams = LoadingAndSaving.loadAllTeamFromData();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public Team[] orderTeamsByPoints(){
        Team[] output = teams;

        int n = output.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (output[j].getPoints() > output[j + 1].getPoints()) {
                    Team temp = output[j];
                    output[j] = output[j + 1];
                    output[j + 1] = temp;
                }
            }
        }
        return output;
    }

    public Team[] orderTeamsByGoalsScored(){
        Team[] output = teams;

        int n = output.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (output[j].getGoalsScored() > output[j + 1].getGoalsScored()) {
                    Team temp = output[j];
                    output[j] = output[j + 1];
                    output[j + 1] = temp;
                }
            }
        }
        return output;
    }

    public Team[] orderTeamsByGoalsAllowed(){
        Team[] output = teams;

        int n = output.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (output[j].getGoalAllowed() > output[j + 1].getGoalAllowed()) {
                    Team temp = output[j];
                    output[j] = output[j + 1];
                    output[j + 1] = temp;
                }
            }
        }
        return output;
    }

    public Team[] orderTeamsByGoalDifference(){
        Team[] output = teams;

        int n = output.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (output[j].getGoalDifference() > output[j + 1].getGoalDifference()) {
                    Team temp = output[j];
                    output[j] = output[j + 1];
                    output[j + 1] = temp;
                }
            }
        }
        return output;
    }

}
