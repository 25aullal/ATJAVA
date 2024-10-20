package ATChallenge03;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Price: ");
        double price = in.nextDouble();
        int price_d = (int)price;
        double price_c = (price - price_d)*100;
        System.out.printf("The price represents %d dollars and %2.0f cents!", price_d, price_c);

    }
}
