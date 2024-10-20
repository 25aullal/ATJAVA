import java.util.Scanner;
public class ConditionalsB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // prompt user for age.
        System.out.print("Enter your age: ");
        int age = in.nextInt();

        // are they lucky?
        if (age == 13) {
        System.out.println("Lucky 13!");
        }
    }
}