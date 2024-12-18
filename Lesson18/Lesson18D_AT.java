import java.util.ArrayList;
import java.util.Scanner;
public class Lesson18D_AT {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<Integer>();
        
        while (true) {
            System.out.print("Enter integer values, or q to quit: ");
            if (in.hasNext("Q") || in.hasNext("q")) {
                in.next();
                break;
            }
            values.add(in.nextInt());
            
        }
        
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i)%2 == 1) {
                values.remove(i);
                i--;
            } else {
                System.out.println(values.get(i));
            }
        }
    }
}


//filling an array: int a[] = new int[5]
//for int i=0; i<a.length;i++
    //a[i] = i