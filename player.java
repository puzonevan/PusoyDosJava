import java.io.IOException;

public interface player {

    public void showHand(deck Deck);
    public boolean contains(int card);
    public boolean isEmpty();
    public void changeTurn(boolean turn);
    public void playTurn(pile mainPile, deck Deck) throws IOException;
    public void sortHand();
}
