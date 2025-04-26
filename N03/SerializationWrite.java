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
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Goodbye!");
        }
    }

    static void broadcastMessage(String message) {
        // iterate through list of connections and send message to everyone.
        for (ClientHandler handler : clients) {
            if (handler != null) {
                handler.sendMessage(message);
            }
        }
    }

    static void removeClient(ClientHandler tgtHandler) {
        int index = clients.indexOf(tgtHandler);
        if (index > 0) {
            clients.remove(index);
        }
    }
}