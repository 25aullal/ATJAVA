import java.util.Arrays;

public class SwapMethod {
    public static void swap(int a, int b, int[] array) {
        if (a >= 0 && a < array.length && b >= 0 && b < array.length) {
            int tempInt = array[a];
            array[a] = array[b];
            array[b] = tempInt;
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        swap(2, 7, numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
