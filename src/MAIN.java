import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
            HashMap<String, Integer> mainHash = new HashMap<>();

            HashMap<String, Integer> retVal = programmingAssign2.Q1(mainHash, fileObj);
            for (java.util.Map.Entry<String, Integer> stringIntegerEntry : retVal.entrySet()) {
                System.out.printf("The string contains %s\n", stringIntegerEntry);
            }
        } catch (FileNotFoundException e) {
            throw new FatalError("The file could not be found, please check and make sure " +
                    "it is in the same directory as the java file", e);
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
    public FatalError(String msg, Exception e) {
        super("A fatal error has occurred: " + msg + "::::" + e);
    }
}

class programmingAssign2 {
    public static HashMap<String, Integer> Q1(HashMap<String, Integer> mainHash, Reader fileObj) throws IOException {
        BufferedReader bufferedFileObj = new BufferedReader(fileObj);
        String main;
        while ((main = bufferedFileObj.readLine()) != null) {

            ArrayList<String> mainArrayList = new ArrayList<>(Arrays.asList(main.split(" ")));

            for (String word : mainArrayList) {
                if (mainHash.containsKey(word)) {
                    int val = mainHash.get(word);
                    val++;
                    mainHash.replace(word, val);
                } else {
                    mainHash.put(word, 1);
                }
            }
        }
        return mainHash;
    }
}