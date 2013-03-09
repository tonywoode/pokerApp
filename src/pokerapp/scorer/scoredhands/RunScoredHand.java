package pokerapp.scorer.scoredhands;

import pokerapp.Hand;
import pokerapp.scorer.domain.SameRankSequence;
import pokerapp.scorer.domain.Spares;
import pokerapp.utils.Comparator;

/**
 * Sets up ranking for hand ratings, in case we get the same hand rating in more than one hand,
 * we need to know which hand has higher rating TODO//is that right?
 * @author Steve
 * @version 1.0
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
