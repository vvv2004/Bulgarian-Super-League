package ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Writer {
    private String path;

    public Writer(){
        path = "../Teams";
    }

    public void setSpecificTeamInfo(String conference, String team, String typeOfData) throws IOException {
        String path = this.path + '/' + conference + '/' + team + "/team_info.txt";

        Reader r = new Reader();

        String teamInfo = r.getTeamInfo(conference, team);
        

        FileWriter fileWriter = new FileWriter(path);

    }
}
