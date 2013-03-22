package pokerapp;

import pokerapp.console.Player;
import pokerapp.console.Players;

/**
 * Dealer for pokerapp deals and replaces cards
 *
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

  public Card exchangeCard(Hand hand, Card card) {
    return hand.replace(card, deck.pop());
  }
}
