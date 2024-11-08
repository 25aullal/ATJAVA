public class UnitTestA {
    public static void main(String[] args) {
        int total = 0;
        int count = 0;
        double average;
        for (int i = 1; i <= 100; i++) {
            total += i;
            count++;
        }
        average = (double)total/(double)count;

        System.out.printf("The average of all numbers from 1 to 100 (inclusive) is %.1f.%n", average);
    }
    
    

}
