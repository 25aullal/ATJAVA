import java.util.ArrayList;
import java.util.Scanner;

public class Lesson18B {
    public static void main(String[] args) {
        ArrayList<Double> values = new ArrayList<Double>();
        Scanner in = new Scanner (System.in);
        while (true) {
            System.out.print("Enter test scores or 'q' to quit: ");
            if (in.hasNext("q")) {
                in.nextLine();
                break;
            } else {
                values.add(in.nextDouble());
            }
        }
        System.out.println("Scores entered:");
        double total = 0.0;
        int count = 0;
        for (Double value:values) {
            total += value;
            count++;
            double print_value = Math.round(value*100)/100.0;
            System.out.printf("%.2f%n", print_value);
        }
        double average = total/count;
        System.out.printf("Average test score = %.2f%n", average);
    }    
}
