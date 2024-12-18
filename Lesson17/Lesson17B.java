public class Lesson17B {
    public static void print(int[][] values) {
        //
        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[0].length; col++) {
                System.out.print(values[row][col]);
                if (col < values[0].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //Array initializations
        int[][] arr1 = {
            {8, 6, 7},
            {5, 3, 0}
        };
        
        int[][] arr2 = {
            {0, 7, 6, 5},
            {2, 2, 0, 1},
            {8, 4, 5, 7}
        };

        //Outputs
        System.out.println("First array:");
        print(arr1);
        System.out.println("Second array:");
        print(arr2);
    }
}