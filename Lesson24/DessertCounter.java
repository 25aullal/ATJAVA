import java.util.Scanner;

public class DessertCounter {
    private int pieCounter = 0;
    private int cakeCounter = 0;

    public void countPie() {
        pieCounter += 1;
    }

    public void countCake() {
        cakeCounter += 1;
    }

    public int pieReturn() {
        return pieCounter;
    }

    public int cakeReturn() {
        return cakeCounter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DessertCounter counter = new DessertCounter();
        while (true) {
            System.out.print("Enter 'c' to vote cake, 'p' to vote pie, or 'q' to quit: ");
            String action = in.next().toUpperCase();
            if (action.equals("C")) {
                counter.countCake();
            } else if (action.equals("P")) {
                counter.countPie();
            } else if (action.equals("Q")) {
                System.out.printf("Final count:%nCake: %s%nPie: %s%n", counter.cakeReturn(), counter.pieReturn());
                if (counter.cakeReturn() > counter.pieReturn()) {
                    System.out.println("Cake wins!");
                } else if (counter.cakeReturn() < counter.pieReturn()) {
                    System.out.println("Pie wins!");
                } else {
                    System.out.println("Everybody wins! Or loses...");
                }
                break;
            }
        }
        in.close();
    }
}
