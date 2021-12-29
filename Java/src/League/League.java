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

        for(){

        }

        return output;
    }
}
