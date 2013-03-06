package pokerapp.scorer.scoredhands;

import lombok.Getter;
import pokerapp.Hand;
import pokerapp.utils.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:05
 * To change this template use File | Settings | File Templates.
 */
public class FullHouseScoredHand extends AbstractScoredHand<FullHouseScoredHand> {
  @Getter private RunScoredHand triple, pair;

  public FullHouseScoredHand(int handNumber, Hand hand, RunScoredHand triple, RunScoredHand pair) {
    super(handNumber, hand);
    this.triple = triple;
    this.pair = pair;
  }

  @Override
  protected int compareEqualCategories(FullHouseScoredHand rhs) {
    return Comparator
        .begin(triple.getRank(), rhs.triple.getRank())
        .next(pair.getRank(), rhs.pair.getRank())
        .compare();
  }

  @Override
  public String getName() {
    return "Full house";
  }
}
