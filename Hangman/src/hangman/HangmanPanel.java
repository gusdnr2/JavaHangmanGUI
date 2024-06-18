package hangman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class HangmanPanel extends BackgroundPane {
	private int attemptsLeft;
	private Image backgroundImage;

    public HangmanPanel() {
    	super();
        this.attemptsLeft = 6;
    }

    public void setAttemptsLeft(int attemptsLeft) {
        this.attemptsLeft = attemptsLeft;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Draw the gallows
        g2.drawLine(50, 200, 150, 200); // base
        g2.drawLine(80, 200, 100, 190);
        g2.drawLine(100,190, 120, 200);
        g2.drawLine(100, 200, 100, 50); // pole
        g2.drawLine(100,75,115,50);
        g2.drawLine(100, 50, 200, 50);  // beam
        g2.drawLine(200, 50, 200, 70);  // rope

        // Draw the stickman
        if (attemptsLeft < 6) g2.drawOval(180, 70, 40, 40); // head
        if (attemptsLeft < 5) g2.drawLine(200, 110, 200, 150); // body
        if (attemptsLeft < 4) g2.drawLine(200, 120, 180, 140); // left arm
        if (attemptsLeft < 3) g2.drawLine(200, 120, 220, 140); // right arm
        if (attemptsLeft < 2) g2.drawLine(200, 150, 180, 180); // left leg
        if (attemptsLeft < 1) g2.drawLine(200, 150, 220, 180); // right leg
    }


}
