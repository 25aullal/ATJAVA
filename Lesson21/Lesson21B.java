import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lesson21B {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("sales_by_cat.txt");
        Scanner in = new Scanner(inputFile);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("[,\s\n]+");
            String dept = lineScanner.next();
            String manager = lineScanner.next();
            double expense;
            if (lineScanner.hasNextDouble()) {
                String expenseString = lineScanner.next().trim();
                expense = Double.parseDouble(expenseString);
            } else {
                lineScanner.next();
                expense = 0.0;

            }
            System.out.printf("%-17s | %-10s | $%10.2f%n", dept, manager, expense);
            lineScanner.close();
        }
    }
}