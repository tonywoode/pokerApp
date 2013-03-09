package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.scoredhands.RoyalFlushScoredHand;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scoredhands.StraightFlushScoredHand;

/**
 * Created with IntelliJ IDEA.
 * User: Steve & Ari
 * Date: 09/03/13
 * Time: 22:36
 * To change this template use File | Settings | File Templates.
 */
public class RoyalFlushScorer extends StraightFlushScorer {
  public RoyalFlushScorer(StraightScorer straight, FlushScorer flush) {
    super(straight, flush);
  }

  protected ScoredHand resolveCore(Hand hand) {
    StraightFlushScoredHand scoredHand = (StraightFlushScoredHand)super.resolveCore(hand);
    return scoredHand != null && scoredHand.getRank() == 14 ?
            new RoyalFlushScoredHand(scoredHand)
            : null;
  }
}
