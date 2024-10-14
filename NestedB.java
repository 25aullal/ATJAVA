import java.util.Scanner;

public class NestedB {
    public enum AgeType {CHILD, ADULT, SENIOR}
    public enum DayOfWeek {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}
        
    static public void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Cougar Cafe!");

        System.out.print("Please enter day of the week (0 = SUN, ..., 6 = SAT): ");
        int val = in.nextInt();
        DayOfWeek today;

        if (val == 0) {
            today = DayOfWeek.SUNDAY;
        } else if (val == 1) {
            today = DayOfWeek.MONDAY;
        } else if (val == 2) {
            today = DayOfWeek.TUESDAY;
        } else if (val == 3) {
            today = DayOfWeek.WEDNESDAY;
        } else if (val == 4) {
            today = DayOfWeek.THURSDAY;
        } else if (val == 5) {
            today = DayOfWeek.FRIDAY;
        } else {
            today = DayOfWeek.SATURDAY;
        }
       
    
        
        System.out.print("Enter age class: (0 = Child, 1 = Adult, 2 = Senior): ");
        int reply = in.nextInt();
        AgeType age_class;

        if (reply == 0) {
            age_class = AgeType.CHILD;
        } else if (reply == 1) {
            age_class = AgeType.ADULT;
        } else {
            age_class = AgeType.SENIOR;
        }


        
        System.out.println("Excellent! How much is the cost before discount?");
        double cost = in.nextDouble();
        double discount = 0.0;

        if (today == DayOfWeek.MONDAY) {
            if (age_class == AgeType.SENIOR) {
                discount = .15;
            } else if (age_class == AgeType.CHILD) {
                discount = 0.075;
            } else {
                discount = 0.05;
            } 
        } else {
            if (age_class == AgeType.SENIOR) {
                discount = 0.075;
            } else if (age_class == AgeType.CHILD) {
                discount = 0.05;
            }
        }

        double discounted_cost = (1-discount)*cost;
        double percent_discount = 100*discount;
        System.out.printf("Thanks for coming! Your total is %.2f after a %.0f%% discount%n", discounted_cost, percent_discount);
        
    
    }
}