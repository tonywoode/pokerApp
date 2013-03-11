package pokerapp.scorer.scoredhands;

import lombok.Getter;
import pokerapp.Hand;
import pokerapp.scorer.domain.SameRankCards;
import pokerapp.scorer.domain.Spares;
import pokerapp.utils.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:02
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairScoredHand extends AbstractScoredHand<TwoPairScoredHand> {

  @Getter private SameRankCards highPair, lowPair;
  @Getter private Spares spares;

  public TwoPairScoredHand(int handNumber, Hand hand, SameRankCards highPair, SameRankCards lowPair, Spares spares) {
    super(handNumber, hand);
    this.highPair = highPair;
    this.lowPair = lowPair;
    this.spares = spares;
  }

  protected int compareEqualCategories(TwoPairScoredHand rhs) { //TODO:issue 82
    return Comparator
        .begin(highPair, rhs.highPair)
        .next(lowPair, rhs.lowPair)
        .next(spares, rhs.spares)
        .compare();
  }

  @Override
  public String getName() {
    return "Two pair";
  }
}