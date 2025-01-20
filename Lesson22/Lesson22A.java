import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lesson22A {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the name of a file to read the file, or type '#' to quit the program: ");
            String input = user.next();
            if (input.equals("#")) {
                System.exit(0);
            } else {
                try {
                    File inputFile = new File(input);
                    Scanner in = new Scanner(inputFile);
                    while (in.hasNext()) {
                        String word = in.next();
                        System.out.println(word);
                    }
                    in.close();
                    break;
                } catch (FileNotFoundException exception) {
                    System.out.println("File not found! Exiting main method. Let's try again!");
                }
            }
        }
    }

}
