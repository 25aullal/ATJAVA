import java.util.Scanner;
import java.util.Arrays;

public class Lesson15C_AT {

public static boolean linearSearch(int[] array, int tgtVal) {
    int pos = 0;
    boolean found = false;
    while (pos < array.length && !found) {
        if (array[pos] == tgtVal) {
            found = true;
        } else {
            pos++;
        }
    }
    if (found) {
        return true;
    } else {
        return false;
    }


}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int LENGTH = 100000000;
        double ratioTotal = 0;
        for (int x = 1; x <=10;x++) {
            //create and fill array
            int[] numbers = new int[LENGTH];
            for (int i = 0; i <= numbers.length-1; i++) {
                numbers[i] = (int)(LENGTH*Math.random()) + 1;
            }
            
            // timing and doing methods
            int targetValue = (int)(LENGTH*Math.random()) + 1;
            long startLin = System.nanoTime();
            boolean search = linearSearch(numbers, targetValue);
            long endLin = System.nanoTime();
            long elapsedLin = endLin-startLin;
            
            Arrays.sort(numbers);
            long startBin = System.nanoTime();
            int index = Arrays.binarySearch(numbers, targetValue);
            long endBin = System.nanoTime();
            long elapsedBin = endBin-startBin;

            double ratio = (double)elapsedLin/elapsedBin;
            ratioTotal+=ratio;

            //output
            if (search == true) {
                System.out.printf("Linear: The number %d was found.%n", targetValue );
            } else {
                System.out.printf("Linear: The number %d was not found.%n", targetValue);
            }
            
            if (index >= 0) {
                    System.out.printf("Binary: The number %d was found.%n", targetValue );
            } else {
                    System.out.printf("Binary: The number %d was not found.%n", targetValue);
            }

            System.out.println("Linear took "+elapsedLin+" ns");
            System.out.println("Binary took "+elapsedBin+" ns");

        }

        double ratioAvg = ratioTotal/10;
        System.out.printf("Linear was, on average, %.2f times slower than Binary.%n", ratioAvg);
        
    }
}   