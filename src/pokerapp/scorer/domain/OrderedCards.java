package pokerapp.scorer.domain;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.HighToLowCardComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 00:34
 *
 * @author Steve Faulmann
 *
 * Implements a sorted collection of cards. Cards are sorted
 * by rank, from highest to lowest.
 * <p>
 * Objects of this type are comparable to each other.
*/
public class OrderedCards implements Comparable<OrderedCards> {

  private final List<Card> cards;

  // Create a new instance, initialised with an array of cards
  public OrderedCards(Card... cards) {
    this.cards = new ArrayList<Card>();
    for (Card card : cards)
      this.cards.add(card);
    Collections.sort(this.cards, HighToLowCardComparator.Default);
  }

  // Create a new instance, initialised with a hand
  // TODO: this is highly repetitive & needs to be refactored
  public OrderedCards(Hand hand) {
    this.cards = new ArrayList<Card>();
    for (Card card : hand)
      this.cards.add(card);
    Collections.sort(this.cards, HighToLowCardComparator.Default);
  }

  // Create a new instance, initialised with a hand
  // TODO: this is highly repetitive & needs to be refactored
  public OrderedCards(ArrayList<Card> cards) {
    this.cards = new ArrayList<Card>();
    for (Card card : cards)
      this.cards.add(card);
    Collections.sort(this.cards, HighToLowCardComparator.Default);
  }

  // Compares two OrderedCards instances, from highest rank to lowest
  public int compareTo(OrderedCards rhs) {
    int c = 0;
    for (int iter = 0, max = Math.min(cards.size(), rhs.cards.size()); iter < max; ++iter)
      if ((c = Integer.compare(cards.get(iter).getRank(), rhs.cards.get(iter).getRank())) != 0)
        return c;
    return c;
  }
}
