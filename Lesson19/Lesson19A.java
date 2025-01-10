import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Lesson19A {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> temps = new ArrayList<Integer>();
        File inputFile = new File("temps.txt");
        Scanner in = new Scanner(inputFile);
        int lowest = Integer.MAX_VALUE;
        while (in.hasNext()) {
            int temp = Integer.parseInt(in.next());
            temps.add(temp);
            if (temp <= lowest) {
                lowest = temp;
            }
        }
        in.close();

        System.out.println("Integers in temps.txt: ");
        for (int val : temps) {
            if (val == lowest) {
                System.out.println(val + " <= lowest");
            } else {
                System.out.println(val);
            }
        }
    }
}
