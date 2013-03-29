package pokerapp.scorer.scoredhands;

import pokerapp.Hand;
import pokerapp.scorer.typetag.HandType;

/**
 * Implements Coplien's Curiously Recurring Template Pattern to
 * avoid issues with Java's lack of covariant parameter types.
 * 
 * @author Steve Faulmann
 *
 */
public abstract class AbstractScoredHand<T> extends ScoredHand {

  protected String name;

  protected AbstractScoredHand(int handNumber, Hand hand, HandType handType) {
    super(handNumber, hand, handType);
  }

  @Override
  protected int compareEqualCategories(ScoredHand rhsBase) {
    return compareEqualCategories((T)rhsBase);
  }

  protected abstract int compareEqualCategories(T rhs);
}
