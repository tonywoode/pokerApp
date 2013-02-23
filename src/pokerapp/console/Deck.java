package pokerapp.console;

import pokerapp.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
public class Deck {
  List<Card> cards = new ArrayList<Card>();

  public Deck() {
    // create all 52 cards...
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
}
