import java.util.ArrayList;
import java.util.Comparator;

public class computerHand implements player{

    private ArrayList<Integer> cards;
    private boolean turn;


    public computerHand(int amount, deck Deck, hand Hand){
        cards = new ArrayList<>();

        for(int i = 0; i < amount; i++){
            int randomCard = (int)(Math.random()*52);
            while(Hand.contains(randomCard) || this.cards.contains(randomCard)){
                randomCard = (int)(Math.random()*52);
            }
            cards.add((Integer)randomCard);
        }

        this.turn = false;
    }

    @Override
    public void showHand(deck Deck){
        System.out.println("Computer Hand:");
        for(Integer value: cards){
            System.out.println(Deck.getCard(value));
        }
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
    public void playTurn(pile mainPile,deck Deck){


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
            int temp = this.cards.get(smallestPosition);
            this.cards.set(smallestPosition, this.cards.get(i));
            this.cards.set(i, temp);


        }

    }


}
