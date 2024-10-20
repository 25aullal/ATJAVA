import java.util.Scanner;

public class NestedA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Cougar Cafe! Is today Monday?");
        String monday = in.nextLine();
        System.out.println("Great! How old is the customer?");
        int age = in.nextInt();
        System.out.println("Excellent! How much is the cost before discount?");
        double cost = in.nextDouble();
        double discount = 0.0;

        if (monday.toUpperCase().equals("YES")) {
            if (age >= 50) {
                discount = .15;
            } else if (age < 13) {
                discount = 0.075;
            } else {
                discount = 0.05;
            } 
        } else {
            if (age >= 50) {
                discount = 0.075;
            } else if (age < 13) {
                discount = 0.05;
            }
        }

        double discounted_cost = (1-discount)*cost;
        double percent_discount = 100*discount;
        System.out.printf("Thanks for coming! Your total is %.2f after a %.0f%% discount%n", discounted_cost, percent_discount);
        

    }

}