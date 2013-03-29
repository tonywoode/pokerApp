package pokerapp.scorer.scorers;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.scorer.scoredhands.ScoredHand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 21:15
 *
 * Pattern: Implements the Composite pattern
 *
 */
public abstract class CompositeScorer extends HandScorer {
  private ArrayList<HandScorer> scorers = new ArrayList<HandScorer>();

  public CompositeScorer(HandScorer... scorers) {
    for (HandScorer scorer : scorers)
      this.scorers.add(scorer);
  }

  @Override
  protected ScoredHand resolveCore(Hand hand) {
    ArrayList<ScoredHand> scoredHands = new ArrayList<ScoredHand>();
    for (HandScorer scorer : scorers) {
      ScoredHand scoredHand = scorer.score(hand);
      if (scoredHand == null)
        return null;
      scoredHands.add(scoredHand);
    }
    return createCategory(hand, scoredHands);
  }

  protected abstract ScoredHand createCategory(Hand hand, ArrayList<ScoredHand> scoredHands);
}
