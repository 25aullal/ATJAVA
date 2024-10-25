package Loops09;
import java.util.Scanner;

public class Loops09B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine().toUpperCase();
        char character;
        int num_e = 0;
        for (int i = 0; i<string.length(); i++) {
            character = string.charAt(i);
            if (character == ('E')) {
                num_e++;
            }

        }
        System.out.printf("There are %d e's in that line.", num_e);
    }
}