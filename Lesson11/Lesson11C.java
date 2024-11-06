package Lesson11;
import java.util.Scanner;

public class Lesson11C {
    public static double sphere(double radius)
{
   double sphereVolume = 4.0/3.0*Math.PI*Math.pow(radius, 3.0);
   return sphereVolume;
}




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert sphere radius to calculate volume: ");
        double radius = in.nextDouble();
        double sphereVolume = sphere(radius);
        System.out.printf("The volume of a sphere with radius %.2f = %.2f", radius, sphereVolume);
    }
}
