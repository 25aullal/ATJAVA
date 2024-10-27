package Loops09;

public class Loops09C {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i<=10000000; i++) {
            int r = (int)(Math.random()*10 + 1);
            if (r>=1 && r<=10) {
                System.out.println(r);
            sum += r;
            } else {
                i--;
            }
            
        }
        double avg = sum/10000000.0;
        System.out.printf("The average is %.2f", avg);
    }
}