package hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class HangmanGame extends JFrame {
	final int WIDTH = 600;
	final int HEIGHT = 400;
	
    private HangmanGameLogic gameLogic;
    private JLabel wordLabel;
    private JLabel feedbackLabel;
    private JTextField guessField;
    private BackgroundPane backgroundPane;
    private HangmanPanel hangmanPanel;

    public HangmanGame() {
        setTitle("Hangman Game");
        setSize(WIDTH, HEIGHT);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        StartPanel startScreen = new StartPanel(e -> startNewGame());
        add(startScreen, BorderLayout.CENTER);
    }

    private void startNewGame() {
    	getContentPane().removeAll();
        String[] wordList = {"hangman", "computer", "java", "programming", "interface"};
        gameLogic = new HangmanGameLogic(wordList); 
        hangmanPanel = new HangmanPanel();
        hangmanPanel.setPreferredSize(new Dimension(300, 300));
        
        wordLabel = new JLabel(gameLogic.getFormattedVisibleWord(), SwingConstants.CENTER);
        wordLabel.setFont(new Font("Serif", Font.BOLD, 48));
        wordLabel.setForeground(Color.WHITE);
        
        feedbackLabel = new JLabel("Attempts left: " + gameLogic.getAttemptsLeft(), SwingConstants.CENTER);
        feedbackLabel.setForeground(Color.WHITE);
        
        guessField = new JTextField(2);
        
        JButton guessButton = new JButton("Guess");

        guessButton.addActionListener(new GuessButtonListener());
        
        JPanel inputPanel = new BackgroundPane();
        inputPanel.add(guessField);
        inputPanel.add(guessButton);
        
        backgroundPane = new BackgroundPane();

        backgroundPane.setLayout(new BorderLayout());
        backgroundPane.add(wordLabel, BorderLayout.NORTH);
        backgroundPane.add(feedbackLabel, BorderLayout.SOUTH);
        backgroundPane.add(inputPanel, BorderLayout.CENTER);
        backgroundPane.add(hangmanPanel, BorderLayout.WEST);
        
        add(backgroundPane, BorderLayout.CENTER);

        revalidate();
        repaint();
        updateDisplay();
    }

    private void updateDisplay() {
    	hangmanPanel.setAttemptsLeft(gameLogic.getAttemptsLeft());
        wordLabel.setText("Word: " + gameLogic.getFormattedVisibleWord());
        feedbackLabel.setText("Attempts left: " + gameLogic.getAttemptsLeft());
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String guess = guessField.getText();
            if (guess.length() == 1) {
                char letter = guess.charAt(0);
                gameLogic.guess(letter);
                updateDisplay();
                if (gameLogic.isWordGuessed()) {
                    winDisplay();
                    System.out.println("Word guessed!");
                    startNewGame();
                } else if (gameLogic.getAttemptsLeft() == 0) {
                	String currentWord = gameLogic.getSecretWord();
                	SwingUtilities.invokeLater(() -> feedbackLabel.setText("Sorry, you've run out of attempts. The word was: " + currentWord));
                	startNewGame();
                }
            } else {
                feedbackLabel.setText("Please enter a single letter!");
            }
            guessField.setText("");
        }
    }
    private void winDisplay() {
    	SwingUtilities.invokeLater(() -> feedbackLabel.setText("Congratulations! You've guessed the word!"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HangmanGame().setVisible(true));
    }
}
