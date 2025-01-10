import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lesson19B {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("quizzes.txt");
        Scanner in = new Scanner(inputFile);

        File outputFile = new File("quizzesMod.txt");
        PrintWriter out = new PrintWriter(outputFile);
        int count = 0;
        double total = 0;
        while (in.hasNext()) {
            double score = in.nextDouble();
            total += score;
            out.printf("Quiz %03d: %6.2f%n", count, score);
            count++;
        }
        double avg = total / count;
        out.println("----------------");
        out.printf("Average:   %.2f%n", avg);
        in.close();
        out.close();
    }
}
