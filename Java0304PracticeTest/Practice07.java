package Java0304PracticeTest;
import java.util.Scanner;

public class Practice07 {


    public static void main(String[] args) {
        
        double current_num;
        double biggest_num;
        double smallest_num;
        double total = 0 ;
        double count = 0;
        double average = total/count;
        boolean loopFlag = true;
        char quit;

        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Input a number value. Type 'q' or 'Q' to quit.");
            count++;
            current_num = in.nextDouble();
            quit = in.next().toUpperCase().charAt(0);
            if (quit == 'Q') {
                loopFlag = false;
            }

        }
        while (loopFlag == false);
        


    }
}
