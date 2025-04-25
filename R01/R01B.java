public class R01B {

    public static void printTriangle(int n) {
        if (n == 0) {
            throw new IllegalArgumentException("argument must be a positive integer value.");
        } else {
            // use recursion to solve for the value.

            if (n > 1) {
                printTriangle(n - 1);
            }

            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        printTriangle(5);
    }

}