package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:11
 * To change this template use File | Settings | File Templates.
 */
public abstract class HandScorer {
  private HandScorer next;

  public void setNextResolver(HandScorer next) {
    this.next = next;
  }

  public ScoredHand resolve(Hand hand) {
    ScoredHand scoredHand = resolveCore(hand);
    if (scoredHand != null)
      return scoredHand;
    else
      return next.resolve(hand);
  }

  protected abstract ScoredHand resolveCore(Hand hand);
}
