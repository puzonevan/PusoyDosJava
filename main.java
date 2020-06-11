import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String [] args){

        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to Pusoy Dos");
        System.out.println("Here are the rules: ");
        printRules();

        System.out.print("Ready to start? yes(1) no(2): ");
        int input = reader.nextInt();
        if(input == 1){

            startGame();
        }

        System.out.println("Thanks for playing");
    }

    /**
     *  printRules method - prints rules of the game
     *  no parameters
     *  return void
     */
    public static void printRules(){


    }

    /**
     *  startGame method - starts and plays the game
     *  Scanner reader - input scanner
     *  return void
     */
    public static void startGame() {

        System.out.println("Generating deck...");
        deck Deck = new deck();

        System.out.println("Generating hand and computer...");
        hand player1 = new hand(26, Deck);
        computerHand computer1 = new computerHand(26, Deck, player1);

        System.out.println("Generating pile...");
        pile mainPile = new pile();


        //Check for who has 3 of clubs - first turn
        if(player1.contains(0)){
            player1.changeTurn(true);
            player1.playTurn(mainPile,Deck);
            computer1.changeTurn(true);
        }
        else{
            computer1.changeTurn(true);
            computer1.playTurn(mainPile,Deck);
            player1.changeTurn(true);
        }


        while(true){

            //Once the player or computer hand is empty, game over
            if(player1.isEmpty() || computer1.isEmpty()){ break; }

            player1.playTurn(mainPile,Deck);
            computer1.playTurn(mainPile,Deck);

        }


    }

}
