import java.util.ArrayList;
import java.util.Scanner;
public class Lesson18C {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<Integer>();
        
        int lowest = Integer.MAX_VALUE;
        while (true) {
            System.out.print("Enter temperatures (°F), or q to quit: ");
            if (in.hasNext("Q") || in.hasNext("q")) {
                in.next();
                break;
            }
            int val = in.nextInt();
            if (val <= lowest) {
                lowest = val;
            }
            values.add(val);
            
        }
        
        for (int val2:values) {
            if (val2 == lowest) {
                System.out.println(val2 + " <= lowest");
            } else {
                System.out.println(val2);
            }
        }
    }
}


//filling an array: int a[] = new int[5]
//for int i=0; i<a.length;i++
    //a[i] = i