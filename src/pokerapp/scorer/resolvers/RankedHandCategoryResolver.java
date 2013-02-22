package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.categories.RankedHandCategory;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class RankedHandCategoryResolver extends HandCategoryResolver {
  String name;
  int rankValue;

  public RankedHandCategoryResolver(String name, int rankValue) {
    this.name = name;
    this.rankValue = rankValue;
  }

  @Override
  public HandCategory resolve(Hand hand) {
    int count = hand.getRankHistogram().getCount(rankValue);
    if (count == 1) {
      hand.getRankHistogram().setRankFromCount(rankValue);
      return new RankedHandCategory(this.name, this.number, hand);
    } else
      return this.nextResolver.resolve(hand);
  }
}
