public class HandStats {

    private int[] rankCount;
    private int totalHands;

    public HandStats() {
        rankCount = new int[11];
    }

    public void updateCount(Hand.Rank rank) {
        int index = rank.ordinal();
        rankCount[index]++;
        totalHands++;
    }

    public void printStats() {
        for ( Hand.Rank handRank : Hand.Rank.values()) {
            int handRankIndex = handRank.ordinal();
            double percentage = (1.0*rankCount[handRankIndex]) / (1.0*totalHands);
            System.out.println(handRank.toString() + " : " + rankCount[handRankIndex] + " (" + percentage + ")");
        }
    }
}