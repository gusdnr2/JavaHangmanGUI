package hangman;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
	private JButton startButton;
	private BackgroundPane backgroundPane;

    public StartPanel(ActionListener startListener) {
    	setLayout(new BorderLayout());
    	backgroundPane = new BackgroundPane();
    	backgroundPane.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to Hangman!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        backgroundPane.add(titleLabel, BorderLayout.CENTER);

        startButton = new JButton("Start Game");
        startButton.setFont(new Font("Serif", Font.BOLD, 24));
        startButton.addActionListener(startListener);
        backgroundPane.add(startButton, BorderLayout.SOUTH);
        
        add(backgroundPane, BorderLayout.CENTER);
    }

}
