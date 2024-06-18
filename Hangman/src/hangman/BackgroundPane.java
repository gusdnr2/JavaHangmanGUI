package hangman;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundPane extends JPanel {
	private Image backgroundImage;
	
	public BackgroundPane() {
	 try {
         backgroundImage = ImageIO.read(new File("./resources/im_bg.jpg"));
     } catch (IOException e) {
         e.printStackTrace();
     }
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this);
        }
	}

}
