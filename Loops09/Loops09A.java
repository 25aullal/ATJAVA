package Loops09;

import java.util.Scanner;

public class Loops09A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double total_grades = 0;
        double grade = 0;
        double total_number = 0;

        System.out.println("Enter test scores (0.00-100.00). Enter in a negative value to finish.");

        boolean loopFlag = true;
        
        do {
            grade = in.nextDouble();

            if (grade >= 0) {
                total_grades+= grade;
                total_number++;
            } else {
                // the user is done entering data.
                loopFlag = false;
            }
        } while (loopFlag);

        double average_grades = total_grades/total_number;
        System.out.printf("The average of all provided positive test scores is %.2f%%.%n", average_grades);

    }
    
}