import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    static ArrayList<ClientHandler> clients;

    public static void main(String[] args) {
        // get port number from the input arguments;
        int portNumber = 8675;

        // create an ArrayList to hold our client connections.
        clients = new ArrayList<>();

        // use try with resources to create server socket.
        try (ServerSocket serverSocket = new ServerSocket(portNumber);) {
            System.out.println("Server is listening on port " + portNumber);

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept(); // Accept incoming client connection
                    System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                    // Create a new thread to handle the client
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    new Thread(clientHandler).start();

                    // add clientHandler to array list.
                    clients.add(clientHandler);

                } catch (IOException e) {
                    System.err.println("Error accepting client connection: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Goodbye!");
        }
    }

    static void broadcastMessage(String message) {
        // iterate through list of connections and send message to everyone.
        for (ClientHandler handler : clients) {
            if (handler != null) {
                handler.sendMessage(message);
            }
        }
    }

    static void removeClient(ClientHandler tgtHandler) {
        int index = clients.indexOf(tgtHandler);
        if (index >= 0) {
            clients.remove(index);
        }
    }
}