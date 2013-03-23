package pokerapp.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 * GUI Button to indicate the player doesn't want to exchange any cards
 * @author Tony
 *
 */
public class HoldButton extends JButton {
	public HoldButton() {
		
		
		/*
		 * Image created from http://cooltext.com/Logo-Design?LogoID=805750601&Font=802
		 * Using font KillerBoots and St Patrick Style. Text size 15 and 6x offset shadow with 75 opacity
		 * The Pressed Icons were those put through XNView with average blur effect with largest filter
		 */
		//this.setText("Hold");
		
		setHorizontalTextPosition(SwingConstants.LEFT);
		setHorizontalAlignment(SwingConstants.LEFT);
		setAlignmentX(1.0f);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setPressedIcon(new ImageIcon("pics/HoldSelected.png"));
		setBackground(new Color(34, 142, 34));
		setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.RED, Color.ORANGE));
		setIcon(new ImageIcon("pics/Hold.png"));
	};
	

}
