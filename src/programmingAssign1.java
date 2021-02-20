import java.io.IOException;
import java.util.Scanner;

enum Grades
{
    A, B, C, D, F
}

public class programmingAssign1
{
    public static Scanner sc = new Scanner(System.in);

    public static void runAll() {
        separator(1);
        q1();
        separator(2);
        q2();
        separator(3);
        q3();
        separator(4);
        q4();

    }

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

                System.out.printf("The result is: %g\n", input1 + input2);
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
                System.out.print("What is the number (in degrees): ");
                input1 = sc.nextDouble();

                System.out.printf("The result is: %g\n", Math.sin(toDegrees(input1)));
            }
            case "cos" -> {
                System.out.print("What is the number (in degrees): ");
                input1 = sc.nextDouble();

                System.out.printf("The result is: %g\n", Math.cos(toDegrees(input1)));
            }
            case "tan" -> {
                System.out.print("What is the number (in degrees): ");
                input1 = sc.nextDouble();

                System.out.printf("The result is: %g\n", Math.tan(toDegrees(input1)));
            }
            case "sqrt" -> {
                System.out.print("What your number: ");
                input1 = sc.nextDouble();

                System.out.printf("The result is: %g\n", Math.sqrt(input1));
            }
            default -> System.out.println("I'm sorry, but that is not an option.");
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
            quality_points = 12;
            myGrade = Grades.A;
        }
        else if (gpa >= 80) {
            quality_points = 9;
            myGrade = Grades.B;
        }
        else if (gpa >= 70) {
            quality_points = 6;
            myGrade = Grades.C;
        }
        else if (gpa >= 60) {
            quality_points = 3;
            myGrade = Grades.D;
        }
        else {
            quality_points = 0;
            myGrade = Grades.F;
        }

        System.out.printf("Your GPA is %d and your grade is %s", quality_points/3, myGrade);
    }

    public static void q4()
    {
        String[] OS = utilityFunctions.OsInfo();
        String name, age, major, gender, userInfo, dir = OS[1], fileName = "StudentInfo";

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
            utilityFunctions.writeBufferedWriter(userInfo, dir, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void separator(int a)
    {
        System.out.println("\n#################################");
        System.out.printf("Question %d\n", a);
        System.out.println("#################################\n");
    }

    public static double toDegrees(double deg)
    {
        return deg * (Math.PI / 180.0);
    }
}