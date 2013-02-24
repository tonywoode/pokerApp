package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.HandRankHistogram;
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
  public HandCategory resolve(HandCategoryResolverRequest request) throws Exception {
    HandRankHistogram rankHistogram = request.getRankHistogram();

    int count = rankHistogram.getCount(rankValue);
    if (count == rankCount) {
      return createHandCategory(request.getHand(), rankHistogram.getRankFromCount(rankValue), rankHistogram);
    } else
      return this.nextResolver.resolve(request);
  }

    protected HandCategory createHandCategory(Hand hand, int rank, HandRankHistogram rankHistogram) {
        return new RankedHandCategory(this.name, this.number, hand, rank, rankHistogram);
    }
}
