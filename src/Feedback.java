public class Feedback {
    public static String getFeedback(String[] secretCode, String[] userGuess) {
        int bulls = 0;
        int cows = 0;

        boolean[] codeUsed = new boolean[secretCode.length];
        boolean[] guessUsed = new boolean[userGuess.length];


        for (int i = 0; i < secretCode.length; i++) {
            if (userGuess[i].equalsIgnoreCase(secretCode[i])) {
                bulls++;
                codeUsed[i] = true;
                guessUsed[i] = true;
            }
        }


        for (int i = 0; i < secretCode.length; i++) {
            if (!guessUsed[i]) {
                for (int j = 0; j < secretCode.length; j++) {
                    if (!codeUsed[j] && userGuess[i].equalsIgnoreCase(secretCode[j])) {
                        cows++;
                        codeUsed[j] = true;
                        break;
                    }
                }
            }
        }

        return "Bulls: " + bulls + ", Cows: " + cows;
    }
}
