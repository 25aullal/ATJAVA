package animate;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

class Cannon {
    private double x;
    private double y;
    private double theta;
    private SoundClip cannonS;
    private SoundClip wheelS;
    private BufferedImage img;

    private double vm = 30;
    private final int HYPOT = 100;

    public Cannon() {
        cannonS = new SoundClip("media/cannon.wav");
        wheelS = new SoundClip("media/wheel.wav");
        cannonS.open();
        wheelS.open();
        try {
            File imageFile = new File("media/sm_cannon.png");
            img = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        theta = 315.0;
        x = 60;
        y = 840;

    }

    public Cannon(double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.theta = angle;
        cannonS.open();
        wheelS.open();

        try {
            File imageFile = new File("media/sm_cannon.png");
            img = ImageIO.read(imageFile);
            System.out.println("Cannon image loaded successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getTheta() {
        return theta;
    }

    public double getVelocity() {
        return vm;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public void setVelocity(double vm) {
        this.vm = vm;
    }

    public void rotateCW() {
        if (theta < 360) {
            theta++;
            wheelS.play();
        } else {
            System.out.println("Cannon is already horizontal");
        }
    }

    public void rotateCCW() {
        if (theta > 270) {
            theta--;
            wheelS.play();
        } else {
            System.out.println("Cannon is already vertical");
        }
    }

    public void render(Graphics2D g2d) {
        AffineTransform affineTransform = new AffineTransform();

        if (img != null) {
            double x_t = 15;
            double y_t = img.getHeight() / 2.0;
            double r = Math.toRadians(theta);

            affineTransform.translate(x - x_t, y - y_t);
            affineTransform.rotate(r, x_t, y_t);

            g2d.drawImage(img, affineTransform, null);

        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }

        int[] xCoords = { (int) x, (int) x - 40, (int) x + 40 };
        int[] yCoords = { (int) y, (int) y + 40, (int) y + 40 };
        g2d.setColor(Color.PINK);
        g2d.fillPolygon(xCoords, yCoords, 3);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(xCoords, yCoords, 3);

        g2d.setColor(Color.BLUE);
        g2d.fillOval((int) (x - 5), (int) (y - 5), 10, 10);

    }

    public void cannonFire() {
        cannonS.play();
    }

    public void cannonFire(CannonBall cannonball) {
        double x_initial = HYPOT * Math.cos(2 * Math.PI - Math.toRadians(theta));
        double y_initial = HYPOT * Math.sin(2 * Math.PI - Math.toRadians(theta));

        double vx = vm * Math.cos(2 * Math.PI - Math.toRadians(theta));
        double vy = -vm * Math.sin(2 * Math.PI - Math.toRadians(theta));

        cannonball.launch(x + x_initial, y - y_initial, vx, vy);
        this.cannonFire();
    }

}

public class Board extends JPanel implements KeyListener {
    private final int B_WIDTH = 1600;
    private final int B_HEIGHT = 900;
    private final int SIDE_LEN = 150;
    private Cannon cannon;
    private CannonBall cannonBall;
    private Timer timer;
    private final int INITIAL_DELAY = 0;
    private final int TIMER_INTERVAL = 20;

    /*
     * Constructor
     */
    public Board() {
        cannon = new Cannon();
        int FLOOR = B_HEIGHT - 25;
        cannonBall = new CannonBall(0, 1, FLOOR);
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        timer = new Timer();
        timer.scheduleAtFixedRate(new UpdateAnimation(), INITIAL_DELAY, TIMER_INTERVAL);

        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);
    }

    private class UpdateAnimation extends TimerTask {
        public void run() {
            cannonBall.updateBall();
            repaint();
        }
    }

    private void displayInfo(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.drawString("Press LEFT/RIGHT arrows to adjust  angle", 550, 20);
        g2d.drawString("Press UP/DOWN arrows to adjust time scale", 550, 40);
        g2d.drawString("Press SPACE to fire", 550, 60);
        g2d.drawString("Angle = " + (360 - cannon.getTheta()) + " deg", 550, 80);
        g2d.drawString("Timescale = " + cannonBall.getTimeScale(), 550, 100);
    }

    public void paintComponent(Graphics g) {
        // call the parent class method.
        super.paintComponent(g);

        // cast our Graphics object to a Graphics2D object.
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        int FLOOR = B_HEIGHT - 25;
        g2d.drawLine(0, FLOOR, B_WIDTH, FLOOR);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, FLOOR + 1, B_WIDTH, B_HEIGHT);

        cannon.render(g2d);
        cannonBall.draw(g2d);
        displayInfo(g2d);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up arrow pressed");
            cannonBall.changeTimeScale(1);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Down arrow pressed");
            cannonBall.changeTimeScale(-1);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right arrow pressed");
            cannon.rotateCW();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left arrow pressed");
            cannon.rotateCCW();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Spacebar pressed");
            cannon.cannonFire(cannonBall);
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}
