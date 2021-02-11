import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class programmingAssign1
{
    public static void main(String[] args) {

        questions.separator(1);
        System.out.println();
        questions.q1();
        System.out.println();
        questions.separator(2);
        System.out.println();
        questions.q2();
        System.out.println();
        questions.separator(3);
        System.out.println();
        questions.q3();
        System.out.println();
        questions.separator(4);
        System.out.println();
        questions.q4();
    }
}

enum Grades
{
    A, B, C, D, F
}

class questions
{
    public static Scanner sc = new Scanner(System.in);

    public static void q1()
    {
        double input1, input2;
        String operator;
        System.out.print("""
                PLease input: +, -, *, /, %, ^, sin, cos, tan, sqrt \s
                What kind of operation are you doing: \s""");
        operator = sc.next();
        switch (operator) {
            case "+" -> {
                System.out.print("What is the first number: ");
                input1 = sc.nextDouble();
                System.out.print("What is the second number: ");
                input2 = sc.nextDouble();

                System.out.printf("The result is: %g", input1 + input2);
            }
            case "-" -> {
                System.out.print("What is the first number: ");
                input1 = sc.nextDouble();
                System.out.print("What is the second number: ");
                input2 = sc.nextDouble();

                System.out.printf("The result is: %g\n", input1 - input2);
            }
            case "*" -> {
                System.out.print("What is the first number: ");
                input1 = sc.nextDouble();
                System.out.print("What is the second number: ");
                input2 = sc.nextDouble();

                System.out.printf("The result is: %g\n", input1 * input2);
            }
            case "/" -> {
                System.out.print("What is the first number: ");
                input1 = sc.nextDouble();
                System.out.print("What is the second number: ");
                input2 = sc.nextDouble();

                System.out.printf("The result is: %g\n", input1 / input2);
            }
            case "%" -> {
                System.out.print("What is the first number: ");
                input1 = sc.nextDouble();
                System.out.print("What is the second number: ");
                input2 = sc.nextDouble();

                System.out.printf("The result is: %g\n", input1 % input2);
            }
            case "^" -> {
                System.out.print("What is the base number: ");
                input1 = sc.nextDouble();
                System.out.print("What is the exponent number: ");
                input2 = sc.nextDouble();

                System.out.printf("The result is: %g\n", Math.pow(input1, input2));
            }
            case "sin" -> {
                System.out.print("What is the number (in radians): ");
                input1 = sc.nextDouble();

                System.out.printf("The result is: %g\n", Math.sin(input1));
            }
            case "cos" -> {
                System.out.print("What is the number (in radians): ");
                input1 = sc.nextDouble();

                System.out.printf("The result is: %g\n", Math.cos(input1));
            }
            case "tan" -> {
                System.out.print("What is the number (in radians): ");
                input1 = sc.nextDouble();

                System.out.printf("The result is: %g\n", Math.tan(input1));
            }
            case "sqrt" -> {
                System.out.print("What your number: ");
                input1 = sc.nextDouble();

                System.out.printf("The result is: %g\n", Math.sqrt(input1));
            }
        }
    }

    public static void q2()
    {
        double loanAmount, interestRate, lengthOfLoan, monthlyPayment, total;

        System.out.print("What is the loan amount: ");
        loanAmount = sc.nextDouble();
        System.out.print("What is the monthly interest rate: ");
        interestRate = sc.nextDouble();
        System.out.print("How many years will this loan last: ");
        lengthOfLoan = sc.nextDouble();

        monthlyPayment = (loanAmount * interestRate)/(1.0 - (1.0 / Math.pow((1.0 + interestRate), (lengthOfLoan * 12))));
        total = monthlyPayment * 12 * lengthOfLoan;

        System.out.printf("Your monthly payment will be %g\n", monthlyPayment);
        System.out.printf("Your total payment will be %g\n", total);
    }

    public static void q3()
    {
        double[] temp = new double[5];

        System.out.println("Enter your percentages from the following:");
        System.out.print("programming assignments: ");
        temp[0] = sc.nextDouble();

        System.out.print("homework: ");
        temp[1] = sc.nextDouble();

        System.out.print("attendance: ");
        temp[2] = sc.nextDouble();

        System.out.print("tests: ");
        temp[3] = sc.nextDouble();

        System.out.print("final exam: ");
        temp[4] = sc.nextDouble();

        double programAssign = 0.25 * temp[0];
        double homework = 0.16 * temp[1];
        double attendance = 0.04 * temp[2];
        double tests = 0.30 * temp[3];
        double fnlExam = 0.25 * temp[4];

        double gpa = programAssign + homework + attendance + tests + fnlExam;

        Grades myGrade;

        int quality_points;
        if (gpa >= 90) {
            quality_points = 16;
            myGrade = Grades.A;
        }
        else if (gpa >= 80) {
            quality_points = 12;
            myGrade = Grades.B;
        }
        else if (gpa >= 70) {
            quality_points = 8;
            myGrade = Grades.C;
        }
        else if (gpa >= 60) {
            quality_points = 4;
            myGrade = Grades.D;
        }
        else {
            quality_points = 0;
            myGrade = Grades.F;
        }

        System.out.printf("Your GPA is %d and your grade is %s", quality_points/4, myGrade);
    }

    public static void q4()
    {
        String name, age, major, gender, userInfo, dir = "/StudentInfo/", fileName = "StudentInfo";
        System.out.flush();

        System.out.println("What is the students name?");
        sc.nextLine();
        name = sc.nextLine();
        System.out.println("What is the students age?");
        age = sc.nextLine();
        System.out.println("What is the students major?");
        major = sc.nextLine();
        System.out.println("What is the students gender?");
        gender = sc.nextLine();

        userInfo = name + "\n" + age + "\n" + major + "\n" + gender + "\n";
        try {
            classBufferedWriter.writeBufferedWriter(userInfo, dir, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void separator(int a)
    {
        System.out.println("#################################");
        System.out.printf("Question %d\n", a);
        System.out.println("#################################");
    }
}

class classBufferedWriter
{

    public static void writeBufferedWriter(String data, String getDirectory, String getFileName) throws IOException
    {

        String errorPath = System.getProperty("user.dir") + "/ERROR-CACHE/";
        String errorPathToFile = System.getProperty("user.dir") + "/ERROR-CACHE/ERROR-1.txt";

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
}