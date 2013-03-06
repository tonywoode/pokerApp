package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.categories.StraightHandCategory;
import pokerapp.utils.Constants;

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
    return (isStraight(handRanks));
  }

  private boolean isStraight(HandRanks handRanks) {

    StringBuilder build_rank_counts = new StringBuilder();
    for (int count_at_rank : handRanks.rank_histogram) {
      build_rank_counts.append(count_at_rank);
    }
    String rank_counts = build_rank_counts.toString();

    if(rank_counts.contains("11111")){
      return true;
    }
    else{
      //check wheel by copying aces to slot 1 (for low aces)
      char hi_ace_count = rank_counts.charAt(Constants.MAX_RANKS);
      StringBuilder builder_check_wheel = new StringBuilder(rank_counts);
      builder_check_wheel.setCharAt(1, hi_ace_count);
      String check_wheel = builder_check_wheel.toString();
      return (check_wheel.contains("11111"));
    }
  }
}

