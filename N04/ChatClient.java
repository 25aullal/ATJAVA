import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    public static boolean doneFlag;

    public static void main(String[] args) {
        // check to make sure they provided two arguments.
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

        // use try with resources statement.
        try {
            // try to establish connection with server.
            Socket socket = new Socket(hostName, portNumber);

            // get output and input streams to communicate with the server.
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));

            // display connection info.
            System.out.println("Connected to server " + socket.getInetAddress().getHostAddress()
                    + " on port " + socket.getPort());

            // launch thread to handle messages from server.
            MessageHandler messageHandler = new MessageHandler(socket);
            new Thread(messageHandler).start();

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                // get input from the user and send it to the server.
                out.println(userInput);
                // we don't have to read from the server in this loop since we have
                // a separate thread to process messages from the server.
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