package pokerapp.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextPane;

/**
 * Sets the textpanel in the PokerApp gui, and has a shadow effect on the text
 * @author tony
 *
 */
public class TextPanel extends JTextPane {
	private static String text = "Here the text will go no matter how long it is - I hope the computer Wins!";
	private Font font = new Font("Showcard Gothic", Font.ITALIC, 28);
	private JTextPane textPanelFront;
	
	public TextPanel() {
		//set the background text
		this.setFont(font);
		this.setForeground(new Color(8, 10, 12));
		this.setOpaque(false);
		this.setEditable(false);
		this.setText(text);
		//textPanel.setBounds(275, 224, 415, 129);
	
		//set the foregroundtext
		textPanelFront = new JTextPane();
		textPanelFront.setDoubleBuffered(true);
		textPanelFront.setFont(font);
		textPanelFront.setForeground(new Color(250, 35, 50));
		textPanelFront.setOpaque(false);
		textPanelFront.setEditable(false);
		textPanelFront.setText(text);
		textPanelFront.setBounds(-5, -1, 415, 129);
		this.add(textPanelFront);
		
	}
	
	/**
	 * Sets the message text - can't use Lombok here or it kills the shadow, nor can we use setText() as it overrides a swing component
	 * @param text text to write to screen
	 */
	public void setMessage(String text) {
		setText(text);
		textPanelFront.setText(text);
	}
}
