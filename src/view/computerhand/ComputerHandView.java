package view.computerhand;


import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import view.Displayable;
import view.hand.CardViewModel;
import view.hand.HandPanel;

/**
 * 
 * To collect together the displayable elements of the player in the game, so that the MVP pattern can communicate most easily
 * @author Tony
 *
 */
public class ComputerHandView implements Displayable {

	// primary view for this part of the UI i.e., fits into a larger UI
	private JPanel mainView;
	private HandPanel handPanel;



	public ComputerHandView(HandPanel handPanel) {
		this.handPanel = handPanel;
		initComponents();
		layoutComponents();
	}


	public void setCards(Iterable<CardViewModel> cards) {
		handPanel.setCards(cards);
	}

	private void initComponents() {
		this.mainView = new JPanel();
		mainView.setLayout(new BorderLayout());
	}

	private void layoutComponents() {	
		mainView.add(handPanel);
	}

	@Override
	public JComponent getView() {
		return mainView;
	}
}
