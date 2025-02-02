import java.util.Scanner;

public class Lesson26A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter circle radius (double): ");
        double radius = in.nextDouble();
        // static variable
        double pi = Math.PI;
        // static method
        double radius_squared = Math.pow(radius, 2);
        double area = pi * radius_squared;
        System.out.printf("Area of circle with radius %.2f = %.2f%n", radius, area);

    }
}