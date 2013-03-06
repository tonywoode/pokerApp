package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.HandSuits;
import pokerapp.scorer.scoredhands.FlushScoredHand;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:13
 * To change this template use File | Settings | File Templates.
 */
public class FlushScorer extends HandScorer {
  private static final int NUM_CARDS_IN_FLUSH = 5;

  @Override
  protected ScoredHand resolveCore(Hand hand) {
    if (new HandSuits(hand).hasCount(NUM_CARDS_IN_FLUSH))
      return new FlushScoredHand("flush", hand);
    else
      return null;
  }
}
