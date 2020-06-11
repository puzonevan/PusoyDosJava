import java.util.ArrayList;

public class pile {

    private ArrayList<Integer> cards;
    private String category;

    public pile(){
        this.cards = new ArrayList<>();
        this.category = "Single";
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public ArrayList<Integer> getCards(){ return this.cards; }

    public int getValue(){
        int sum = 0;
        for(int a: cards){
            sum += a;
        }
        return sum;
    }



}
