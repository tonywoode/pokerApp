package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.domain.SameRankSequence;
import pokerapp.scorer.scoredhands.RunScoredHand;
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

  public TwoPairScorer(String name, int rankValue, int rankCount) {
    super(name, rankValue, rankCount);
  }


  @Override
  protected ScoredHand resolveCore(Hand hand) {
    return null;

    /*
    Pair highPair = Pair.from(hand, rh.highest(rankValue)),
         lowPair  = Pair.from(hand, rh.lowest(rankValue));

    Spares spares = Spares.from(hand, rh.findWith(SPARE_COUNT));

    return new TwoPairRunHandCategory(highPair, lowPair, spares);
    */
  }



  protected ScoredHand createHandCategory(Hand hand, HandRanks hr) {
    try {
      ReverseArrayIterator iter = hr.iterator();

      SameRankSequence highPair = createSameRankSequence(hand, getRank(iter));
      SameRankSequence lowPair  = createSameRankSequence(hand, getRank(iter));

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
