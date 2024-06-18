package hangman;
import javax.swing.*;

public class HangmanUtils {
	
	public static void updateLabelText(JLabel label, String text) {
		if (SwingUtilities.isEventDispatchThread()) {
            label.setText(text);
        } else {
            SwingUtilities.invokeLater(() -> label.setText(text));
        }
		
	}
	public static void updateComponent(JComponent component) {
        if (SwingUtilities.isEventDispatchThread()) {
            component.repaint();
        } else {
            SwingUtilities.invokeLater(component::repaint);
        }
    }

}
