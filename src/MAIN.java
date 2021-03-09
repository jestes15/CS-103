import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the file name(not directory and including the .txt): ");
        String fileName = sc.next();
        Q1(fileName);
    }

    public static void Q1(String filename) throws FatalError, IOException {
        try {
            FileReader fileObj = new FileReader(System.getProperty("user.dir") + OsInfo() + filename);
            HashMap<String, Integer> retVal = programmingAssign2.Q1(fileObj);
            for (java.util.Map.Entry<String, Integer> stringIntegerEntry : retVal.entrySet()) {
                System.out.printf("The string contains %s\n", stringIntegerEntry);
            }
        } catch (FileNotFoundException e) {
            throw new FatalError("The file could not be found, please check and make sure " +
                    "it is in the same directory as the java file");
        }
    }

    public static String OsInfo()
    {
        String OSInfo;
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.equals("linux") || OS.equals("mac os x"))
        {
            OSInfo = "/";
        }
        else {
            OSInfo = "\\";
        }
        return OSInfo;
    }
}

class FatalError extends Exception {
    public FatalError(String msg) {
        super("A fatal error has occurred: " + msg);
    }
}
