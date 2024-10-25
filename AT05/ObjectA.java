package AT05;

import java.util.Random;
public class ObjectA {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i<=100; i++){
            System.out.println(random.nextInt(100)); 
        }
        
    }
}
