package ReaderWriter;

import Classes.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Writer {
    private String path;

    public Writer(){
        path = "../Teams";
    }

    public void setFullTeamInfo(Team teamObject, String conference, String team) throws IOException {
        String path = this.path + '/' + conference + '/' + team + "/team_info.txt";
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(teamObject.toString());
        fileWriter.close();
    }
}
