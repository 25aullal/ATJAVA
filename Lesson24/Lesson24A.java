import java.util.Scanner;

public class Lesson24A {
    public static void main(String[] args) {
        // Initialize
        Scanner in;
        // Reference
        in = new Scanner(System.in);
        // Name
        System.out.print("What is your name?: ");
        String name = in.nextLine();
        System.out.println("Hi " + name + "!");
        // Age
        System.out.print("What is your age?: ");
        int age = in.nextInt();
        System.out.println("Age: " + age);
    }
}