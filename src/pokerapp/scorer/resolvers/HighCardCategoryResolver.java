package pokerapp.scorer.resolvers;

import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.categories.HighCardCategory;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 02:34
 * To change this template use File | Settings | File Templates.
 */
public class HighCardCategoryResolver extends HandCategoryResolver {
  @Override
  public HandCategory resolve(HandCategoryResolverRequest request) {
    return new HighCardCategory("highCard", number, request.getHand(), -1, request.getRankHistogram());
  }
}
