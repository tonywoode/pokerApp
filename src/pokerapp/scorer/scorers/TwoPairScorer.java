package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.domain.SameRankCards;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scoredhands.TwoPairScoredHand;
import pokerapp.utils.ReverseArrayIterator;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairScorer extends SameRankHandScorer {
  public TwoPairScorer() {
    super(null, 2, 2);
  }

  protected ScoredHand createHandCategory(Hand hand, HandRanks hr) {
    ReverseArrayIterator iter = hr.iterator();

    SameRankCards highPair = createSameRankSequence(hand, getRank(iter));
    SameRankCards lowPair = createSameRankSequence(hand, getRank(iter));

    final int NUM_CARDS_IN_KICKER = 1;
    Rank rank = Rank.from(hr.getRankOfMultiple(NUM_CARDS_IN_KICKER));

    return new TwoPairScoredHand(getHandNumber(), hand, highPair, lowPair, hand.getKickers(rank));
  }

  private Rank getRank(ReverseArrayIterator iter) {
    final int NUM_CARDS_IN_PAIR = 2;
    while (iter.hasPrevious())
      if (iter.previous() == NUM_CARDS_IN_PAIR)
        return Rank.from(iter.previousIndex() + 1);

    throw new IllegalArgumentException("can't get rank!");
  }


}
