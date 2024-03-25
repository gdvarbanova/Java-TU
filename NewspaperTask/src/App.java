import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

    static NewspaperSystem newspaperSystem = new NewspaperSystem();

    public static void main(String[] args) {
        System.out.println("Server started!");

        try (ServerSocket server = new ServerSocket(1211)) {
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected: " + server.getInetAddress());
                System.out.println("Current user base: " + newspaperSystem.getUsers());
                Thread thread = new Thread(new UserThread(clientSocket, newspaperSystem));
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}

