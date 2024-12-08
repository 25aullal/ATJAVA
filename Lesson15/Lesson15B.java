import java.util.Scanner;
import java.util.Arrays;

public class Lesson15B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[20];
        int currentSize = 0;
        while (true) {
            System.out.print("Enter positive or negative integer values, or 'q' to quit: ");
            if (input.hasNext("q") || input.hasNext("Q")) {
                input.next();
                break;
            } else if (currentSize < numbers.length) {
                numbers[currentSize] = input.nextInt();
                currentSize = currentSize + 1;
                
            } else {
                System.out.println("Array is full!");
                input.next();
                break;
            }
        }
        
        for (int i = 0; i <= currentSize-1; i++) {
            if (i == currentSize-1) {
                System.out.println(numbers[i]);
            } else {
                System.out.print(numbers[i]);
                System.out.print(", ");
            }
        
        }
        
        input.nextLine();
        System.out.print("Enter a target integer value: ");
        int targetValue = input.nextInt();
        int howMany = 0;
        for (int i = 0; i < currentSize; i++) {
            if (numbers[i] == targetValue) {
                howMany++;
            }
        }
        System.out.printf("The value %d occurs %d times in your original data set.", targetValue, howMany);
    }
}   