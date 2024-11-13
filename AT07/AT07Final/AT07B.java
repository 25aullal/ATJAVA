import java.util.Scanner;

class DescartesMaker {
    private int x;
    private int y;
    
//constructors
    public DescartesMaker() {
        x = 0;
        y = 0;
    }

    public DescartesMaker(int xInitial, int yInitial) {
        x = xInitial;
        y = yInitial;
    }

    public void setPoint(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    

    public double getR() {
        double r = Math.sqrt(Math.pow((double)x,2) + Math.pow((double)y,2));
        return r;
    }

    public double getTheta() {
        double theta = Math.atan((double)y/(double)x);
        return theta;
    }

    public void translateBy(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
public class AT07B {
    public static void main(String[] args) {
//can set coords here:
        DescartesMaker plane = new DescartesMaker(3,3);
        Scanner in = new Scanner(System.in);
        int i = 0;
        
        while (i == 0) {
            System.out.printf("Enter: %n'setpoint' to set a point%n'getx' to get x coord%n'gety' to get y coord%n'translate' to translate point%n'getr' to get polar radius%n'gettheta' to get polar angle in radians%n'q' to quit:%n");
            String action = (in.nextLine()).toUpperCase();

            if (action.equals("SETPOINT")) {
                System.out.print("Print x coord then y coord: ");
                int x = in.nextInt();
                int y = in.nextInt();
                plane.setPoint(x,y);
                in.nextLine();
            }
            
            if (action.equals("GETX")) {
                System.out.println("X coordinate is " + plane.getX());
            }

            if (action.equals("GETY")) {
                System.out.println("Y coordinate is " + plane.getY());
            }

            if (action.equals("GETTHETA")) {
                System.out.println("Polar angle is " + plane.getTheta() + " radians");
            }

            if (action.equals("GETR")) {
                System.out.println("Polar radius is " + plane.getR());
            }

            if (action.equals("Q")) {
                i++;
            }

            if (action.equals("TRANSLATE")) {
                System.out.print("Insert how much you want to translate x and y coordinates (dx then dy): ");
                int dx = in.nextInt();
                int dy = in.nextInt();
                plane.translateBy(dx,dy);
                in.nextLine();
            }
        }

    }
}
