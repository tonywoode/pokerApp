package pokerapp.scorer.categories;

import pokerapp.Card;
import pokerapp.Hand;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public class RankedHandCategory extends HandCategory {

  public RankedHandCategory(String name, int cn, Hand hand) {
    super(name, cn, hand);
  }

  @Override
  public int compareEqualCategories(HandCategory rhs) {
    // highest ranked pair wins; on tie, check 'spares'

    RankedHandCategory rhsCat = (RankedHandCategory)rhs;

    // TODO: violates the Law of Demeter; should probably correct this
    if (hand.getRankHistogram().getRank() != rhsCat.hand.getRankHistogram().getRank())
      return compareTo(hand.getRankHistogram().getRank(), rhsCat.hand.getRankHistogram().getRank());
    else
      return compareSpares(rhsCat);
  }

  // compare the 'spare' cards; highest rank wins; on tie, second highest, etc; tie is possible
  protected int compareSpares(RankedHandCategory rhs) {
    ArrayList<Card> lhsSpares = getSpares(),
        rhsSpares = rhs.getSpares();

    // TODO: we assume both spares have the same number of cards. Reasonable?
    for (int iter = lhsSpares.size() - 1; iter >= 0; --iter) {
      int c = compareTo(lhsSpares.get(iter).getRank(), rhsSpares.get(iter).getRank());
      if (c != 0)
        return c;
    }

    return 0; // tie
  }

  // TODO: this can probably be reused by Three of a Kind (and maybe others?)
  public ArrayList<Card> getSpares() {
    ArrayList<Card> spares = new ArrayList<Card>();

    for (Card card : hand)
      if (card.getRank() != hand.getRankHistogram().getRank())
        spares.add(card);

    return spares;
  }

}
