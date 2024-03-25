package LabOOP;

//zad 6
public class MainCars {
    public static void main(String[] args) {
        SimpleCar car = new SimpleCar();

        
        // Check if car is an instance of SimpleCar
        if (car instanceof SimpleCar) {
            System.out.println("car is an instance of SimpleCar");
        } else {
            System.out.println("car is not an instance of SimpleCar");
        }



        FamilyCar car1 = new FamilyCar();

        
        // Check if car is an instance of SimpleCar
        if (car1 instanceof FamilyCar) {
            System.out.println("car1 is an instance of FamilyCar");
        } else {
            System.out.println("car1 is not an instance of FamilyCar");
        }
    }
}
