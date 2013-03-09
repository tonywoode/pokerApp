package pokerapp;

import pokerapp.console.Player; //TODO: importing both player and players?
import pokerapp.console.Players;

/**
 * Dealer for pokerapp deals and replaces cards
 * @author steve, tony
 */
public class Dealer {
  private Deck deck;
	
  public Dealer(Deck deck) {
    this.deck = deck;
  }
	
	
  public void dealCards(int numCards, Players players) {
    for (int iter = 0; iter < numCards; ++iter) {
      for (Player player : players) {
        player.receiveCard(deck.pop());
      }
    }
  }

  public void shuffleCards(Deck deck) {
    deck.shuffle();
  }
}
