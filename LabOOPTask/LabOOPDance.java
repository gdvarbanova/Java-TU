package LabOOP;
import java.util.Scanner;

interface Dancable{
    void dance();
}
//zad 7 
class DanceMove extends Performance{
    String name;
    int duration;
    
    void perform(){
        System.out.println("Performing " + name + " for " + duration + " seconds.");
    }

    public void dance(){
        System.out.println("Dancing " + name);
    }
}

//zad 8 
class BreakDanceMove extends DanceMove{
    int complexity;
}

class Song extends Performance{
    String name;
}


public class LabOOPDance {
    public static void main(String[] args) {
        //zad 7
        /*DanceMove dance1 = new DanceMove();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the move name: ");
        dance1.name = input.nextLine();
        System.out.print("Enter the duration (in seconds): ");
        dance1.duration = input.nextInt();
        input.close();
        dance1.perform();*/


        //zad 8
        /*BreakDanceMove breakD1 = new BreakDanceMove();
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter the move name: ");
        breakD1.name = input1.nextLine();
        System.out.print("Enter the duration (in seconds): ");
        breakD1.duration = input1.nextInt();
        System.out.print("Enter the complexity): ");
        breakD1.complexity = input1.nextInt();
        input1.close();
        System.out.println("Performing " + breakD1.name + " for " + breakD1.duration + " seconds at complexity level " + breakD1.complexity);
        */

        //zad 9
        //breakD1.dance();

        //zad 10
        //breakD1.start();

        //zad 11
        Song song1 = new Song();
        song1.name = "Bohemian Rhapsody";
        song1.song(song1.name);
    }
}
