import mow.Yard;
import mow.Mower;
import java.util.Scanner;

public class LawnmowerLineByLine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the width dimension of your yard: ");
        int yardWidth = in.nextInt();
        System.out.print("Enter the length dimension of your yard: ");
        int yardLength = in.nextInt();

        Yard yard = new Yard();
        Mower mower = new Mower();

        yard.yardCreator(yardWidth, yardLength);
        mower.randomSet(yard);
        yard.printYard(mower);

        while (mower.updateMower(yard) == false) {
            if (mower.detectForward(yard) == ' ' || mower.detectForward(yard) == 'R') {
                if (mower.detectRight(yard) == 'R' || mower.detectRight(yard) == ' ') {
                    mower.turnLeft();
                } else {
                    mower.turnRight();
                }
                yard.printYard(mower);
                mower.mowUnderneath(yard);
            } else {
                while (mower.detectForward(yard) == '+') {
                    mower.mowUnderneath(yard);
                    mower.moveForward();
                    yard.printYard(mower);
                    mower.mowUnderneath(yard);
                }
                if (mower.detectRight(yard) == '+') {
                    mower.turnRight();
                    yard.printYard(mower);
                    mower.mowUnderneath(yard);

                    mower.moveForward();
                    yard.printYard(mower);
                    mower.mowUnderneath(yard);

                    mower.turnRight();
                    yard.printYard(mower);
                    mower.mowUnderneath(yard);
                } else if (mower.detectLeft(yard) == '+') {
                    mower.turnLeft();
                    yard.printYard(mower);
                    mower.mowUnderneath(yard);

                    mower.moveForward();
                    yard.printYard(mower);
                    mower.mowUnderneath(yard);

                    mower.turnLeft();
                    yard.printYard(mower);
                    mower.mowUnderneath(yard);
                }
            }

        }
        System.out.println("Your lawn has been mowed. You're welcome :)");
    }

}
