package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextPane;

public class TextPanel extends JTextPane {
	
	
	
	public TextPanel() {
	//JTextPane textPanel = new JTextPane();
	this.setFont(new Font("Showcard Gothic", Font.ITALIC, 28));
	this.setForeground(new Color(160, 20, 20));
	this.setOpaque(false);
	this.setEditable(false);
	this.setText("Here the text will go no matter how long it is - I hope the computer Wins!");
	//textPanel.setBounds(275, 224, 415, 129);

	
	/*JTextPane textPanelShadow = new JTextPane();
	textPanelShadow.setFont(new Font("Showcard Gothic", Font.ITALIC, 28));
	textPanelShadow.setForeground(new Color(0, 0, 0));
	textPanelShadow.setOpaque(false);
	textPanelShadow.setEditable(false);
	textPanelShadow.setText("Here the text will go no matter how long it is - I hope the computer Wins!");
	textPanelShadow.setBounds(277, 227, 415, 129);
	this.add(textPanelShadow);*/
	}
	
}
