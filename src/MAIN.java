import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

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
        Questions.Q3(sc);

        Questions.QuestionSplitter(4);
        Questions.bonusQ(sc);
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

    private static HashMap<String, Integer> Q1UtilFunction(HashMap<String, Integer> mainHash, Reader fileObj) throws IOException {
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

    private static String OsInfo() {
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
        double[] overallGPA = new double[4];
        for (int i = 0; i < 4; i++) {
            int qualityPoints;
            System.out.print("Please input the amount of credits hours for the class: ");
            int creditHours = sc.nextInt();

            System.out.print("Please input the letter grade (one character only): ");
            String letterGrade = String.valueOf(sc.next().charAt(0)).toUpperCase();

            qualityPoints = qualityPoints(creditHours, letterGrade);
            double v = (qualityPoints / (creditHours * 1.0));

            overallGPA[i] = v;
        }

        double GPA = (overallGPA[0] + overallGPA[1] + overallGPA[2] + overallGPA[3]) / 4.0;
        System.out.printf("The students GPA is a %g\n", GPA);

    }

    private static int qualityPoints(int creditHours, String letterGrade) {
        if (creditHours > 4 || creditHours <= 0) {
            return -1;
        }
        switch (letterGrade) {
            case "A" -> {
                return QPoints(creditHours);
            }
            case "B" -> {
                return QPoints(creditHours) - creditHours;
            }
            case "C" -> {
                return QPoints(creditHours) - (2*creditHours);
            }
            case "D" -> {
                return QPoints(creditHours) - (3*creditHours);
            }
            case "F" -> {
                return QPoints(creditHours) - (4*creditHours);
            }
            default -> {
                return -1;
            }
        }
    }

    private static int QPoints(int creditHours) {
        switch (creditHours) {
            case 4 -> {
                return 16;
            }
            case 3 -> {
                return 12;
            }
            case 2 -> {
                return 8;
            }
            case 1 -> {
                return 4;
            }
            default -> {
                return -1;
            }
        }
    }

    public static void Q3(Scanner sc) {
        System.out.println("Do you want a Pseudo-randomly generated array ot an array you created? PR/U");
        switch (sc.next()) {
            case "PR" -> {
                System.out.println("How big do you want the array to be?");
                int size = sc.nextInt();

                int[] array = randomArrayGenerator(size);
                System.out.println(Arrays.toString(array));
                arrayOutputForQ3(array);
            }
            case "U" -> {
                int[] array = {1, 2, 3, 4, 5, 6, 7, 23, 1, -3, 3};
                arrayOutputForQ3(array);
            }
        }
    }

    private static void arrayOutputForQ3(int[] array) {
        HashMap<Integer, Integer> arrayInfo = arrayMaxMin(array);
        int a = 0;
        for (Map.Entry<Integer, Integer> stringIntegerEntry : arrayInfo.entrySet()) {
            if (a == 0) {
                System.out.printf("The max is %s is its index\n", stringIntegerEntry);
            }
            else {
                System.out.printf("The min is %s is its index\n", stringIntegerEntry);
            }
            a++;
        }
    }

    /**
    Generates a 1 x n array using random integer values
     */
    private static int[] randomArrayGenerator(int size) {
        Random rand = new Random();
        IntStream randInts = rand.ints(size, 1, 200);
        return randInts.toArray();
    }

    private static HashMap<Integer, Integer> arrayMaxMin(int[] array) {
        HashMap<Integer, Integer> arrayInfo = new HashMap<>();
        Integer max = null, min = null;
        int maxIndex = 0, minIndex = 0, iteration = 0;
        for (int value : array) {
            if (max == null) {
                max = value;
            } else {
                if (max > value) {
                    System.out.print("");
                } else {
                    max = value;
                    maxIndex = iteration;
                }
            }
            if (min == null) {
                min = value;
            } else {
                if (min > value) {
                    min = value;
                    minIndex = iteration;
                }
            }
            iteration++;
        }
        arrayInfo.put(max, maxIndex);
        arrayInfo.put(min, minIndex);

        return arrayInfo;
    }

    public static void bonusQ(Scanner sc) {
        int[][] array = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array[i][j] = (i + 1)*(j + 1);
            }
        }
        System.out.print("Press 5 to view the array: ");
        if (sc.nextInt() == 5) {
            for (int index = 0; index < 10; index++) {
                System.out.println(Arrays.toString(array[index]));
            }
        }
    }
}