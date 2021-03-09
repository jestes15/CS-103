import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class utilityFunctions
{
    public static void writeBufferedWriter(String data, String getDirectory, String getFileName) throws IOException
    {
        String[] OS = OsInfo();
        String errorPath = System.getProperty("user.dir") + OS[0];
        String errorPathToFile = System.getProperty("user.dir") + OS[0] + "ERROR-1.txt";

        String path = System.getProperty("user.dir") + getDirectory;
        String pathToFile = System.getProperty("user.dir") + getDirectory + getFileName + ".txt";

        File file = new File(path);
        File fileWrite = new File(pathToFile);
        if (file.mkdir()) {
            System.out.println("Directory created");
        }

        File errorFile = new File(errorPath);
        if (errorFile.mkdir()) {
            System.out.println("Directory created");
        }

        FileWriter fr = new FileWriter(fileWrite, true);
        BufferedWriter br = new BufferedWriter(fr);

        try {
            br.write(data + "\r\n");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            FileWriter fw = new FileWriter(errorPathToFile, true);
            fw.write(String.valueOf(e));
            fw.close();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();

                FileWriter fw = new FileWriter(errorPathToFile, true);
                fw.write(String.valueOf(e));
                fw.close();
            }
        }
    }
    public static String[] OsInfo()
    {
        String[] OSInfo = new String[5];
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.equals("linux") || OS.equals("mac os x"))
        {
            OSInfo[0] = "/ERROR-CACHE/";
            OSInfo[1] = "/StudentInfo/";
        }
        else {
            OSInfo[0] = "\\ERROR-CACHE\\";
            OSInfo[1] = "\\StudentInfo\\";
        }
        return OSInfo;
    }
}
