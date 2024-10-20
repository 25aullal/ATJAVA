package ATChallenge03;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert a 10 digit phone number (no spaces, no format): ");
        String number = in.next();
        String area_code = number.substring(0,3);
        String middle = number.substring(3,6);
        String end = number.substring(6);
        System.out.printf("The formatted number is (%s) %s-%s", area_code, middle, end);

    }
}
