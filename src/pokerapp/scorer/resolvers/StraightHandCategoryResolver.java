package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.categories.StraightHandCategory;

/**
 * StraightHandCategoryResolver
 * Steve + Ari
 *
 *
 *
 */
public class StraightHandCategoryResolver extends HandCategoryResolver {

  public StraightHandCategoryResolver() {
    super(new StraightHandCategory("straight"));
  }

  @Override
  protected boolean matches(HandCategoryResolverRequest request) throws Exception {
    return isStraight(request.getHand());
  }

  private boolean isStraight(Hand hand) {
      HandRanks handRanks = new HandRanks(hand);
    if (isStraight(handRanks))
          return true;
    else {
          handRanks.lowAcesOn();
          boolean isstraight = (isStraight(handRanks));
          handRanks.lowAcesOff();
          return  isstraight;
       }
  }

  private boolean isStraight(HandRanks handRanks) {

    StringBuilder builder = new StringBuilder();
    for (int count_at_rank : handRanks.rank_histogram) {
      builder.append(count_at_rank);
    }
    String rank_counts = builder.toString();
    return(rank_counts.contains("11111"));
  }
}

