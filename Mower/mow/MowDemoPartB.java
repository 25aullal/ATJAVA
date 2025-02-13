package mow;

public class MowDemoPartB {
    public static void delay(long mseconds) {
        try {
            Thread.sleep(mseconds);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

    public static void main(String[] args) {
        Yard yard = new Yard();
        Mower mower = new Mower();
        yard.yardCreator(16, 8);
        mower.setRow(2);
        mower.setColumn(1);
        mower.setDirection(1);
        while (mower.detectForward(yard) == '+') {
            mower.mowUnderneath(yard);
            mower.moveForward();
            delay(500);
            yard.printYard(mower);
        }
        mower.mowUnderneath(yard);
        yard.printYard(mower);
    }
}
