package view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

/**
 * Start the game in GUI. Should bring up the popup "let's play poker"
 * @author tony
 *
 */
public class StartButton extends JButton {
		public StartButton() {
			setToolTipText("Start Or Restart Game");
			setOpaque(false);
			setIcon(new ImageIcon("pics/StartGame.png"));
			setPressedIcon(new ImageIcon("pics/StartGameSelected.png"));
			setBackground(new Color(34, 142, 34));
			setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.RED, Color.ORANGE));
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			
		}
}
