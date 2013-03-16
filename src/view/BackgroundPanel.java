package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	Image image;

	public BackgroundPanel() {
		super();
		initialize();
	}
	private void initialize() {
		try {
			image = new ImageIcon(getClass().getResource("pics\\TableBack2.png")).getImage();
		} catch (Exception e) {
			/*handled in paintComponent()*/
		}
		this.setSize(800, 470);
		this.setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		if(image != null) {
			g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
		}
	}
}

