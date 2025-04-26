import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;

    public MessageHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            System.err.println("MessageHandler IOException occurred: " + e.getMessage());
            return;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.err.println("Error trying to close BufferedReader: " + e.getMessage());
                }
            }
        }
    }
}