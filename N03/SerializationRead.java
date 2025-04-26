import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SerializationRead {

    public static void main(String[] args) {
        String filepath;
        if (args.length > 0) {
            filepath = args[0];
        } else {
            filepath = "data.bin";
        }

        ArrayList<Employee> employees = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(filepath);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {

            int lastID = dataInputStream.readInt();
            Employee.lastIDUsed = lastID;

            while (true) {
                try {
                    Employee e = new Employee();
                    e.readFromStream(dataInputStream);
                    employees.add(e);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }

        System.out.println("Employee Data:");
        for (Employee e : employees) {
            e.displayInfo();
        }
    }
}
