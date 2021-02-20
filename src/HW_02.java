public class HW_02 {
    public static void HW02() {
        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
        Q6();
        Q7();
        Q8();
        Q9();
        Q10();
        Q11();
        Q12();
    }

    public static void Q1() {
        boolean even = false;
        if (even = true)
            System.out.println("It is even");
    }

    public static void Q2() {
        int x = 1, y = -1, z = 1;

        if (x > 0) {
            if (y > 0) {
                System.out.println("X > 0 and Y > 0");
            }
        }
        else if (z > 0)
            System.out.println("X < 0 and z > 0");
    }

    public static void Q3() {
        int number = 45;
        boolean even;
        if (number % 2 == 0) {
            even = true;
        }
        else {
            even = false;
        }
        System.out.println(even);

        int num2 = 45;
        boolean isEven = (number % 2 == 0);
        System.out.println(isEven);
    }

    public static void Q4() {
        System.out.println(Math.random());
    }

    public static void Q5(){
        boolean val = true || true && false;
    }

    public static void Q6() {
        int x = 1;
        int y = x = x = 1;
        System.out.println(y);
    }

    public static void Q7() {
        int x = 0;
        int y = (x > 0) ? 10 : -10;
        System.out.println(y);
    }

    public static void Q8() {System.out.print(Math.floor(3.6));}

    public static void Q9() {int y = 0; System.out.println("${y}CS" + 1 + 0 + 3);}

    public static void Q10() {final double MAX_VALUE = 909.90;}

    public static void Q11() { System.out.println("PROGRAM".substring(0, 6)); }

    public static void Q12() {
        int A = 00110101;
        int B = A << 2;
        int C = A >> 3;

        System.out.println("B is: " + B + " While C is: " + C);
    }
}