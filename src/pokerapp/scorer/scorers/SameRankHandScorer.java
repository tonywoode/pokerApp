package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.domain.SameRankSequence;
import pokerapp.scorer.scoredhands.RunScoredHand;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:25
 * To change this template use File | Settings | File Templates.
 */
public class SameRankHandScorer extends HandScorer {
  private int rankValue, rankCount;
  private String name;

  public SameRankHandScorer(String name, int rankValue, int rankCount) {
    this.name = name;
    this.rankValue = rankValue;
    this.rankCount = rankCount;
  }

  @Override
  protected ScoredHand resolveCore(Hand hand) {
    HandRanks hr = new HandRanks(hand);

    if (hr.countMultiple(rankValue) == rankCount)
      return createHandCategory(hand, hr);
    else
      return null;
  }

  // Pattern: Factory Method
  protected ScoredHand createHandCategory(Hand hand, HandRanks hr) {
    try {
      int rank = hr.getRankOfMultiple(rankValue);
      SameRankSequence sequence = createSameRankSequence(hand, rank);
      return new RunScoredHand(getHandNumber(), hand, name, sequence, hand.getKickers(rank));
    }
    catch(Exception e) { // TODO: remove this & use checked exceptions properly
      return null;
    }
  }

  protected SameRankSequence createSameRankSequence(Hand hand, int... rank) {
    return new SameRankSequence(hand.cardsOfRank(rank));
  }
}
