package view.computerhand;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import pokerapp.Card;
import pokerapp.Dealer;
import pokerapp.Hand;
import pokerapp.console.ComputerPlayer;
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
public class ComputerHandPresenter implements Displayable {

	public ComputerHandPresenter(ComputerHandView cpuHandView, Dealer dealer) {
		this.cpuHandView = cpuHandView;
		this.dealer = dealer;
	}
	
	private List<CardViewModel> cards = new ArrayList<>();
	private ComputerHandView cpuHandView; 
	private ComputerPlayer cpuplayer;
	private Hand hand;
	
	private Dealer dealer;

	public void init(ComputerPlayer cpuplayer, Hand hand) {
		this.cpuplayer = cpuplayer;
		this.hand = hand;
		createCardViewModels();
	}
	
	/**
	 * Turn the cards in the computer player's hand to 
	 * CardViewModels so they can be displayed on screen
	 */
	private void createCardViewModels() {
		for (Card card : hand) {
			CardViewModel vm = CardViewModel.create(card);
			cards.add(vm);
		}	
	}

	@Override
	public JComponent getView() {
		return cpuHandView.getView();
	}

}

