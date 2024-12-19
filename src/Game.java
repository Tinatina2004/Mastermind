
import java.util.Random;

public class Game {

    private static final int SECRET_CODE_LENGTH = 4;
    private static final String[] COLORS = {"red", "blue", "green", "purple", "black", "yellow"};
    private String[] secretCode;
    private static final int MAX_ATTEMPTS = 10;
    private int attemptsLeft;


    public Game() {
        generateSecretCode();
        attemptsLeft = MAX_ATTEMPTS;
    }


    private void generateSecretCode() {
        Random random = new Random();
        secretCode = new String[SECRET_CODE_LENGTH];
        for (int i = 0; i < SECRET_CODE_LENGTH; i++) {
            secretCode[i] = COLORS[random.nextInt(COLORS.length)];
        }
    }


    public String[] getSecretCode() {
        return secretCode;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public void reduceAttempt() {
        attemptsLeft--;
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0;
    }

    public boolean isWin(String[] userGuess) {
        for (int i = 0; i < SECRET_CODE_LENGTH; i++) {
            if (!userGuess[i].equalsIgnoreCase(secretCode[i])) {
                return false;
            }
        }
        return true;
    }

    public void resetGame() {
        generateSecretCode();
        attemptsLeft = MAX_ATTEMPTS;
    }
}
