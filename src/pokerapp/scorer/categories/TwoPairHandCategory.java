package pokerapp.scorer.categories;

import pokerapp.Hand;
import pokerapp.utils.ReverseArrayIterator;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 01:54
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairHandCategory extends HandCategory {
  public TwoPairHandCategory(String name, int cn, Hand hand) {
    super(name, cn, hand);
  }

  @Override
  public int compareEqualCategories(HandCategory rhs) throws Exception {
    // harder implementation; two separate ranks

    TwoPairHandCategory rhsTwoPair = (TwoPairHandCategory)rhs;

    ReverseArrayIterator lhsIter = hand.getRankHistogram().iterator(),
                         rhsIter = rhsTwoPair.hand.getRankHistogram().iterator();

    int c = Integer.compare(getRank(lhsIter), getRank(rhsIter));

    if (c != 0)
      return c;

    c = Integer.compare(getRank(lhsIter), getRank(rhsIter));

    if (c != 0)
      return c;

    // check the spare card in each hand
    return Integer.compare(hand.getRankHistogram().findRankWithCount(1),
                           rhsTwoPair.hand.getRankHistogram().findRankWithCount(1));
  }

  private int getRank(ReverseArrayIterator iter) throws Exception {
    while (iter.hasPrevious())
      if (iter.previous() == 2)
        return iter.previousIndex() + 1; // TODO: call to .previous() changed index!

    throw new Exception("can't get rank!");
  }

}
