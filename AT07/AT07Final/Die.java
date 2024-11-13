import java.util.Scanner;
public class Die {
    // private member variables to represent state
    private int val;

    // constructor(s).
    public Die() {
        val = 1;
    }

    public Die(int initialVal) {
        val = initialVal;
    }

    // public method(s).
    public int setDie(int initialDice) {
        if (initialDice >= 1 && initialDice <=6) {
            val = initialDice;
        }
        return val;

    }
    
    public void rollDice() {
            val = (int)(1+(Math.random()*6));

    }

    public int viewDice() {
        return val;
    }


    public static void main(String[] args) {
//can set die here:
        Die d = new Die();
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (i == 0) {
            System.out.print("Enter 's' to set, 'r' to roll, 'd' to display, or 'q' to quit: ");
            String action = (in.nextLine()).toUpperCase();

            if (action.equals("R")) {
                d.rollDice();
            }

            if (action.equals("Q")) {
                i++;
            }

            if (action.equals("S")) {
                System.out.print("What would you like to set the dice to? ");
                int initialDice = in.nextInt();
                in.nextLine();
                System.out.println("Dice is set to " + d.setDie(initialDice));
            }

            if (action.equals("D")) {
                if (d.viewDice()==0) {
                    System.out.println("Please roll the dice first.");
                } else if (d.viewDice()==1) {
                    System.out.print("+-------+\n" + //
                                                "|       |\n" + //
                                                "|   0   |\n" + //
                                                "|       |\n" + //
                                                "+-------+\n" + //
                                                "");
                } else if (d.viewDice()==2) {
                    System.out.print("+-------+\n" + //
                                                "| 0     |\n" + //
                                                "|       |\n" + //
                                                "|     0 |\n" + //
                                                "+-------+\n" + //
                                                "");
                } else if (d.viewDice()==3) {
                    System.out.print("+-------+\n" + //
                                                "| 0     |\n" + //
                                                "|   0   |\n" + //
                                                "|     0 |\n" + //
                                                "+-------+\n" + //
                                                "");
                } else if (d.viewDice()==4) {
                    System.out.print("+-------+\n" + //
                                                "| 0   0 |\n" + //
                                                "|       |\n" + //
                                                "| 0   0 |\n" + //
                                                "+-------+\n" + //
                                                "");
                } else if (d.viewDice()==5) {
                    System.out.print("+-------+\n" + //
                                                "| 0   0 |\n" + //
                                                "|   0   |\n" + //
                                                "| 0   0 |\n" + //
                                                "+-------+\n" + //
                                                "");
                } else if (d.viewDice()==6) {
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
