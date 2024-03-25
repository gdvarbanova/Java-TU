package GuessTheNumber;
import java.util.HashMap;
//import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class PlayGame {
    public static void main(String[] args) {
        
        HashMap<String, Integer> playerResults = new HashMap<>();
        TreeSet <Integer> scorePlayers = new TreeSet<>();
        Scanner input = new Scanner(System.in);
        int attempts = 0;
        while(true){
            int randomNum = (int)(Math.random()*100+1);
            System.out.println("Welcome to the game!");
            System.out.print("Enter your name: ");
            String playerName = input.next();
            System.out.print("Guess a number between 1 - 100: ");
            int playerNum = input.nextInt();
            while(true){
                if(playerNum > randomNum) {
                    System.out.print("Too high! Try again!  ");
                    attempts++;
                    playerNum = input.nextInt();
                }
                if(playerNum < randomNum) {
                    System.out.print("Too low! Try again!   ");
                    attempts++;
                    playerNum = input.nextInt();
                }
                if(playerNum == randomNum) {
                    System.out.print("Congratulations " + playerName  + "! Game clear! \n Attempts: " + attempts + "\n");
                    break;
                }
            }
            if(playerResults.containsKey(playerName)){
                if(playerResults.get(playerName)>attempts){
                    playerResults.replace(playerName, attempts);
                }
            }
            else{
                playerResults.put(playerName, attempts);
            }
            scorePlayers.add(attempts);
            System.out.println("Would you like to play again? Yes/No");
            String wish = input.next();
            if(wish.equalsIgnoreCase("No")) break;
        }
        input.close();
        System.out.println("Player scores: " + scorePlayers);
    }
}
