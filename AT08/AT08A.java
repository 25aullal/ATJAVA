import java.time.LocalDate;
import java.time.LocalTime;
//or, could do import java.time.*;
public class AT08A {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println("Today's date is " + date);
        System.out.println("The time is " + time);
    }
}