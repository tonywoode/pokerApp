package view;

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
