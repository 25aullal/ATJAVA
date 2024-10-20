public class Loops08A {
    public static void main(String[] args) {
        
        double percent = 100.0;
        int years = 0;
        while (percent > 1.0) {
            years += 30;
            percent = percent/2.0;
        }

        double percent_decayed = (100-percent);
        System.out.printf("After %d years, Cesium 90 will have decayed %f percent", years, percent_decayed);

    }
}