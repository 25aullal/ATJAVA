import java.util.Scanner;
import java.util.ArrayList;

public class QuizScores {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> scores = new ArrayList<Double>();
        boolean doLoop = true;
        while (doLoop) {
            System.out.print("Enter a quiz score or 'q' to quit: ");
            String action = in.next();
            if (action.equals("q") || action.equals("Q")) {
                doLoop = false;
            } else if (Double.parseDouble(action) >= 0 && Double.parseDouble(action) <= 150) {
                scores.add(Double.parseDouble(action));
            } else if (Double.parseDouble(action) < 0 || Double.parseDouble(action) > 150) {
                System.out.println("Value falls outside range!");
            }
        }

        double total = 0;
        System.out.println("--------------");
        for (int i = 0; i < scores.size(); i++) {
            System.out.printf("%6.2f%n", scores.get(i));
            total += scores.get(i);
        }
        System.out.println("--------------");
        double avg = total / (scores.size());
        System.out.printf("avg = %.2f%n", avg);

    }
}