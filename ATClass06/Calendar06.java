import java.time.LocalDate;
import java.time.Month;


public class Calendar06 {
    public static void main(String[] args) {
        
        LocalDate today = LocalDate.now();
        Month month = today.getMonth();
       
        System.out.println("          "+month+"          ");
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        
        LocalDate firstOfMonth = today.minusDays(today.getDayOfMonth() - 1);
        int firstDayofWeek = firstOfMonth.getDayOfWeek().getValue();
    
        String space = "    ";
        int i = 1;
        while (i<firstDayofWeek) {
            System.out.print(space);
            i++;
        }

        int calendarDayFirst = firstOfMonth.getDayOfMonth();
        for (int i2 = calendarDayFirst; i2 <= today.lengthOfMonth(); i2++){
            LocalDate thisDay = firstOfMonth.plusDays(i2-1);
            int thisDay_DayOfWeek = thisDay.getDayOfWeek().getValue();
            if (thisDay_DayOfWeek == 1) {
                System.out.printf("%n");
            }
            System.out.printf("%3d", i2);
            if (i2 == today.getDayOfMonth()) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        
        System.out.printf("%n");
    }
}
