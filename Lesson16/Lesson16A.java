import java.util.Scanner;

public class Lesson16A {
    public static double dropLowest(double array[], int arraySize) {
        double minValue = Double.MAX_VALUE;
        for (int i = 0; i < arraySize; i++) {
            if (array[i] <= minValue) {
                minValue = array[i];
            }
        }
        for (int j = 0; j < arraySize; j++) {
            if (array[j] == minValue) {
                for (int k = j+1; k<arraySize; k++) {
                    array[k-1] = array[k];
                }
                arraySize--;
                break;
            }
        }
        return minValue;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] scores = new double[50];
        
        int currentSize = 0;
        while (true) {
            System.out.print("Enter a quiz score, or 'q' when done: ");
            if (input.hasNext("q") || input.hasNext("Q")) {
                System.out.println("Done entering scores.");
                input.nextLine();
                break;
            } else if (currentSize < scores.length) {
                scores[currentSize] = input.nextDouble();
                currentSize = currentSize + 1;
                
            } else {
                System.out.println("Array is full!");
                input.nextLine();
                break;
            }
        }
        System.out.println("You have entered the following grades:");
        for (int x = 0; x<currentSize; x++) {
            System.out.println(scores[x]);
        }
        input.nextLine();
        
        
        System.out.println("Type 'y' to drop your lowest score: ");
        String response = input.next();
        if (response.equals("Y") || response.equals("y")) {
            double droppedScore = dropLowest(scores, currentSize);
            currentSize--;
            System.out.printf("The score %.2f was dropped.%n", droppedScore);
            System.out.println("Your final score list is:");
            for (int y = 0; y < currentSize; y++) {
                System.out.println(scores[y]);
            }
        }

        input.close();
    }
}   