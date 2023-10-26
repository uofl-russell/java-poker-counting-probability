import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Integer> cardNumbers;
    private Random rand;

    public Deck() {
        rand = new Random();
        reset();
    }

    public void reset() {
        cardNumbers = new ArrayList<Integer>();
        for (int i=0; i<52; i++) {
            Integer tmp = i;
            cardNumbers.add(tmp);
        }
    }
    public Card getCard() {
        int arrayID = rand.nextInt(cardNumbers.size()-1);
        int cardID = cardNumbers.get(arrayID);
        Card C = new Card(cardID);
        cardNumbers.remove(arrayID);
        return C;
    }
}
