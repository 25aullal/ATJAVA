import java.util.Scanner;
public class Ignore_LargestNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
        double val = 0;
        double largest = Double.MIN_VALUE;
        double[] values = new double[5];
        double sum = 0;
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            System.out.print("Enter a test score, or q to quit: ");
            if (in.hasNext("Q") || in.hasNext("q")) {
                in.next();
                break;
            }
            val = in.nextDouble();
            if (val >= 0 && val <= 150) {
                
                values[i] = val;
            
                if (val > largest) {
                   largest = val;
                }
                sum += val;
                count ++;
            } else {
                i--;
            }
        }
        System.out.println("Capacity full, or input done.");
        for (int i = 0; i < values.length; i++) {
            if (values[i] == largest) {
                System.out.println(values[i] + " <= largest");
            } else if (values[i] == 0) {
            } else {
                System.out.println(values[i]);
            }
        }
        double average = sum / (double)count;
        System.out.println("Average = " + average);
    }
}


//filling an array: int a[] = new int[5]
//for int i=0; i<a.length;i++
    //a[i] = i