package Debug10;

public class Debug10D {
    public static void main(String[] args) {
        for (int i = 1; i <=5; i++) {
            for (int i2 = 1; i2<=5-i;i2++) {
                System.out.print(".");
            }
            for (int i3 = 1; i3 <= i; i3++) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}
