import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadData{

    public static String readPlayerData(String path, String info) throws IOException
    {
        Scanner scan = new Scanner(new File(path));
        String data = "";

        while(scan.hasNext()) {
            if(scan.hasNext(info))
            {
                data = scan.nextLine();
            }
        }

        return data;
    }
}
