package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scoredhands.StraightScoredHand;
import pokerapp.utils.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:15
 * To change this template use File | Settings | File Templates.
 */
public class StraightScorer extends HandScorer {
  //private static final int NUM_CARDS_IN_STRAIGHT = 5;

  protected ScoredHand resolveCore(Hand hand) {
    HandRanks rh = new HandRanks(hand);
    int rank = 0;

    // TODO: fix hardcoded "11111"; would like: "1".repeat(NUM_CARDS_IN_STRAIGHT)


    if(rh.toString().contains(Constants.STRAIGHT_SIGNATURE)) {
      return new StraightScoredHand(getHandNumber(), hand, rank);
    }
    else{
      char hi_ace_count = rh.toString().charAt(Constants.NUM_RANKS);
      StringBuilder builder_check_wheel = new StringBuilder(rh.toString());
      builder_check_wheel.setCharAt(1, hi_ace_count);
      String check_wheel = builder_check_wheel.toString();
      if (check_wheel.contains(Constants.STRAIGHT_SIGNATURE))
        return new StraightScoredHand(getHandNumber(),hand,rank );
      else return null;
    }
  }
}
