package AT05;
import java.util.Scanner;

class DimmableLight {
   
    boolean state = false;
    int brightness = 1;

   
    public void turnOn() {
        state = true;
    }

    public void turnOff() {
        state = false;
    }
    
    public boolean viewState() {
        return state;
    }

    public int viewBrightness() {
        return brightness;
    }

    public int turnUp() {
        if (brightness <10) {
            return brightness++;
        } else {
            return brightness;
        }
    }

    public int turnDown() {
        if (brightness > 1) {
            return brightness--;
        } else {
            return brightness;
        }
    }

}

public class ObjectB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // create a light object.
        DimmableLight light = new DimmableLight();

        System.out.printf("There is a light. It has brightness levels 1-10 and can turn on and off. Typing:%n\"on\" turns it on%n\"off\" turns it off%n\"up\" turns dim up%n\"down\" turns dim down%n\"views\" allows you to view state on or off%n\"viewb\" allows you to view brightness%n");
        int i = 0;
        while (i == 0) {
            String action = (in.nextLine()).toUpperCase();
            if (action.equals("UP")) {
                light.turnUp();
            }

            if (action.equals("DOWN")) {
                light.turnDown();
            }

            if (action.equals("ON")) {
                light.turnOn();
            }

            if (action.equals("OFF")) {
                light.turnOff();
            }

            if (action.equals("VIEWS")) {
                if (light.viewState() == true) {
                    System.out.println("Light is on");
                } else {
                    System.out.println("Light is off");
                }

            }

            if (action.equals("VIEWB")) {
                System.out.println("Brightness = " + light.viewBrightness());
            }

            if (action.equals("Q")) {
                i++;
            }
        }
    }
}