package pokerapp.scorer.domain;

import pokerapp.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 00:30
 * To change this template use File | Settings | File Templates.
 */
public class SameRankSequence implements Comparable<SameRankSequence> {
  private final List<Card> cards;


  public SameRankSequence(Card... cards) {
    this.cards = new ArrayList<Card>();
    for (Card card : cards)
      this.cards.add(card);
  }

  public Card get(int index) { return cards.get(index); }

  public int getRank() {
    return cards.get(0).getRank();
  }

  public int compareTo(SameRankSequence rhs) {
    return Integer.compare(getRank(), rhs.getRank());
  }

}
