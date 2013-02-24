package pokerapp.scorer.categories;

import pokerapp.Hand;
import pokerapp.HandRankHistogram;
import pokerapp.utils.ReverseArrayIterator;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 01:54
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairHandCategory extends HandCategory {
  public TwoPairHandCategory(String name) {
    super(name);
  }

  @Override
  public TwoPairHandCategory clone() {
    return new TwoPairHandCategory(this.getName());
  }

  @Override
  public int compareEqualCategories(HandCategory rhs) throws Exception {
    // harder implementation; two separate ranks
    // should be be given the hist info by its resolver


    TwoPairHandCategory rhsTwoPair = (TwoPairHandCategory)rhs;

    ReverseArrayIterator lhsIter = getRankHistogram().iterator(),
                         rhsIter = rhsTwoPair.getRankHistogram().iterator();

    int c = Integer.compare(getRank(lhsIter), getRank(rhsIter));

    if (c != 0)
      return c;

    c = Integer.compare(getRank(lhsIter), getRank(rhsIter));

    if (c != 0)
      return c;

    // check the spare card in each hand
    return Integer.compare(getRankHistogram().getRankFromCount(1),
                           rhsTwoPair.getRankHistogram().getRankFromCount(1));
  }

  private int getRank(ReverseArrayIterator iter) throws Exception {
    while (iter.hasPrevious())
      if (iter.previous() == 2)
        return iter.previousIndex() + 1; // TODO: call to .previous() changed index!

    throw new Exception("can't get rank!");
  }

}
