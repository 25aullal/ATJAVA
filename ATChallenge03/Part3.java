package ATChallenge03;
import java.util.Scanner;

public class Part3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert a positive integer value: ");
        int num = in.nextInt();
        int test = 1;
        int divisible = 0;
        if (num == 1) {
            System.out.println("The number 1 is not prime");
        }

        while (divisible<=2) {
            double div1= (double)num/test;
            if (Math.abs((int)div1 - div1)<0.001) {
                divisible++;
            }
            if (test > num) {
                System.out.printf("The number %d is prime%n", num);
                divisible = 4;
            }
            test++;
        }

        if (divisible == 3) {
            System.out.printf("The number %d is not prime%n", num);
        }
        
        

    }
}
