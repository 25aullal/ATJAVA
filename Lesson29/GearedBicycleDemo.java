public class GearedBicycleDemo {
    public static void main(String[] args) {
        Bicycle avi1 = new Bicycle();
        avi1.setSpeed(25);
        System.out.printf("Avi1 initial speed = %d%n", avi1.getSpeed());
        System.out.println("Braking 10 times...");
        int i = 0;
        while (i < 10) {
            avi1.brake();
            i++;
        }
        System.out.printf("Avi1 final speed = %d%n", avi1.getSpeed());

        System.out.println();
        GearedBicycle avi2 = new GearedBicycle();
        avi2.setSpeed(25);
        System.out.printf("Avi2 initial speed = %d%n", avi2.getSpeed());
        System.out.println("Braking 10 times...");
        avi2.setGear(4);
        int j = 0;
        while (j < 10) {
            avi2.brake();
            j++;
        }
        System.out.printf("Avi2 final speed = %d%n", avi2.getSpeed());
    }
}
