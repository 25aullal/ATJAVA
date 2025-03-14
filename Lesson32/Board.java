import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

public class Board extends JPanel implements KeyListener, MouseListener {
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private int x = B_WIDTH / 2;
    private int y = B_HEIGHT / 2;
    private SoundClip blip;
    private SoundClip blop;

    /*
     * Constructor
     */
    public Board() {
        // set background color of the board and default size.
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        this.setFocusable(true);
        this.addMouseListener(this);
        this.addKeyListener(this);
        blip = new SoundClip("media/blip.wav");
        blop = new SoundClip("media/blop.wav");
        blip.open();
        blop.open();

    }

    public void mousePressed(MouseEvent m) {
        x = m.getX();
        y = m.getY();
        repaint();
        blip.play();
    }

    public void mouseReleased(MouseEvent m) {

    }

    public void mouseEntered(MouseEvent m) {

    }

    public void mouseClicked(MouseEvent m) {

    }

    public void mouseExited(MouseEvent m) {

    }

    public void paintComponent(Graphics g) {
        // call the parent class method.
        super.paintComponent(g);

        // cast our Graphics object to a Graphics2D object.
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.MAGENTA);
        g2d.fillOval(x - 10, y - 10, 20, 20);

    }

    public void keyTyped(KeyEvent e) {
        // put implementation here.
        if (e.getKeyChar() == ' ') {
            blop.play();
        }
        x = B_WIDTH / 2;
        y = B_HEIGHT / 2;
        repaint();

    }

    public void keyPressed(KeyEvent e) {
        // put implementation here.
    }

    public void keyReleased(KeyEvent e) {
        // put implementation here.
    }

}
