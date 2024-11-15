public class CallMethod {
   public static double smallest(double a, double b, double c) {
       if (b >= a && c >= a)  {
           return a;
       } else if (a >= b && c >= b){
           return b;
       } else {
            return c;
       }
   }
   public static void main(String[] args) {
       double x = 5.4;
       double y = 5.4;
       double z = 5.4;
       
       double val = smallest(x, y, z);
       System.out.println("Smallest value = " + val);

    }
}
