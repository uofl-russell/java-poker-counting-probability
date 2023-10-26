import java.util.ArrayList;
import java.util.Collections;

public class Hand {

    public enum Rank {
        ROYALFLUSH,
        STRAIGHTFLUSH,
        FOUROFKIND,
        FULLHOUSE,
        FLUSH,
        STRAIGHT,
        THREEOFKIND,
        TWOPAIR,
        PAIR,
        NONE,
        NOTENOUGHCARDS
    }
    private Card[] cards;
    private int cardCount = 0;

    Hand() {
        cards = new Card[5];
    }

    public void addCard(Card card) {
        cards[cardCount] = card;
        cardCount++;
    }

    public void reset() {
        cardCount = 0;
    }

    private boolean isStraight() {
        ArrayList<Integer> values = new ArrayList<Integer>(5);
        for (Card card : cards) {
            values.add(card.getCardKindValue());
        }
        Collections.sort(values);

        for (int i=1; i<values.size(); i++) {
            if (values.get(i) != values.get(i-1) + 1) {
                return false;
            }
        }
        return true;
    }
    private boolean cardsSameSuit() {
        Card.Suit suit = cards[0].getCardSuit();
        for (Card card : cards) {
            if (card.getCardSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    private int[] kindCount() {
        int[] kindCount = new int[13];
        for (Card card : cards) {
            ++kindCount[card.getCardKindValue()-2];
        }
        return kindCount;
    }
    private boolean isRoyalFlush() {
        if (!cardsSameSuit()) {
            return false;
        }
        for (Card card : cards) {
            int v = card.getCardKindValue();
            if ( v < 10) {
                return false;
            }
        }
        return true;
    }


    private boolean isStraightFlush() {
        return cardsSameSuit() && isStraight();
    }

    private boolean isFourOfKind() {
        int[] kindCount = kindCount();
        for (int count : kindCount) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean isFullHouse() {
        int[] kindCount = kindCount();
        int nonZero = 0;
        for (int value : kindCount) {
            if (value > 0) {
                nonZero++;
            }
        }
        return nonZero == 2;
    }

    private boolean isThreeOfKind() {
        int[] kindCount = kindCount();
        int nonZero = 0;
        int maxVal = 0;
        for (int value : kindCount) {
            if (value > maxVal) {
                maxVal = value;
            }
            if (value > 0) {
                nonZero++;
            }
        }
        return maxVal == 3 && nonZero == 3;
    }

    private boolean isTwoPair() {
        int[] kindCount = kindCount();
        int nonZero = 0;
        int maxVal = 0;
        for (int value : kindCount) {
            if (value > maxVal) {
                maxVal = value;
            }
            if (value > 0) {
                nonZero++;
            }
        }
        return maxVal == 2 && nonZero == 3;
    }

    private boolean isPair() {
        int[] kindCount = kindCount();
        int nonZero = 0;
        int maxVal = 0;
        for (int value : kindCount) {
            if (value > maxVal) {
                maxVal = value;
            }
            if (value > 0) {
                nonZero++;
            }
        }
        return maxVal == 2 && nonZero == 4;
    }
    public Rank getHandRank() {
        if (cardCount < 5) {
            return Rank.NOTENOUGHCARDS;
        }
       if (isRoyalFlush()) {
           return Rank.ROYALFLUSH;
       }
       if (isStraightFlush()) {
           return Rank.STRAIGHTFLUSH;
       }
       if (isFourOfKind()) {
           return Rank.FOUROFKIND;
       }
       if (isFullHouse()) {
           return Rank.FULLHOUSE;
       }
       if (cardsSameSuit()) {
           return Rank.FLUSH;
       }
       if (isStraight()) {
           return Rank.STRAIGHT;
       }
       if (isThreeOfKind()) {
           return Rank.THREEOFKIND;
       }
       if (isTwoPair()) {
           return Rank.TWOPAIR;
       }
       if (isPair()) {
           return Rank.PAIR;
       }
       return Rank.NONE;
    }
}
