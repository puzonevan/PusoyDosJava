public class Card {

    private String suit;
    private String face;


    public Card(String suit, String face) {
        this.suit = suit;
        this.face = face;

    }

    public String getSuit() {
        return this.suit;
    }

    public String getFace() {
        return this.face;
    }


    public void changeSuit(String suit) {
        this.suit = suit;
    }

    public void changeFace(String face){
        this.face = face;
    }

    public String toString(){
        return this.face + " of " + this.suit + "\t";
    }

}


