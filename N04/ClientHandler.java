import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String name;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        // use try with catch statement to create output and input streams.
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Connected to client " + clientSocket.getInetAddress().getHostAddress()
                    + " on port " + clientSocket.getPort());
            String inputLine;

            // get name from the client.
            out.println("Enter your user name: ");
            name = in.readLine();

            System.out.printf("Client %s is using the name \"%s\"\n",
                    clientSocket.getInetAddress().getHostAddress(), name);
            ChatServer.broadcastMessage(name + " has joined the chat server!");

            while ((inputLine = in.readLine()) != null) {
                // include user's name with the message.
                String message = String.format("%s: %s", name, inputLine);
                // display message on server's standard output.
                System.out.println("received - " + message);
                // "broadcast" the message to everyone in the client list.
                ChatServer.broadcastMessage(message);
            }

            System.out.printf("Client disconnected: %s (%s)%n", clientSocket.getInetAddress().getHostAddress(),
                    name);
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            // make sure to close all non-null connections.
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.err.println("Error closing input stream: " + e.getMessage());
                }
            }

            // remove from list of clients.
            ChatServer.removeClient(this);
        }
    }

    public void sendMessage(String message) {
        if (out != null) {
            out.println(message);
        }
    }
}