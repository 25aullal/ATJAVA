package animate;

import javax.swing.JFrame;
import java.awt.EventQueue;

public class Application extends JFrame {
    private final int FRAME_WIDTH = 1600;
    private final int FRAME_HEIGHT = 900;

    /*
     * Constructor.
     */
    public Application(String title) {
        // the values for border width and title bar height
        // depend on the operating system.
        int border_width = 0;
        int bar_height = 0;
        OS os = checkOS();
        switch (os) {
            case WIN:
                border_width = 7;
                bar_height = 30;
                break;
            case MAC:
                border_width = 0;
                bar_height = 28;
                break;
            case LINUX:
                // I don't know what the values are for Linux.
                break;
            case OTHER:
                break;
        }

        // int application_width = FRAME_WIDTH + 2 * border_width;
        // int application_height = FRAME_HEIGHT + bar_height + border_width;
        this.setTitle(title);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static enum OS {
        WIN, MAC, LINUX, OTHER
    }

    public static OS checkOS() {
        OS val;
        String name = System.getProperty("os.name").toLowerCase();
        if (name.indexOf("win") >= 0) {
            val = OS.WIN;
        } else if (name.indexOf("mac") >= 0) {
            val = OS.MAC;
        } else if (name.indexOf("nux") >= 0) {
            val = OS.LINUX;
        } else {
            val = OS.OTHER;
        }
        return val;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application app = new Application("Basically GTA 6");
            Board board = new Board();
            app.add(board);
            app.pack();
            app.setVisible(true);
        });
    }
}