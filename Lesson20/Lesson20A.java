import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lesson20A {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("customerdata.txt");
        Scanner in = new Scanner(inputFile);
        in.useDelimiter("[,\\s]+");
        System.out.println("---------------------------------------");
        System.out.println("   ID  |    Name     |     Balance ");
        System.out.println("---------------------------------------");

        while (in.hasNext()) {
            int id = Integer.parseInt(in.next());
            System.out.printf("%06d |", id);

            String name = in.next();
            System.out.printf("%12s |", name);

            double balance = Double.parseDouble(in.next());

            System.out.printf("$%,16.2f%n", balance);
        }
        in.close();
    }
}
