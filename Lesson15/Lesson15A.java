import java.util.Scanner;
import java.util.Arrays;

public class Lesson15A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        
        int currentSize = 0;
        while (true) {
            System.out.print("Enter positive or negative integer values, or 'q' to quit: ");
            if (input.hasNext("q") || input.hasNext("Q")) {
                System.out.println("Done entering input.");
                break;
            } else if (currentSize < numbers.length) {
                numbers[currentSize] = input.nextInt();
                currentSize = currentSize + 1;
                
            } else {
                System.out.println("Array is full!");
                break;
            }
        }
        
        for (int i = 0; i <= currentSize-1; i++) {
            System.out.print("*");
            System.out.print(numbers[i]);
        }
        System.out.println("*");

        Arrays.sort(numbers,0,currentSize);
        for (int j = currentSize-1; j >= 0; j--) {
            if (j == 0) {
                System.out.print(numbers[j]);
            } else {
                System.out.print(numbers[j]);
                System.out.print(",");
            }
        }
    }
}   