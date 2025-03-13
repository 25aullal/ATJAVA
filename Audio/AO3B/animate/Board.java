package AO3B.animate;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import java.awt.image.BufferedImage;
import java.io.File;

import java.util.Timer;
import java.util.TimerTask;

public class Board extends JPanel {
    private final int B_WIDTH = 720;
    private final int B_HEIGHT = 720;
    private int x = (int) (Math.random() * 721);
    private int y = (int) (Math.random() * 721);;
    private double r = 0.0;

    private BufferedImage img;

    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;
    private int xSpeed = (int) (Math.random() * 5 + 1);
    private int ySpeed = (int) (Math.random() * 5 + 1);
    private double rSpeed = 0.08726645;
    private SoundClip ow = new SoundClip("AO3B/media/ow.wav");
    private SoundClip sitar = new SoundClip("AO3B/media/sitar.wav");

    private class ScheduledUpdate extends TimerTask {

        public void run() {
            x += xSpeed;
            y += ySpeed;
            r += rSpeed;

            repaint();

        }

    }

    public Board() {

        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        try {
            File imageFile = new File("AO3B/media/Andy.png");
            img = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(),
                INITIAL_DELAY, PERIOD_INTERVAL);

        sitar.open();
        sitar.setLoop(true);
        sitar.play();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform affineTransform = new AffineTransform();
        ow.open();

        if (img != null) {

            int x_t = img.getWidth() / 2;
            int y_t = img.getHeight() / 2;
            affineTransform.translate(x - x_t, y - y_t);
            affineTransform.rotate(r, x_t, y_t);

            if (x - x_t <= xSpeed) {
                xSpeed = Math.abs(xSpeed);
                xSpeed++;
                ow.play();
            } else if (x - x_t >= 720 - xSpeed) {
                xSpeed++;
                xSpeed = (-1) * Math.abs(xSpeed);
                ow.play();
            } else if (y - y_t <= ySpeed) {
                ySpeed = Math.abs(ySpeed);
                ySpeed++;
                ow.play();
            } else if (y - y_t >= 720 - ySpeed) {
                ySpeed++;
                ySpeed = (-1) * Math.abs(ySpeed);
                ow.play();
            }

            g2d.drawImage(img, affineTransform, null);

        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }
    }

    public static void main(String[] args) {

    }

}
