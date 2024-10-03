import java.util.Scanner;

public class ConditionalsA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Cougar Baking Company! How many pies will you be buying today?");
        int pies_num = in.nextInt();
        double price = pies_num*10;
        final double discount = 0.1;
        if (pies_num >= 3) {
            price = (1-discount)*price;
            System.out.println("You qualify for a 10% discount!");
        } else {
            int need_more = 3-pies_num;
            System.out.println("You do not qualify for a 10% discount. Buy " + need_more + " more pie(s) to get a discount!");
        }
        System.out.println("Your total price is $" + price + "!");
    }
}
