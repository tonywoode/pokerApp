package pokerapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * builds a deck of cards for pokerapp and allows operations on the deck.
 *
 * @author Tony
 * @author Sam
 * @author Ari
 * @author Steve
 *         Date: 22/02/13
 *         Time: 19:53
 *         <p/>
 *
 */
public class Deck implements Iterable<Card> {

  private ArrayList<Card> cards = new ArrayList<Card>();

  private Deck(ArrayList<Card> cards) {
    this.cards = (ArrayList<Card>) cards.clone();
    shuffle();
  }

  private static ArrayList<Card> allCards;   //singleton

  /**
   * creates a pokerapp deck
   *
   * @return the deck
   */
  public static Deck createDeck() {
    if (allCards == null) {
      allCards = new ArrayList<Card>();
      for (Suit suit : Suit.AllSuits) {
        for (Rank rank : Rank.values())
          allCards.add(new Card(suit, rank));
      }
    }
    return new Deck(allCards);
  }

  /**
   * Shuffles a deck of cards
   * (we used collections.shuffle() because it's Fisher-Yates, and really we aren't going to get much better randomness
   * with what we have available)
   */
  public void shuffle() {
    Collections.shuffle(cards);
  }

  /**
   * pops a card off the deck
   *
   * @return the removed card
   */
  public Card pop() {
    Card card = cards.get(cards.size() - 1);
    cards.remove(card);
    return card;
  }

  /**
   * returns a card to the bottom of the deck
   *
   * @param card the card you want to return to the bottom of deck
   */
  public void returnToBottom(Card card) {
    cards.add(0, card);
  }

  /**
   * @return an iterator through the deck
   */
  public Iterator<Card> iterator() {
    return cards.iterator();
  }
}
