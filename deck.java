import java.util.HashMap;

public class deck {

    //Deck
    private HashMap<Integer, Card> deck;

    //Faces
    private final static String[] suits = {"Club", "Spade", "Heart", "Diam"};

    //Non-number values
    private final static String[] values = {"3","4","5","6","7","8","9","10","J","Q","K","A", "2"};


    //Constructor to create 52 card deck
    public deck() {

        this.deck = new HashMap<>();
        int value = 0;
        for(String face: values){
            for(String suit: suits){
                Card card = new Card(suit, face);
                this.deck.put(value, card);
                value++;
            }
        }

    }

    public Card getCard(int value){
        return this.deck.get(value);
    }



}
