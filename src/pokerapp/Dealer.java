package pokerapp;

import lombok.AllArgsConstructor;
import pokerapp.view.events.EventSource;

/**
 * Dealer for pokerapp deals and replaces cards
 *
 * @author steve, tony
 */
@AllArgsConstructor
public class Dealer {
  private Deck deck;

  public Deck getDeck() {
    return deck;
  }

  public void dealCards(int numCards, Players players) {
    deck = Deck.createDeck();
    deck.shuffle();

    for (Player player : players)
      player.dropHand();
    for (int iter = 0; iter < numCards; ++iter)
      for (Player player : players)
        player.receiveCard(deck.pop());
  }

  public Card exchangeCard(Hand hand, Card card) {
    return hand.replace(card, deck.pop());
  }
}
