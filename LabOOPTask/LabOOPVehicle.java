package LabOOP;
import java.util.Scanner;


//zad 3
interface IHonkable {
    void honk();
}

//zad 1
class SimpleCar extends Vehicle{
    double speed;

    double accelerate(){
        return speed+10;
    }

    //zad 3
    public void honk() {
        System.out.println("Honk!");
    }
}

//zad 2
class FamilyCar extends Vehicle{
    int seats;

    int addSeat(){
        return seats+1;
    }
}

//zad 5
class Bicycle extends Vehicle{
    void pedal(){
        System.out.println("Pedaling the bicycle!");
    }
}




public class LabOOPVehicle {
    public static void main(String[] args) {

        //zad 1
        
        SimpleCar car1 = new SimpleCar();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the car's speed: ");
        car1.speed = input.nextDouble();
        input.close();
        System.out.println("Speed after accelerate: " + car1.accelerate());

        //zad 3
        //car1.honk();

        //zad 4
        car1.move();
        
        //zad 2
        /*FamilyCar famCar1 = new FamilyCar();
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter the car's seats: ");
        famCar1.seats = input1.nextInt();
        input1.close();
        System.out.println("Seats after adding 1: " + famCar1.addSeat());*/

        //zad 5
        /*Bicycle b1 = new Bicycle();
        b1.pedal();*/

        

        
    }
}
 