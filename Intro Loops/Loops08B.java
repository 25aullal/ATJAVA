import java.util.Scanner;
public class Loops08B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the APR (between 0 and 100): ");
        final double APR = in.nextDouble() / 100;
        System.out.println("What is the initial balance of the account, in dollars: ");
        double balance = in.nextDouble();
        double interest_amount = 0;
        System.out.println("Year |  Interest Amount ($)  |   Balance ($)   |");
        System.out.println("------------------------------------------------");

        for (int year = 1; year < 6; year++) {
            interest_amount = APR*balance;
            balance += interest_amount;
            System.out.printf("%d    |%23.2f|%17.2f|%n", year, interest_amount, balance);
            
        }


    }
}
