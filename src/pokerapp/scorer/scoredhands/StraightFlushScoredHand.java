package pokerapp.scorer.scoredhands;

import lombok.Getter;
import pokerapp.Hand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:08
 * To change this template use File | Settings | File Templates.
 */
public class StraightFlushScoredHand extends AbstractScoredHand<StraightFlushScoredHand> {

  @Getter private int rank;

  public StraightFlushScoredHand(int handNumber, Hand hand, int rank) {
    super(handNumber, hand);
    this.rank = rank;
  }

  @Override
  protected int compareEqualCategories(StraightFlushScoredHand rhs) {
    return Integer.compare(rank, rhs.rank);
  }

  @Override
  public String getName() {
    return "Straight flush";
  }
}