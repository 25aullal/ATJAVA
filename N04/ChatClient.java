import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    public static boolean doneFlag;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println(
                    "Usage: java ChatClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];

        int portNumber = 0;
        try {
            portNumber = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Unable to parse the port number!");
            System.err.println("Usage: java ChatClient <host name> <port number>");
            System.exit(1);
        }

        try {
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("Connected to server " + socket.getInetAddress().getHostAddress()
                    + " on port " + socket.getPort());
            MessageHandler messageHandler = new MessageHandler(socket);
            new Thread(messageHandler).start();

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
            }

            System.out.println("Goodbye!");
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}