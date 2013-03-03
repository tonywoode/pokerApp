package pokerapp.scorer.resolvers;

import pokerapp.scorer.categories.RankedHandCategory;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class RankedHandCategoryResolver extends HandCategoryResolver {
  private final String name;
  private final int rankValue;
  private final int rankCount;

  public RankedHandCategoryResolver(String name, int rankValue, int rankCount) {
    super(new RankedHandCategory(name));
    this.name = name;
    this.rankValue = rankValue;
    this.rankCount = rankCount;
  }

  public RankedHandCategoryResolver(String name, int rankValue) {
    this(name, rankValue, 1);
  }

  @Override
  protected boolean matches(HandCategoryResolverRequest request) throws Exception {
    return request.getRankHistogram().countMultiple(rankValue) == rankCount;
  }

  protected int determineRank(HandCategoryResolverRequest request) throws Exception {
    return request.getRankHistogram().getRankOfMultiple(rankValue);
  }
}
