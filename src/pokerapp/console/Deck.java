package pokerapp.console;

import pokerapp.Card;
import pokerapp.Suit;
import pokerapp.utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * @author Tony
 * @author Sam
 * @author Ari
 * @author Steve
 * Date: 22/02/13
 * Time: 19:53
 *
 * TODO: here because it was scratch impl for console app
 */
public class Deck implements Iterable<Card> {

	private ArrayList<Card> cards = new ArrayList<Card>();

  private Deck(ArrayList<Card> cards) {
    this.cards = (ArrayList<Card>)cards.clone();
    shuffle();
  }

  private static ArrayList<Card> allCards;

  public static Deck createDeck() {
    if (allCards == null) {
      allCards = new ArrayList<Card>();
      for (Suit suit : Suit.AllSuits) {
        for (int rank = 0; rank < Constants.NUM_RANKS; ++rank)
          allCards.add(new Card(suit, rank));
      }
    }
    return new Deck(allCards);
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  public Card pop() {
    Card card = cards.get(cards.size() - 1);
    cards.remove(card);
    return card;
  }

  public void returnToBottom(Card card) {
    cards.add(0, card);
  }
  
  public Iterator<Card> iterator() {
	  return cards.iterator();
	}
  
  
}
