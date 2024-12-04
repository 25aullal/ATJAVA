public class Lesson14B {
    public static void main(String[] args) {
        int count = 0;
        double total = 0.0;
        double[] numbers = {2.2, 1.0, 3.7, 4.1, 88.0};
        for (double elements : numbers) {
            System.out.println(elements);
            count++;
            total+= elements;
        }
        double avg = total/count;
        System.out.println("Avg = " + avg);
    }
}
