package pokerapp.scorer.categories;

import pokerapp.Hand;
import pokerapp.HandRankHistogram;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 02:35
 * To change this template use File | Settings | File Templates.
 */
public class HighCardCategory extends RankedHandCategory {

  public HighCardCategory(String name, int cn, Hand hand, int rank, HandRankHistogram rankHistogram) {
    super(name, cn, hand, rank, rankHistogram);
  }

  @Override
  public int compareEqualCategories(HandCategory rhs) {
    // only has 'spares'
    return compareSpares((HighCardCategory)rhs);
  }
}
