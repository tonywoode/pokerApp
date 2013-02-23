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
    private final int rankCount;


    public RankedHandCategoryResolver(String name, int rankValue, int rankCount) {
        this.name = name;
        this.rankValue = rankValue;
        this.rankCount = rankCount;
  }
    public RankedHandCategoryResolver(String name, int rankValue) {
        this(name, rankValue, 1);
    }


  @Override
  public HandCategory resolve(Hand hand) {
    int count = hand.getRankHistogram().getCount(rankValue);
    if (count == rankCount) {
      hand.getRankHistogram().setRankFromCount(rankValue);
     return createHandCategory(hand);
    } else
      return this.nextResolver.resolve(hand);
  }

    protected HandCategory createHandCategory(Hand hand){
        return new RankedHandCategory(this.name, this.number, hand);
    }
}
