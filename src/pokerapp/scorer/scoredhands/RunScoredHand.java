package pokerapp.scorer.scoredhands;

import pokerapp.Hand;
import pokerapp.scorer.domain.SameRankCards;
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
  private SameRankCards sameRankCards;
  private Spares spares;

  public RunScoredHand(int handNumber, Hand hand, String name, SameRankCards sameRankCards, Spares spares) {
    super(handNumber, hand);
    this.name = name;
    this.sameRankCards = sameRankCards;
    this.spares = spares;
  }

  @Override
  public String getName() {
    return name;
  }

  public int getRank() { return sameRankCards.getRank(); }

  @Override
  protected int compareEqualCategories(RunScoredHand rhs) {
    return Comparator
        .begin(sameRankCards, rhs.sameRankCards)
        .next(spares, rhs.spares)
        .compare();
  }
}
