package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.categories.TwoPairHandCategory;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 01:53
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairHandCategoryResolver extends HandCategoryResolver {
  @Override
  public HandCategory resolve(Hand hand) {
    int count = hand.getRankHistogram().getCount(2);
    if (count == 2)
      return new TwoPairHandCategory("2pair", this.number, hand);
    else
      return this.nextResolver.resolve(hand);

  }
}
