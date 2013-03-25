package pokerapp.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

/**
 * GUI button for player to press after selecting which cards to exchange
 * @author Tony
 *
 */
public class ExchangeButton extends JButton {

	public ExchangeButton() {

		/*
		 * Image created from http://cooltext.com/Logo-Design?LogoID=805750601&Font=802
		 * Using font KillerBoots and St Patrick Style. Text size 15 and 6x offset shadow with 75 opacity
		 * The Pressed Icons were those put through XNView with average blur effect with largest filter
		 */
	
		setup();
	}
	
	private void setup() {
		setAlignmentX(1.0f);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setPressedIcon(new ImageIcon("pics/ExchangeSelected.png"));
		setOpaque(false);
		setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.RED, Color.ORANGE));
		setBackground(new Color(34, 142, 34));
		setIcon(new ImageIcon("pics/Exchange.png"));
	}


}