package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.scoredhands.*;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 21:23
 * To change this template use File | Settings | File Templates.
 */
public class StraightFlushScorer extends CompositeScorer {

  private static final int STRAIGHT_CATEGORY = 0;

  public StraightFlushScorer(StraightScorer straight, FlushScorer flush) {
    super(straight, flush);
  }

  @Override
  protected ScoredHand createCategory(Hand hand, ArrayList<ScoredHand> scoredHands) {
    return new StraightFlushScoredHand(
      getHandNumber(),
      hand,
      ((StraightScoredHand)scoredHands.get(STRAIGHT_CATEGORY)).getRank()
    );
  }
}
