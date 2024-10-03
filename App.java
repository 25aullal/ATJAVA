import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        //A
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

        //B
        // prompt user for age.
        System.out.print("Enter your age: ");
        int age = in.nextInt();

        // are they lucky?
        if (age == 13) {
        System.out.println("Lucky 13!");
        }


        //C
        //original did not work because there is a tiny difference between identified values
        //modified to measure equality within a threshold
        final double THRESHOLD = 1e-14;
        double a = 1.2; 
        double b= 2.9;
        double c = a * b; 
        if(Math.abs(c-3.6) < THRESHOLD){
        System.out.println("c is 3.6");
        } else {
        System.out.println("c is not 3.6");
        }


        //D
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
        System.out.println("Your total is " + price_c + ".");
        }
        
    }
