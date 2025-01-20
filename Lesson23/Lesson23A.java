import java.util.Scanner;

public class Lesson23A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalscore = 0;
        int count = 0;
        while (true) {
            try {
                int score = getQuizScore(in);
                System.out.println("Score = " + score);
                totalscore += score;
                count++;
                double avg = (double) totalscore / count;
                System.out.printf("So far, the average score is %.2f, from %d scores.%n", avg, count);
            } catch (Exception e) {
                System.err.println("ERROR!!!! AHHHHHHHH!");
                System.out.println(e.getMessage());
            }

        }

    }

    public static int getQuizScore(Scanner in) {
        System.out.print("Enter an integer quiz score between 0 and 100: ");
        int score = in.nextInt();
        if (score < 0 || score > 100) {
            throw new ArithmeticException("Score must be an integer from 1 to 100");
        } else {
            return score;
        }
    }
}
