package pokerapp.scorer.scorers;

import pokerapp.Hand;
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
  private static final int SPARE_COUNT = 1;

  public TwoPairScorer() {
    super(null /* TODO: hacky */, 2, 2);
  }

  protected ScoredHand createHandCategory(Hand hand, HandRanks hr) {
    try {
      ReverseArrayIterator iter = hr.iterator();

      SameRankCards highPair = createSameRankSequence(hand, getRank(iter));
      SameRankCards lowPair  = createSameRankSequence(hand, getRank(iter));

      final int NUM_CARDS_IN_KICKER = 1;
      int rank = hr.getRankOfMultiple(NUM_CARDS_IN_KICKER);

      return new TwoPairScoredHand(getHandNumber(), hand, highPair, lowPair, hand.getKickers(rank));
    }
    catch(Exception e) { // TODO: remove this & use checked exceptions properly
      return null;
    }
  }

  private int getRank(ReverseArrayIterator iter) throws Exception {
    final int NUM_CARDS_IN_PAIR = 2;
    while (iter.hasPrevious())
      if (iter.previous() == NUM_CARDS_IN_PAIR)
        return iter.previousIndex() + 1; // TODO: call to .previous() changed index!

    throw new Exception("can't get rank!");
  }


}
