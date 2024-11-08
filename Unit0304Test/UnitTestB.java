import java.util.Scanner;
public class UnitTestB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please print three integers (with space in between): ");
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        //System.out.printf("%d, %d, %d", x,y,z);
        int first = x;
        int second = y;
        int third = z;
        if (x < y) {
            int temp = y;
            y = x;
            x = temp;
        }

        if (x < z) {
            int temp = z;
            z = x;
            x = temp;
        }

        if (y<z) {
            int temp = z;
            z = y;
            y = temp;
        }

        System.out.printf("%d %d %d%n", x, y, z);
    }
}
