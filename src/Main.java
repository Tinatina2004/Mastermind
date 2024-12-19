import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Welcome to Bulls and Cows!");
        System.out.println("Guess the secret code of 4 colors from: red, blue, green, purple, black, yellow.");
        System.out.println("You have " + game.getAttemptsLeft() + " attempts.\n");

        while (!game.isGameOver()) {
            System.out.print("Enter your guess (e.g., red blue green purple): ");
            String input = scanner.nextLine();
            String[] userGuess = input.trim().split("\\s+");

            if (userGuess.length != 4) {
                System.out.println("Invalid input! Enter exactly 4 colors.");
                continue;
            }


            String feedback = Feedback.getFeedback(game.getSecretCode(), userGuess);
            System.out.println(feedback);


            if (game.isWin(userGuess)) {
                System.out.println("Congratulations! You guessed the secret code!");
                break;
            }


            game.reduceAttempt();
            System.out.println("Attempts left: " + game.getAttemptsLeft());
        }

        if (game.isGameOver() && !game.isWin(game.getSecretCode())) {
            System.out.println("Game Over! The secret code was: " + String.join(", ", game.getSecretCode()));
        }

        scanner.close();

    }
}