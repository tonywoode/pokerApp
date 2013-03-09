package pokerapp.scorer.domain;

import pokerapp.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the concept of a pair, three & four of a kind. Stores
 * the rank of the (pair, triple, four).
 * <p>
 * Implements Comparable<T> to allow for chaining with the Comparator.
 * @author Steve Faulmann
 */
public class SameRankCards implements Comparable<SameRankCards> {
  private static final int MIN_NUM_CARDS_IN_SEQUENCE = 2;

  private final List<Card> cards;

  public SameRankCards(Card... cards) {
    if (cards.length < MIN_NUM_CARDS_IN_SEQUENCE)
      throw new IllegalArgumentException("Must have at least 2 cards");
    this.cards = new ArrayList<Card>();
    for (Card card : cards)
      this.cards.add(card);
  }

  /**
   * 
   * @param cards
   */
  public SameRankCards(Iterable<Card> cards) {
    this.cards = new ArrayList<Card>();
    for (Card card : cards)
      this.cards.add(card);
    if (this.cards.size() < MIN_NUM_CARDS_IN_SEQUENCE)
      throw new IllegalArgumentException("Must have at least 2 cards");
  }

  /**
   * 
   * @param index
   * @return retrieves the Card at the specified index. Not currently used.
   */
  public Card get(int index) { return cards.get(index); }

  public int getRank() {
    return cards.get(0).getRank();
  }

  public int compareTo(SameRankCards rhs) {
    return Integer.compare(getRank(), rhs.getRank());
  }
}
