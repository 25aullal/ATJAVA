import java.util.Scanner;
public class ConditionalsD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Cougar Baking Company! How many cookies will you be buying today?");
        int cookies_num = in.nextInt();
        double price_c = cookies_num*0.99;
        double discount_c;
        if (cookies_num >= 24){
            discount_c = 0.15;
        } else if (cookies_num >= 12){
            discount_c = 0.05;
        } else if (cookies_num >= 6){
            discount_c = 0.025;
        } else {
            discount_c = 0;
        }

        price_c = price_c*(1-discount_c);
        System.out.println("You qualify for a " + discount_c + "% discount.");
        System.out.printf("Your total is %02.2f dollars!", price_c);
    }
}