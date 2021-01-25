/*
 * Author: Joshua Estes
 * Date: 1/13/2021
 * JDK 15 is required
 */

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("##################################################");
        System.out.println("First Question");
        System.out.println("##################################################");

        String name, gender, major, age;
        System.out.println("Please enter name.");
        name = sc.nextLine();
        System.out.println("Please enter gender.");
        gender = sc.nextLine();
        System.out.println("Please enter major.");
        major = sc.nextLine();
        System.out.println("Please enter age.");
        age = sc.nextLine();

        System.out.printf("Your name is: %s\nYour gender is: %s\nYour major is: %s\nYour age is: %s\n", name, gender, major, age);

        System.out.println("##################################################");
        System.out.println("Second Question");
        System.out.println("##################################################");

        System.out.println("Please enter the temperature in F");
        double temp = sc.nextDouble();
        double converted = (5 * (temp - 32) / 9);
        System.out.println("The temp in C is " + converted);

        System.out.println("##################################################");
        System.out.println("Third Question");
        System.out.println("##################################################");

        System.out.println("Please input the radius:");
        double radius = sc.nextDouble();
        double area = 3.14 * Math.pow(radius, 2);
        System.out.println("The area is " + area);
    }
}