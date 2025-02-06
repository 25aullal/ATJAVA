public class GearedBicycle extends Bicycle {
    private final int GEARED_MAX_SPEED = 50;
    private final int MAX_GEARS = 6;
    private int currentGear = 1;

    public int getCurrentGear() {
        return currentGear;
    }

    public void setGear(int gear) {
        if (gear >= 1 && gear <= MAX_GEARS) {
            currentGear = gear;
        }
    }

    public void shiftUp() {
        if (currentGear < MAX_GEARS) {
            currentGear += 1;
        }
    }

    public void shiftDown() {
        if (currentGear > 1) {
            currentGear -= 1;
        }
    }

    public void pedal() {
        int newSpeed = getSpeed() + getCurrentGear();
        if (newSpeed > GEARED_MAX_SPEED) {
            newSpeed = GEARED_MAX_SPEED;
        }
        setSpeed(newSpeed);
    }

    public void brake() {
        int newSpeed = getSpeed() - 2;
        if (newSpeed < 0) {
            newSpeed = 0;
        }
        setSpeed(newSpeed);
    }

}
