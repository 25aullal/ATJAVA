import java.util.ArrayList;
import java.util.Scanner;

public class Lesson18A {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        Scanner in = new Scanner (System.in);
        while (true) {
            System.out.print("Enter a name or '#' to quit: ");
            if (in.hasNext("#")) {
                in.nextLine();
                break;
            } else {
                names.add(in.next());
            }
        }
        System.out.println("Names entered:");
        for (String name:names) {
            System.out.println(name);
        }

    }    
}
