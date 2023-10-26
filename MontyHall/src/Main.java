import java.util.ArrayList;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int noChangeTrials = 0;
        int changedTrials = 0;
        int numNoChangeSuc = 0;
        int numChangeSuc = 0;
        Random rand = new Random();
        MontyHall MH = new MontyHall();
        for (int trial=0; trial< 100000; trial++) {
            int guess = rand.nextInt(3);
            System.out.println(guess);
            MH.setGuess(guess);
            int hint = MH.getDoorHint();
            if (rand.nextBoolean()) {
                for (int i = 0; i < 3; i++) {
                    if (i != guess && i != hint) {
                        MH.setGuess(i);
                    }
                }
                changedTrials++;
                if (MH.isSuccess()) {
                    numChangeSuc++;
                }
            } else {
                noChangeTrials++;
                if (MH.isSuccess()) {
                    numNoChangeSuc++;
                }
            }
            MH.resetGame();
        }
        double noChangePercent = (1.0*numNoChangeSuc)/(1.0*noChangeTrials);
        double changePercent = (1.0*numChangeSuc)/(1.0*changedTrials);
        System.out.println("-----------Success Statistics-------------");

        System.out.println("No Change :  " + numNoChangeSuc + " of " + noChangeTrials + " ( " + noChangePercent + ")");
        System.out.println("With Change :  " + numChangeSuc + " of " + changedTrials + " ( " + changePercent + ")");

    }
}