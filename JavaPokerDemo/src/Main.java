// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {
    public static void main(String[] args) {
//        Hand hand = new Hand();
//        Card C1 = new Card(Card.Suit.HEART, Card.Kind.THREE);
//        Card C2 = new Card(Card.Suit.DIAMOND, Card.Kind.THREE);
//        Card C3 = new Card(Card.Suit.SPADE, Card.Kind.EIGHT);
//        Card C4 = new Card(Card.Suit.HEART, Card.Kind.NINE );
//        Card C5 = new Card(Card.Suit.CLUB, Card.Kind.SIX);
//        hand.addCard(C1);
//        hand.addCard(C2);
//        hand.addCard(C3);
//        hand.addCard(C4);
//        hand.addCard(C5);
//        System.out.println(hand.getHandRank().toString());
        Hand hand = new Hand();
        Deck deck = new Deck();
        HandStats stats = new HandStats();
        int numHands = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Card C = deck.getCard();
                hand.addCard(C);
            }
            stats.updateCount(hand.getHandRank());
            hand.reset();
            deck.reset();
            numHands++;
        }
        System.out.println("-----------STATS (" + numHands + " Hands)-------------------");
        stats.printStats();
        System.out.println("------------------------------------------------------------------------\n\n\n");
    }
}