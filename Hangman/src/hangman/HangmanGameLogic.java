package hangman;
import java.util.Random;

public class HangmanGameLogic {
    private String[] wordList;
    private String secretWord;
    private StringBuilder visibleWord;
    private int attemptsLeft;
    private static final int MAX_ATTEMPTS = 6;

    public HangmanGameLogic(String[] wordList) {
    	Random random = new Random();
        this.wordList = wordList;
        this.secretWord = this.wordList[random.nextInt(wordList.length)];
        this.visibleWord = new StringBuilder("_".repeat(secretWord.length()));
        this.attemptsLeft = MAX_ATTEMPTS;
    }


    public String getVisibleWord() {
        return visibleWord.toString();
    }
    
    public String getFormattedVisibleWord() {
        StringBuilder formattedWord = new StringBuilder();
        for (int i = 0; i < visibleWord.length(); i++) {
            formattedWord.append(visibleWord.charAt(i));
            if (i < visibleWord.length() - 1) {
                formattedWord.append(" "); // Add a space between characters
            }
        }
        return formattedWord.toString();
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void guess(char letter) {
        boolean found = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                visibleWord.setCharAt(i, letter);
                found = true;
            }
        }
        if (!found) {
            attemptsLeft--;
        }
    }

    public boolean isWordGuessed() {
    	return visibleWord.indexOf("_") == -1;
    }
}
