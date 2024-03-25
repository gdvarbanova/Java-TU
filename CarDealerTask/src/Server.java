import java.io.IOException;
import java.util.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        try(ServerSocket server = new ServerSocket(4321)){
            System.out.println("Server is running on port 4321...");
            ExecutorService executor = Executors.newFixedThreadPool(3);

            while (true){
                Socket clientSocket = server.accept();
                executor.execute(new ClientHandler(clientSocket));
            }
        }
        catch (IOException e){
            System.err.println("Server error: " + e.getMessage());
        }
    }
}