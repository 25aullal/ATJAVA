import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SerializationWrite {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.print("Type 'e' to add an employee or 'q' to quit: ");
            String token = in.nextLine();

            if (token.equalsIgnoreCase("q")) {
                System.out.println("Done inputting data.");
                break;
            } else if (token.equalsIgnoreCase("e")) {
                System.out.print(" Last name: ");
                String last = in.nextLine();
                System.out.print(" First name: ");
                String first = in.nextLine();
                double salary = 0;
                System.out.print(" Salary: ");
                try {
                    token = in.nextLine();
                    salary = Double.parseDouble(token);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing salary. Using $0 as default salary.");
                }
                System.out.println();
                Employee.lastIDUsed++;
                Employee e = new Employee(first, last, Employee.lastIDUsed, salary);
                employees.add(e);
            }
        }

        String filepath = "data.bin";
        try (FileOutputStream fileOutputStream = new FileOutputStream(filepath);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            dataOutputStream.writeInt(Employee.lastIDUsed);

            for (Employee e : employees) {
                e.writeToStream(dataOutputStream);
            }
            System.out.println("Data saved to \"" + filepath + "\"");
        } catch (IOException e) {
            System.err.println("Error writing to output file.");
            System.err.println(e.getMessage());
        }
    }
}
