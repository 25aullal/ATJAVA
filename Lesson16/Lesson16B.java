import java.util.Arrays;

public class Lesson16B {
    public static double average(double...values) {
        double total = 0;
        for (int i = 0; i<values.length-1; i++) {
            total+=values[i];
        }
        double average = total/(values.length-1);
        return average;
    }
    public static void main(String[] args) {
        double[] scores = {100,90,80,100};
        int currentSize = scores.length;
        double average = average(Arrays.copyOf(scores, currentSize));
        System.out.printf("The average of supplied values is equal to %.2f.%n", average);
    }
}
