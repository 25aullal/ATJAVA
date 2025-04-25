public class R01A {

    public static void printInverted(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("argument must be a positive integer value.");
        } else {
            // use recursion to solve for the value.
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    System.out.println("*");
                } else {
                    System.out.print("*");
                }
            }
            if (n > 1) {
                printInverted(n - 1);
            }
        }
    }

    public static void main(String[] args) {
        printInverted(5);
    }

}