package LabOOP;

public class MainDance {
    public static void main(String[] args) {
        DanceMove dm1 = new DanceMove();

        
        // Check if car is an instance of DanceMove
        if (dm1 instanceof DanceMove) {
            System.out.println("dm1 is an instance of DanceMove");
        } else {
            System.out.println("dm1 is not an instance of DanceMove");
        }



        BreakDanceMove db1 = new BreakDanceMove();

        
        // Check if car is an instance of SimpleCar
        if (db1 instanceof BreakDanceMove) {
            System.out.println("db11 is an instance of BreakDanceMove");
        } else {
            System.out.println("car1 is not an instance of BreakDanceMove");
        }
    }
}
