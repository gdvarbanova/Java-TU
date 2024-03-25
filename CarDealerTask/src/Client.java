import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class CarClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 4321);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Car Client connected to server.");

            while (true) {
                // Display menu
                System.out.println("Menu:");
                System.out.println("1. Search for a car");
                System.out.println("2. Price your car and sell or not");
                System.out.println("3. View dealer cars");
                System.out.println("4. Exit");
                System.out.print("Enter option: ");

                int option = scanner.nextInt();
                out.println(option);

                switch (option) {
                    case 1:
                        // Search for a car
                        System.out.print("Enter car brand: ");
                        String carBrand = scanner.next();
                        out.println(carBrand);

                        // Receive search results
                        int searchResultSize = Integer.parseInt(in.readLine());
                        System.out.println("Search results:");
                        for (int i = 0; i < searchResultSize; i++) {
                            String brand = in.readLine();
                            String model = in.readLine();
                            double price = Double.parseDouble(in.readLine());
                            System.out.println("Car Brand: " + brand +
                                    ", Model: " + model +
                                    ", Price: " + price);
                        }
                        break;

                    case 2:
                        // Price your car and sell or not
                        System.out.print("Enter your car (format: brand model price): ");
                        String carInput = scanner.next() + " " + scanner.next() + " " + scanner.nextDouble();
                        out.println(carInput);

                        // Receive offered price
                        String offeredPriceMessage = in.readLine();
                        System.out.println(offeredPriceMessage);

                        // Ask for user's response
                        System.out.print("Do you want to sell it (YES/NO): ");
                        String answer = scanner.next();
                        out.println(answer);

                        // Receive final response
                        System.out.println(in.readLine());
                        break;

                    case 3:
                        // View dealer cars
                        int numDealerCars = Integer.parseInt(in.readLine());
                        System.out.println("Dealer cars:");
                        for (int i = 0; i < numDealerCars; i++) {
                            System.out.println(in.readLine());
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
