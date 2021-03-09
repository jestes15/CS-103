import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Questions.QuestionSplitter(1);
        System.out.print("What is the file name(not directory and including the .txt): ");
        String fileName = sc.next();
        Questions.Q1(fileName);

        Questions.QuestionSplitter(2);
        Questions.Q2(sc);

        Questions.QuestionSplitter(3);

    }
}

class FatalError extends Exception {
    public FatalError(String msg, Exception e) {
        super("A fatal error has occurred: " + msg + "::::" + e);
    }
}

class Questions {
    public static void QuestionSplitter(int question) {
        System.out.println("#############");
        System.out.printf("This is the start of question %d\n", question);
        System.out.println("#############");
    }

    public static void Q1(String filename) throws FatalError, IOException {
        try {
            FileReader fileObj = new FileReader(System.getProperty("user.dir") + OsInfo() + filename);
            HashMap<String, Integer> mainHash = new HashMap<>();

            HashMap<String, Integer> retVal = Q1UtilFunction(mainHash, fileObj);
            for (java.util.Map.Entry<String, Integer> stringIntegerEntry : retVal.entrySet()) {
                System.out.printf("The string contains %s\n", stringIntegerEntry);
            }
        } catch (FileNotFoundException e) {
            throw new FatalError("The file could not be found, please check and make sure " +
                    "it is in the same directory as the java file", e);
        }
    }

    public static HashMap<String, Integer> Q1UtilFunction(HashMap<String, Integer> mainHash, Reader fileObj) throws IOException {
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

    public static String OsInfo() {
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

    public static void Q2(Scanner sc) {
        HashMap<String, String[]> studentGrade = new HashMap<>();
        String[] studentValues = new String[4];
        for (int i = 0; i < 4; i++) {
            String classNum = "class-" + (i + 1);
            System.out.print("Please input the amount of credits hours for the class: ");
            studentValues[0] = String.valueOf(sc.next().charAt(0));
            System.out.print("Please input the letter grade (one character only): ");
            studentValues[1] = String.valueOf(sc.next().charAt(0));
            studentGrade.put(classNum, studentValues);
        }

        for (int studentClass = 1; studentClass < 5; studentClass++) {
            String className = "class-" + studentClass;
            String[] info = studentGrade.get(className);
            switch (info[1]) {
                case "A" -> {System.out.println("You have an A");}
                case "B" -> {System.out.println("You have an B");}
                case "C" -> {System.out.println("You have an C");}
                case "D" -> {System.out.println("You have an D");}
                case "F" -> {System.out.println("You have an F");}
            }
        }

        System.out.print(studentGrade);

    }
}