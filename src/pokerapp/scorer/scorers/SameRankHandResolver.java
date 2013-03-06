package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.scoredhands.RunScoredHand;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:25
 * To change this template use File | Settings | File Templates.
 */
public class SameRankHandResolver extends ScoredHandResolver {
  private int rankValue, rankCount;

  public SameRankHandResolver(String name, int rankValue, int rankCount) {
    this.rankValue = rankValue;
    this.rankCount = rankCount;
  }

  @Override
  protected ScoredHand resolveCore(Hand hand) {
    HandRanks rh = new HandRanks(hand);
    if (rh.find(rankValue) == rankCount)
      return createHandCategory(hand, rh);
    else
      return null;
  }

  protected ScoredHand createHandCategory(Hand hand, RankHistogram) {
    return new RunScoredHand(hand, Spares.create(hand, ???));
  }
}
