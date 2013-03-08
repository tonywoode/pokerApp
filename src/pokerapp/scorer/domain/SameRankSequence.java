package pokerapp.scorer.domain;

import pokerapp.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 00:30
 *
 * @author Steve Faulmann
 *
 * Represents the concept of a pair, three & four of a kind. Stores
 * the rank of the (pair, triple, four).
 * <p>
 * Implements Comparable<T> to allow for chaining with the Comparator.
 */
public class SameRankSequence implements Comparable<SameRankSequence> {
  private static final int MIN_NUM_CARDS_IN_SEQUENCE = 2;

  private final List<Card> cards;

  public SameRankSequence(Card... cards) {
    if (cards.length < MIN_NUM_CARDS_IN_SEQUENCE)
      throw new IllegalArgumentException("Must have at least 2 cards");
    this.cards = new ArrayList<Card>();
    for (Card card : cards)
      this.cards.add(card);
  }

  public SameRankSequence(Iterable<Card> cards) {
    this.cards = new ArrayList<Card>();
    for (Card card : cards)
      this.cards.add(card);
    if (this.cards.size() < MIN_NUM_CARDS_IN_SEQUENCE)
      throw new IllegalArgumentException("Must have at least 2 cards");
  }

  // @return retrieves the Card at the specified index. Not currently used.
  public Card get(int index) { return cards.get(index); }

  public int getRank() {
    return cards.get(0).getRank();
  }

  public int compareTo(SameRankSequence rhs) {
    return Integer.compare(getRank(), rhs.getRank());
  }
}
