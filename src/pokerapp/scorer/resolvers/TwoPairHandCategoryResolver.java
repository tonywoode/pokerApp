package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.HandRankHistogram;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.categories.RankedHandCategory;
import pokerapp.scorer.categories.TwoPairHandCategory;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 01:53
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairHandCategoryResolver extends RankedHandCategoryResolver {
  public TwoPairHandCategoryResolver() {
    super("2pair", 2, 2);
  }
}
