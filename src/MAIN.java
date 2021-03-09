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

class programmingAssign2 {
    public static HashMap<String, Integer> Q1(Reader fileObj) throws IOException {
        HashMap<String, Integer> mainHash = new HashMap<>();
        BufferedReader bufferedFileObj = new BufferedReader(fileObj);
        String main = bufferedFileObj.readLine();
        // String main = "James while John had had great had had had had had had had had had a better effect on the teacher.";
        ArrayList<String> mainArrayList = new ArrayList<>(Arrays.asList(main.split(" ")));

        for (String word : mainArrayList) {
            if (mainHash.containsKey(word)) {
                int val = mainHash.get(word);
                val++;
                mainHash.replace(word, val);
            }
            else {
                mainHash.put(word, 1);
            }
        }
        return mainHash;
    }
}