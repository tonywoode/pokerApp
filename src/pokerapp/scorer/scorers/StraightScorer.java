package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scoredhands.StraightScoredHand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:15
 * To change this template use File | Settings | File Templates.
 */
public class StraightScorer {
  private static final int NUM_CARDS_IN_STRAIGHT = 5;

  protected ScoredHand resolveCore(Hand hand) {
    HandRanks rh = new HandRanks(hand);
    //if (("1" + rh.toString()).contains(String. "1".repeat(NUM_CARDS_IN_STRAIGHT)))
    if (("1" + rh.toString()).contains("11111"))
      return new StraightScoredHand(getHandNmber(), hand);
    else
      return null;
  }
}
