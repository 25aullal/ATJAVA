import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lesson22B {
    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("birthyears.txt");
        Scanner in = new Scanner(inputFile);
        in.useDelimiter(",|\n");
        while (in.hasNext()) {
            String name = in.next();
            try {
                int birthyear = Integer.parseInt(in.next());
                System.out.println(name + " was born in " + birthyear + ".");
            } catch (NumberFormatException exception) {
                System.out.println(name + " was never born. Just kidding! We do not know birthyear.");
            }
        }

    }
}
