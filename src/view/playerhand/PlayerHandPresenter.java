package view.playerhand;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import pokerapp.Card;
import pokerapp.Dealer;
import pokerapp.Hand;
import pokerapp.console.Player;

import view.Displayable;
import view.hand.CardViewModel;

/**
 * 
 * 
 * PlayerHand presenter MVP pattern: presenter will communicate actions from and to view
 * @author Tony
 *
 */
public class PlayerHandPresenter implements PlayerHandViewActionListener, Displayable {

	public PlayerHandPresenter(PlayerHandView plHandView, Dealer dealer) {
		this.plHandView = plHandView;
		this.plHandView.addListener(this);
		this.dealer = dealer;
	}
	
	private List<CardViewModel> cards = new ArrayList<>();
	private PlayerHandView plHandView; 
	private Player player;
	private Hand hand;
	
	private Dealer dealer;

	public void init(Player player, Hand hand) {
		this.player = player;
		this.hand = hand;
		createCardViewModels();
	}
	
	/**
	 * Turn the cards in the player's hand to 
	 * CardViewModels so they can be displayed on screen
	 */
	private void createCardViewModels() {
		for (Card card : hand) {
			CardViewModel vm = CardViewModel.create(card);
			cards.add(vm);
		}	
	}

	public void onHold() {
		JOptionPane.showMessageDialog(getView(), "Hold command activated");
	}

	public void onExchange() {
		JOptionPane.showMessageDialog(getView(), "Exchange command activated");		
	}

	@Override
	public JComponent getView() {
		return plHandView.getView();
	}

}

