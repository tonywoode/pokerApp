package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.scoredhands.FullHouseScoredHand;
import pokerapp.scorer.scoredhands.SameRankScoredHand;
import pokerapp.scorer.scoredhands.ScoredHand;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */
public class FullHouseScorer extends CompositeScorer {

  private static final int TRIPLE_CATEGORY = 0, PAIR_CATEGORY = 1;

  public FullHouseScorer(SameRankHandScorer three, SameRankHandScorer pair) {
    super(three, pair);
  }

  @Override
  protected ScoredHand createCategory(Hand hand, ArrayList<ScoredHand> scoredHands) {
    return new FullHouseScoredHand(
      getHandNumber(),
      hand,
      (SameRankScoredHand)scoredHands.get(TRIPLE_CATEGORY),
      (SameRankScoredHand)scoredHands.get(PAIR_CATEGORY)
    );
  }
}
