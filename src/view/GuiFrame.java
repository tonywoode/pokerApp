package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


/**
 * Frame for pokerapp drawing background
 * @author tony
 *
 */
public class GuiFrame extends JFrame {
	Container container = null;
	JPanel backPanel;

	/**
	 * draws the frame with background
	 */
	public GuiFrame() {
		container = getContentPane();
		container.setLayout(null);
		
		//ImageIcon backIcon = new ImageIcon("C:\\Users\\tony\\CODE\\Repo\\Poker\\PokerProject\\pics\\TableBack2.png");
		//setSize(backIcon.getIconWidth() + 5, backIcon.getIconHeight() + 25);
		setSize(912, 620);

		backPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				Image backImage = new ImageIcon("pics\\TableBack3.png").getImage();
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
		backPanel.setBounds(0, 0, 912, 620);
		GroupLayout backLayout = new GroupLayout(backPanel);
		backLayout.setHorizontalGroup(backLayout.createParallelGroup(Alignment.LEADING).addGap(0, 760, Short.MAX_VALUE) );
		backLayout.setVerticalGroup(backLayout.createParallelGroup(Alignment.LEADING).addGap(0, 580, Short.MAX_VALUE) );
		backPanel.setLayout(backLayout);

	}
}   