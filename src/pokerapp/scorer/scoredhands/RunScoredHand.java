package pokerapp.scorer.scoredhands;

import pokerapp.Hand;
import pokerapp.scorer.domain.SameRankSequence;
import pokerapp.scorer.domain.Spares;
import pokerapp.utils.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 00:42
 * To change this template use File | Settings | File Templates.
 */
public class RunScoredHand extends AbstractScoredHand<RunScoredHand> {

  private String name;
  private SameRankSequence sameRankSequence;
  private Spares spares;

  public RunScoredHand(int handNumber, Hand hand, String name, SameRankSequence sameRankSequence, Spares spares) {
    super(handNumber, hand);
    this.name = name;
    this.sameRankSequence = sameRankSequence;
    this.spares = spares;
  }

  @Override
  public String getName() {
    return name;
  }

  public int getRank() { return sameRankSequence.getRank(); }

  @Override
  protected int compareEqualCategories(RunScoredHand rhs) {
    return Comparator
        .begin(sameRankSequence, rhs.sameRankSequence)
        .next(spares, rhs.spares)
        .compare();
  }
}
