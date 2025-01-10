import org.derryfield.math.Geometry;
import java.util.Scanner;

public class AT08B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double r = in.nextDouble();
        double volSphere = Geometry.calcVolSphere(r);
        double surfSphere = Geometry.calcSurfSphere(r);
        System.out.printf("Volume = %.2f%n", volSphere);
        System.out.printf("Surface = %.2f%n", surfSphere);
    }
}
