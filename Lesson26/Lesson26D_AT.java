import java.util.ArrayList;
import java.util.Arrays;

public class Lesson26D_AT {
    public static void swap(ArrayList<Integer> values, int i, int j) {
        int temp_int = values.get(i);
        values.set(i, values.get(j));
        values.set(j, temp_int);
    }

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(8, 6, 7, 5, 3, 0, 9));
        System.out.print("Before: [");
        for (int i = 0; i < values.size(); i++) {
            System.out.print(values.get(i));
            if (i + 1 == values.size()) {
            } else {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        Lesson26D_AT.swap(values, 2, 4);

        System.out.print("Before: [");
        for (int j = 0; j < values.size(); j++) {
            System.out.print(values.get(j));
            if (j + 1 == values.size()) {
            } else {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
