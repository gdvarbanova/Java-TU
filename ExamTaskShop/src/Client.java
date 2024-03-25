import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 4321);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Price Comparison Client connected to server.");

            while (true) {
                // Display menu
                System.out.println("Menu:");
                System.out.println("1. Search for a product");
                System.out.println("2. Add a product to the cart");
                System.out.println("3. View cart contents");
                System.out.println("4. Exit");
                System.out.print("Enter option: ");

                int option = scanner.nextInt();
                out.println(option);

                switch (option) {
                    case 1:
                        // Search for a product
                        System.out.print("Enter product name: ");
                        String productName = scanner.next();
                        out.println(productName);

                        // Receive search results
                        int searchResultSize = Integer.parseInt(in.readLine());
                        System.out.println("Search results:");
                        for (int i = 0; i < searchResultSize; i++) {
                            int id = Integer.parseInt(in.readLine());
                            String name = in.readLine();
                            double price = Double.parseDouble(in.readLine());
                            String store = in.readLine();
                            Product product = new Product(id, name, price, store);
                            System.out.println("Product ID: " + product.id +
                                    ", Name: " + product.name +
                                    ", Price: " + product.price +
                                    ", Store: " + product.store);
                        }
                        break;

                    case 2:
                        // Add a product to the cart
                        System.out.print("Enter product ID to add to cart: ");
                        int productId = scanner.nextInt();
                        out.println(productId);

                        // Receive result
                        boolean addToCartResult = Boolean.parseBoolean(in.readLine());
                        System.out.println("Product added to cart: " + addToCartResult);
                        break;

                    case 3:
                        // View cart contents
                        int numStores = Integer.parseInt(in.readLine());
                        System.out.println("Cart contents:");
                        for (int i = 0; i < numStores; i++) {
                            String storeName = in.readLine();
                            System.out.println("Store: " + storeName);
                            int numProducts = Integer.parseInt(in.readLine());
                            for (int j = 0; j < numProducts; j++) {
                                int productId1 = Integer.parseInt(in.readLine());
                                String productName1 = in.readLine();
                                double productPrice = Double.parseDouble(in.readLine());
                                Product product = new Product(productId1, productName1, productPrice, storeName);
                                System.out.println("   Product ID: " + product.id +
                                        ", Name: " + product.name +
                                        ", Price: " + product.price);
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Exiting client.");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}