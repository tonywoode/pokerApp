package pokerapp.scorer.categories;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.HandRankHistogram;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 02:07
 * To change this template use File | Settings | File Templates.
 */
public class FlushHandCategory extends HandCategory {
  public FlushHandCategory(String name) {
    super(name);
  }

  @Override
  public FlushHandCategory clone() {
    return new FlushHandCategory(this.getName());
  }

  @Override
  protected int compareEqualCategories(HandCategory rhs) {
    // highest top ranking card wins; on tie, try next highest card & so on

    FlushHandCategory rhsFlush = (FlushHandCategory)rhs;

    ArrayList<Card> lhsSortedCards = hand.getSortedCards(),
                    rhsSortedCards = rhsFlush.hand.getSortedCards();

    // TODO: move this logic into a helper method; basically the same as comparing spares (in PairCategory)
    for (int iter = 0; iter < lhsSortedCards.size(); ++iter) {
      int c = Integer.compare(lhsSortedCards.get(iter).getRank(), rhsSortedCards.get(iter).getRank());
      if (c != 0)
        return c;
    }

    return 0;
  }
}
