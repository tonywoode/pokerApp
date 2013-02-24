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
public class FlushHandCategory extends RankBasedHandCategory {
  public FlushHandCategory(String name, int cn, Hand hand, int rank, HandRankHistogram rankHistogram) {
    super(name, cn, hand, rank, rankHistogram);
  }

  @Override
  protected int compareEqualCategories(HandCategory rhs) {
    // highest top ranking card wins; on tie, try next highest card & so on

    FlushHandCategory rhsFlush = (FlushHandCategory)rhs;

    ArrayList<Card> lhsSortedCards = hand.getSortedCards(),
                    rhsSortedCards = rhsFlush.hand.getSortedCards();

    // TODO: move this logic into a helper method; basically the same as comparing spares (in PairCategory)
    for (int iter = 0; iter < lhsSortedCards.size(); ++iter) {
      int c = compareTo(lhsSortedCards.get(iter).getRank(), rhsSortedCards.get(iter).getRank());
      if (c != 0)
        return c;
    }

    return 0;
  }
}
