import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lesson20B {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("poem.txt");
        Scanner in = new Scanner(inputFile);
        in.useDelimiter("");
        int chars = 0;
        int letters = 0;
        int digits = 0;
        while (in.hasNext()) {
            char c = in.next().charAt(0);
            System.out.print(c);
            chars++;

            if (Character.isLetter(c) == true) {
                letters++;
            }

            if (Character.isDigit(c) == true) {
                digits++;
            }
        }
        System.out.printf("Characters: %d%nLetters: %d%nDigits: %d%n", chars, letters, digits);
    }
}