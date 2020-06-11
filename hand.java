import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class hand implements player{

    //Represent a hand by the card's value through integer
    private ArrayList<Integer> cards;
    private boolean turn;

    //Constructor - creates hand of amount cards and given deck
    public hand(int amount, deck Deck){
        cards = new ArrayList<>();

        for(int i = 0; i < amount; i++){
            int randomCard = (int)(Math.random()*52);
            while(this.cards.contains(randomCard)){ randomCard = (int)(Math.random()*52); }
            cards.add((Integer)randomCard);
        }
        this.turn = false;
    }


    @Override
    public void showHand(deck Deck){
        System.out.println("Your Hand:");
        for(int i = 0; i < this.cards.size(); i++){
            if(i%3 == 0){
                System.out.println();
            }
            System.out.print(i + 1 + ": " +Deck.getCard(this.cards.get(i)) + "\t");
        }
        System.out.println();
        System.out.println("_________________________");
    }

    @Override
    public boolean contains(int card){
        if(this.cards.contains(card)){return true;}
        return false;
    }

    @Override
    public boolean isEmpty(){
        return this.cards.isEmpty();
    }

    @Override
    public void changeTurn(boolean turn){
        this.turn = turn;
    }

    @Override
    public void playTurn(pile mainPile,deck Deck)  {
        Scanner reader = new Scanner(System.in);


        //If it's player's turn and has 3 of clubs
        if(this.turn && this.cards.contains(0)){
            System.out.println("You have the 3 of Clubs, your first move must contain this card");
        }

        while(this.turn){

            //Show Options
            printOptions();
            //Get Input
            System.out.print("Input: ");
            int input = reader.nextInt();

            //Input: 1 - Show Hand
            if(input == 1){  this.showHand(Deck); }
            //Input: 2 - Sort Hand
            else if(input == 2){ sortHand(); }
            //Input: 3 - Play Turn
            else if(input == 3){

                //List of Cards
                ArrayList<Integer> play = new ArrayList<Integer>();

                //Card Input
                reader.nextLine();
                System.out.print("Cards: ");
                String cardInput = reader.nextLine();
                String[] cards = cardInput.split(" ");

                //Add each card to the play
                for(String card: cards){
                    int address = Integer.parseInt(card);
                    play.add(this.cards.get(address-1));
                }

//                //Show the play
//                for(Integer a: play){
//                    System.out.println(Deck.getCard(a));
//                }

                //Check valid play
                if(checkValidPlay(mainPile, Deck, play))



                this.changeTurn(false);
            }
            //Input: 4 - Skip Turn
            else if(input == 4){ this.changeTurn(false); }
            //Input: else - invalid input
            else{ System.out.println("Invalid input, try again"); }

        }
    }

    @Override
    public void sortHand(){

        for(int i = 0; i < this.cards.size(); i++){
            int smallestPosition = i;

            //Find smallest element
            for(int j = i + 1; j < this.cards.size(); j++){
                if(this.cards.get(j) < this.cards.get(smallestPosition)) {
                    smallestPosition = j;
                }
            }

            //Swap smallest element
            int temp = this.cards.get(i);
            this.cards.set(i, this.cards.get(smallestPosition));
            this.cards.set(smallestPosition, temp);
        }

    }

    private static void printOptions(){
        System.out.println("1: Show hand \t 3: Play");
        System.out.println("2: Sort hand \t 4: Skip");
    }


    private static boolean checkValidPlay(pile mainPile, deck Deck, ArrayList<Integer> play){
        String category = "";
        if(play.size() == 1){ category = "Single"; }
        else if(play.size() == 2){ category = "Double"; }
        else if(play.size() == 3){ category = "Triple"; }
        else if(play.size() == 4){
        category = "Quad";
        }
        

    }




}
