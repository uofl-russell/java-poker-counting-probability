public class Card {

    public enum Suit {
        CLUB,
        SPADE,
        DIAMOND,
        HEART
    }
    public enum Kind {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        ACE,
        JACK,
        QUEEN,
        KING
    }
    private Suit cardSuit;
    private Kind cardKind;
    public Card(Suit suit, Kind kind) {
        this.cardSuit = suit;
        this.cardKind = kind;
    }

    public Card(int suit, int kind) {
        this.cardSuit = Suit.values()[suit];
        this.cardKind = Kind.values()[kind];
    }

    public Card(int cardID) {
        this.cardSuit = Suit.values()[cardID/13];
        this.cardKind = Kind.values()[cardID%13];
    }

    public Suit getCardSuit() {
        return cardSuit;
    }

    public int getCardKindValue() {
        switch (cardKind) {
            case Kind.TWO:
                return 2;
            case Kind.THREE:
                return 3;
            case Kind.FOUR:
                return 4;
            case Kind.FIVE:
                return 5;
            case Kind.SIX:
                return 6;
            case Kind.SEVEN:
                return 7;
            case Kind.EIGHT:
                return 8;
            case Kind.NINE:
                return 9;
            case Kind.TEN:
                return 10;
            case Kind.JACK:
                return 11;
            case Kind.QUEEN:
                return 12;
            case Kind.KING:
                return 13;
            case Kind.ACE:
                return 14;
            default:
                return 0;
        }
    }

    public String getCardString() {
        String cardInfo = cardSuit.toString() + "-";
        switch (cardKind) {
            case Kind.TWO:
                return cardInfo + "2";
            case Kind.THREE:
                return cardInfo + "3";
            case Kind.FOUR:
                return cardInfo + "4";
            case Kind.FIVE:
                return cardInfo + "5";
            case Kind.SIX:
                return cardInfo + "6";
            case Kind.SEVEN:
                return cardInfo + "7";
            case Kind.EIGHT:
                return cardInfo + "8";
            case Kind.NINE:
                return cardInfo + "9";
            case Kind.TEN:
                return cardInfo + "10";
            case Kind.JACK:
                return cardInfo + "J";
            case Kind.QUEEN:
                return cardInfo + "Q";
            case Kind.KING:
                return cardInfo + "K";
            case Kind.ACE:
                return cardInfo + "A";
            default:
                return "";
        }
    }
}
