package pokerapp.scorer.categories;

import pokerapp.Card;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public class RankedHandCategory extends HandCategory {

  public RankedHandCategory(String name) {
    super(name);
  }

  @Override
  public RankedHandCategory clone() {
    return new RankedHandCategory(this.getName());
  }

  @Override
  public int compareEqualCategories(HandCategory rhs) {
    // highest ranked pair wins; on tie, check 'spares'

    RankedHandCategory rhsCat = (RankedHandCategory)rhs;

    if (getRank() != rhsCat.getRank())
      return Integer.compare(getRank(), rhsCat.getRank());
    else
      return compareSpares(rhsCat);
  }

  // compare the 'spare' cards; highest rank wins; on tie, second highest, etc; tie is possible
  protected int compareSpares(RankedHandCategory rhs) {
    ArrayList<Card> lhsSpares = getSpares(),
        rhsSpares = rhs.getSpares();

    // TODO: we assume both spares have the same number of cards. Reasonable?
    for (int iter = lhsSpares.size() - 1; iter >= 0; --iter) {
      int c = Integer.compare(lhsSpares.get(iter).getRank(), rhsSpares.get(iter).getRank());
      if (c != 0)
        return c;
    }

    return 0; // tie
  }

  // TODO: this can probably be reused by Three of a Kind (and maybe others?)
  public ArrayList<Card> getSpares() {
    ArrayList<Card> spares = new ArrayList<Card>();

    for (Card card : hand)
      if (card.getRank() != getRank())
        spares.add(card);

    return spares;
  }
}
=======
package pokerapp.scorer.categories;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.HandRankHistogram;

import java.util.ArrayList;

/**
 * Sets up ranking for hand ratings, in case we get the same hand rating in more than one hand,
 * we need to know which hand has higher rating TODO//is that right?
 * @author Steve
 * @version 1.0
 */
public class RankedHandCategory extends HandCategory {

  public RankedHandCategory(String name) {
    super(name);
  }

  @Override
  public RankedHandCategory clone() {
    return new RankedHandCategory(this.getName());
  }

  @Override
  public int compareEqualCategories(HandCategory rhs) {
    // highest ranked pair wins; on tie, check 'spares'

    RankedHandCategory rhsCat = (RankedHandCategory)rhs;

    if (getRank() != rhsCat.getRank())
      return Integer.compare(getRank(), rhsCat.getRank());
    else
      return compareSpares(rhsCat);
  }

  /**
   * compare the 'spare' cards; highest rank wins; on tie, second highest, etc; tie is possible
   * @param rhs a ranked scoring card category
   * @return c an int representing which card is higher TODO//?
   */
  protected int compareSpares(RankedHandCategory rhs) {
    ArrayList<Card> lhsSpares = getSpares(),
        rhsSpares = rhs.getSpares();

    // TODO: we assume both spares have the same number of cards. Reasonable? TW: I say yes
    for (int iter = lhsSpares.size() - 1; iter >= 0; --iter) {
      int c = Integer.compare(lhsSpares.get(iter).getRank(), rhsSpares.get(iter).getRank());
      if (c != 0)
        return c;
    }

    return 0; // tie
  }

  // TODO: this can probably be reused by Three of a Kind (and maybe others?)
  public ArrayList<Card> getSpares() {
    ArrayList<Card> spares = new ArrayList<Card>();

    for (Card card : hand)
      if (card.getRank() != getRank())
        spares.add(card);

    return spares;
  }
}
>>>>>>> Tony
