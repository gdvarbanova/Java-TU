import java.io.*;
import java.net.Socket;
import java.util.*;

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private static List<Product> products;
    private static Map<String, List<Product>> userCarts;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        this.products = new ArrayList<>();
        products.add(new Product(101, "Laptop", 899.99, "Electronics Store"));
        products.add(new Product(102, "Smartphone", 499.99, "Tech Shop"));
        this.userCarts = new HashMap<>();
    }

    @Override
    public void run() {
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            while (true) {
                int choice = Integer.parseInt(in.readLine());

                switch (choice) {
                    case 1:
                        handleProductSearch(in, out);
                        break;
                    case 2:
                        handleAddToCart(in, out);
                        break;
                    case 3:
                        handleGetCartInfo(out);
                        break;
                    default:
                        System.out.println("Invalid choice from client.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void handleProductSearch(BufferedReader in, PrintWriter out) throws IOException {
        String productName = in.readLine();
        List<Product> searchResult = searchProduct(productName);
        out.println(searchResult.size());
        for (Product product : searchResult) {
            out.println(product.id);
            out.println(product.name);
            out.println(product.price);
            out.println(product.store);
        }
    }

    private synchronized void handleAddToCart(BufferedReader in, PrintWriter out) throws IOException {
        int productId = Integer.parseInt(in.readLine());
        boolean added = addToCart(productId);
        out.println(added);
    }
    private synchronized void handleGetCartInfo(PrintWriter out) {
        List<CartEntry> cartInfo = getCartInfo();
        out.println(cartInfo.size()); // Send the number of stores in the cart
        for (CartEntry entry : cartInfo) {
            out.println(entry.storeName); // Store name
            out.println(entry.products.size()); // Number of products in the store
            for (Product product : entry.products) {
                out.println(product.id);
                out.println(product.name);
                out.println(product.price);
            }
        }
    }

    private synchronized List<Product> searchProduct(String productName) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.name.equalsIgnoreCase(productName)) {
                result.add(product);
            }
        }
        return result;
    }

    private synchronized boolean addToCart(int productId) {
        for (Product product : products) {
            if (product.id == productId) {
                String userId = "user123"; // replace with actual user identifier
                List<Product> userCart = userCarts.computeIfAbsent(userId, k -> new ArrayList<>());

                if (!userCart.contains(product)) {
                    userCart.add(product);
                    return true; // Successfully added to cart
                } else {
                    return false; // Product already in the cart
                }
            }
        }
        return false; // Product with productId not found
    }

    private synchronized List<CartEntry> getCartInfo() {
        String userId = "user123"; // replace with actual user identifier
        List<Product> userCart = userCarts.getOrDefault(userId, Collections.emptyList());

        List<CartEntry> cartInfo = new ArrayList<>();

        for (Product product : userCart) {
            boolean storeExists = false;
            for (CartEntry entry : cartInfo) {
                if (entry.storeName.equals(product.store)) {
                    entry.products.add(product);
                    storeExists = true;
                    break;
                }
            }

            if (!storeExists) {
                List<Product> storeProducts = new ArrayList<>();
                storeProducts.add(product);
                cartInfo.add(new CartEntry(product.store, storeProducts));
            }
        }

        return cartInfo;
    }
}