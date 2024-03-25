import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements  Runnable{
    Socket clientSocket;
    private static List<Car> cars;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Corolla", 5000));
        cars.add(new Car("Opel", "Astra", 10000));
        cars.add(new Car("Mercedes", "Idk", 4500));
    }

    @Override
    public void run() {
        try(
                PrintStream out = new PrintStream(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ){
                 while(true){
                    int choice = Integer.parseInt(in.readLine());
                    switch (choice){
                        case 1:
                            handleSearchCar(in, out);
                            break;

                        case 2:
                            handlePriceCarAndSellOrNot(in, out);
                            break;
                        case 3:
                            viewDealerCars(out);
                        default:
                            System.out.println("Invalid choice from client.");
                    }
                 }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public synchronized void handleSearchCar(BufferedReader in, PrintStream out) throws IOException{
        String carBrand = in.readLine();
        List<Car> searchResult = searchCar(carBrand);
        out.println(searchResult.size());
        for (Car car : searchResult) {
            out.println(car.getBrand());
            out.println(car.getModel());
            out.println(car.getPrice());
        }
    }

    public synchronized List<Car> searchCar(String brand){
        List<Car> carFound = new ArrayList<>();
        for(Car car : cars){
            if(car.getBrand().equalsIgnoreCase(brand)){
                carFound.add(car);
            }
        }
        return carFound;
    }

    public synchronized void handlePriceCarAndSellOrNot(BufferedReader in, PrintStream out) throws IOException {
        String carObj = in.readLine();
        double carPrice = Double.parseDouble(carObj.split(" ")[2]) - 100;
        out.println("Do you want to sell it (YES/NO): ");
        String answer = in.readLine();

        if (answer.equalsIgnoreCase("yes")) {
            cars.add(new Car(carObj.split(" ")[0], carObj.split(" ")[1], Double.parseDouble(carObj.split(" ")[2])));
            out.println("You received " + carPrice + "lv.");
        } else {
            out.println("Okay. Goodbye.");
        }
    }


    public synchronized void viewDealerCars(PrintStream out) {
        out.println(cars.size());
        for (Car car : cars) {
            out.println("Brand: " + car.getBrand() + " Model: " + car.getModel() + " Price: " + car.getPrice());
        }
    }
}
