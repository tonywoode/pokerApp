package view.PlayerHand;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import view.ExchangeButton;
import view.HoldButton;
import view.hand.CardViewModel;
import view.hand.HandPanel;

/**
 * 
 * To collect together the displayable elements of the player in the game, so that the MVP pattern can communicate most easily
 * @author Tony
 *
 */
public class PlayerHandView implements Displayable {

	// primary view for this part of the UI i.e., fits into a larger UI
	private JPanel mainView;
	private JPanel buttonsPanel = new JPanel();
	private HandPanel handPanel;
	private ExchangeButton exchangeButton;
	private HoldButton holdButton;
	
	private List<PlayerHandViewActionListener> listeners = new ArrayList<>();
	
	public PlayerHandView(HandPanel handPanel) {
		this.handPanel = handPanel;
		initComponents();
		layoutComponents();
	}
	
	/**
	 * since PlayerHandView represents player in the GUI, the listeners will lie here for the view
	 * they will pass to the PlayerHandActionListener who will then pass onto the presenter
	 * @param listener
	 */
	public void addListener(PlayerHandViewActionListener listener) {
		listeners.add(listener);
	}
	
	public void setCards(Iterable<CardViewModel> cards) {
		handPanel.setCards(cards);
	}
	
	private void initComponents() {
		this.mainView = new JPanel();
		mainView.setLayout(new BorderLayout());
		
		this.buttonsPanel.setLayout(new BoxLayout(this.buttonsPanel, BoxLayout.Y_AXIS));
		
		this.exchangeButton = new ExchangeButton();
		this.exchangeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (PlayerHandViewActionListener listener : listeners) //here we pass event to the PHAL
					listener.onExchange();
			}
		});
		
		this.holdButton = new HoldButton();
		this.holdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (PlayerHandViewActionListener listener : listeners) //here we pass event to the PHAL
					listener.onHold();
			}
		});
	}
	
	/**
	 * Puts the UI widgets in the right place
	 */
	private void layoutComponents() {
		buttonsPanel.add(exchangeButton);
		buttonsPanel.add(holdButton);
		
		mainView.add(buttonsPanel, BorderLayout.WEST);
		mainView.add(handPanel);
	}
	
	@Override
	public JComponent getView() {
		return mainView;
	}
}
