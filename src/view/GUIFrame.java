package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.hand.HandPanel;


/**
 * Frame for pokerapp drawing background
 * @author tony
 *
 */
public class GUIFrame extends JFrame {
	Container container = null;
	JPanel backPanel;

	/**
	 * draws the frame with background
	 * Poker Table Background adapted from thePokerBox.com
	 */
	public GUIFrame() {
		container = getContentPane();
		container.setLayout(null);
		
		final int FRAME_WIDTH = 912;
		final int FRAME_HEIGHT = 620;
		final String backGround = "pics/TableBack3.png";
		
		//ImageIcon backIcon = new ImageIcon("C:\\Users\\tony\\CODE\\Repo\\Poker\\PokerProject\\pics\\TableBack2.png");
		//setSize(backIcon.getIconWidth() + 5, backIcon.getIconHeight() + 25);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

		backPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				Image backImage = new ImageIcon(backGround).getImage();
				Dimension size = new Dimension(backImage.getWidth(null), backImage.getHeight(null));
				setPreferredSize(size);
				setMinimumSize(size);
				setMaximumSize(size);
				setSize(size);
				getContentPane().setLayout(null);
				g.drawImage(backImage, 0, 0, null);
			} 
		};

		container.add(backPanel);
		backPanel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		
		JPanel Cardpanel1 = new HandPanel();
		Cardpanel1.setBounds(270, 70, 390, 105);
		backPanel.setLayout(null);
		
		JPanel Cardpanel2 = new HandPanel();
		Cardpanel2.setBounds(270, 430, 390, 105);
		
		backPanel.add(Cardpanel2);
		backPanel.add(Cardpanel1);
		

	}
}   