import java.util.ArrayList;
import java.util.Random;

public class MontyHall {
    private int prizeDoorNumber;
    private int userGuess;

    private Random rand;

    public MontyHall() {
        rand = new Random();
        resetGame();
    }

    public void resetGame() {
        prizeDoorNumber = rand.nextInt(3);
    }

    public void setGuess(int guess) {
        userGuess = guess;
    }

    public int getDoorHint() {
        ArrayList<Integer> doors = new ArrayList<Integer>();
        doors.add(0);
        doors.add(1);
        doors.add(2);
        doors.remove(Integer.valueOf(prizeDoorNumber));
        doors.remove(Integer.valueOf(userGuess));
        if (doors.size() == 1) {
            return doors.get(0);
        }
        return doors.get(rand.nextInt(2));
    }

    public boolean isSuccess() {
        return prizeDoorNumber == userGuess;
    }

}
