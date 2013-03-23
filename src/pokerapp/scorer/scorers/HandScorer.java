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
  /*@Getter*/ private int handNumber = -1;

  protected int getHandNumber() { return handNumber; }

  public void setNextScorer(HandScorer next) {
    this.next = next;
  }

  public void setHandNumber(int handNumber) {
    this.handNumber = handNumber;
  }

  public ScoredHand score(Hand hand) {
    ScoredHand scoredHand = resolveCore(hand);
    if (scoredHand != null)
      return scoredHand;
    else
      if (next != null)
        return next.score(hand);
      else
        return null; // TODO: not good idea to return null; better sentinel value needed
  }

  protected abstract ScoredHand resolveCore(Hand hand);

  public boolean isEndOfChain() {
    return next == null;
  }
}
