import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    static ArrayList<ClientHandler> clients;

    public static void main(String[] args) {
        int portNumber = 8675;
        clients = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(portNumber);) {
            System.out.println("Server is listening on port " + portNumber);

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    new Thread(clientHandler).start();
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