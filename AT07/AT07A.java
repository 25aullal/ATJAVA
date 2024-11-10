package AT07;
import java.util.Scanner;


class Dice {
//need to roll, display, or quit
    private int dice_roll = 1;
    
    public int setDice(int initialDice) {
        if (initialDice >= 1 && initialDice <=6) {
            dice_roll = initialDice;
        }
        return dice_roll;

    }
    
    public void rollDice() {
            dice_roll = (int)(1+(Math.random()*6));

    }

    public int viewDice() {
        return dice_roll;
    }
}

public class AT07A {
   

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        Dice dice = new Dice();
        while (i == 0) {
            System.out.print("Enter 's' to set, 'r' to roll, 'd' to display, or 'q' to quit: ");
            String action = (in.nextLine()).toUpperCase();

            if (action.equals("R")) {
                dice.rollDice();
            }

            if (action.equals("Q")) {
                i++;
            }

            if (action.equals("S")) {
                System.out.print("What would you like to set the dice to? ");
                int initialDice = in.nextInt();
                in.nextLine();
                System.out.println("Dice is set to " + dice.setDice(initialDice));
            }

            if (action.equals("D")) {
                if (dice.viewDice()==0) {
                    System.out.println("Please roll the dice first.");
                } else if (dice.viewDice()==1) {
                    System.out.print("+-------+\n" + //
                                                "|       |\n" + //
                                                "|   0   |\n" + //
                                                "|       |\n" + //
                                                "+-------+\n" + //
                                                "");
                } else if (dice.viewDice()==2) {
                    System.out.print("+-------+\n" + //
                                                "| 0     |\n" + //
                                                "|       |\n" + //
                                                "|     0 |\n" + //
                                                "+-------+\n" + //
                                                "");
                } else if (dice.viewDice()==3) {
                    System.out.print("+-------+\n" + //
                                                "| 0     |\n" + //
                                                "|   0   |\n" + //
                                                "|     0 |\n" + //
                                                "+-------+\n" + //
                                                "");
                } else if (dice.viewDice()==4) {
                    System.out.print("+-------+\n" + //
                                                "| 0   0 |\n" + //
                                                "|       |\n" + //
                                                "| 0   0 |\n" + //
                                                "+-------+\n" + //
                                                "");
                } else if (dice.viewDice()==5) {
                    System.out.print("+-------+\n" + //
                                                "| 0   0 |\n" + //
                                                "|   0   |\n" + //
                                                "| 0   0 |\n" + //
                                                "+-------+\n" + //
                                                "");
                } else if (dice.viewDice()==6) {
                    System.out.print("+-------+\n" + //
                                                "| 0   0 |\n" + //
                                                "| 0   0 |\n" + //
                                                "| 0   0 |\n" + //
                                                "+-------+\n" + //
                                                "");
                }

            }
        }
    }

    
}