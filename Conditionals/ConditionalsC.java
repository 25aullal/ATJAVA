public class ConditionalsC {
    public static void main(String[] args) {
     //original did not work because there is a tiny difference between identified values
        //modified to measure equality within a threshold
        final double THRESHOLD = 1e-14;
        double a = 1.2; 
        double b= 3.0;
        double c = a * b; 
        if(Math.abs(c-3.6) < THRESHOLD){
        System.out.println("c is 3.6");
        } else {
        System.out.println("c is not 3.6");
        }
    }
}