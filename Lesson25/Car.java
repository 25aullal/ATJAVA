public class Car {
    private double maxSpeed;
    private double speed;

    public Car() {
        maxSpeed = 120.0;
        speed = 0.0;
    }

    public Car(double initialSpeed) {
        maxSpeed = 120.0;

        if (initialSpeed >= 0.0 && initialSpeed <= 120.0) {
            speed = initialSpeed;
        } else {
            System.out.println("Can't start that fast. Go back to 0, do not collect $200.");
            speed = 0.0;
        }
    }

    public Car(double maxRaceSpeed, double initialSpeed) {
        if (maxRaceSpeed >= 120 && maxRaceSpeed <= 300) {
            maxSpeed = maxRaceSpeed;
        } else {
            System.out.println("We do not build cars like that :(");
        }

        if (initialSpeed >= 0.0 && initialSpeed <= 120.0) {
            speed = initialSpeed;
        } else {
            System.out.println("Can't start that fast. Go back to 0, do not collect $200.");
            speed = 0.0;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void accelerate() {
        if (speed + 1 <= maxSpeed) {
            speed += 1;
        } else {
            System.out.println("Car has reached max speed! Besides, why on earth would you want to go faster???");
        }
    }

    public void brake() {
        if (speed > 0) {
            speed = speed - 0.1;
        } else {
            System.out.println("Can't go slower than 0, silly.");
        }
    }

    public static void main(String[] args) {
        Car racecar = new Car(300, 0);
        for (int i = 0; i < 200; i++) {
            racecar.accelerate();
            System.out.printf("Speed: %.1f mph%n", racecar.getSpeed());
        }
        for (int j = 0; j < 10; j++) {
            racecar.brake();
            System.out.printf("Speed: %.1f mph%n", racecar.getSpeed());
        }

    }
}