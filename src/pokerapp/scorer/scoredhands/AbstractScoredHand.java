package pokerapp.scorer.scoredhands;

import pokerapp.Hand;

/**
 * Implements Coplien's Curiously Recurring Template Pattern to
 * avoid issues with Java's lack of covariant parameter types.
 * 
 * @author Steve Faulmann
 *
 */
public abstract class AbstractScoredHand<T> extends ScoredHand {

  protected AbstractScoredHand(int handNumber, Hand hand) {
    super(handNumber, hand);
  }

  @Override
  protected int compareEqualCategories(ScoredHand rhsBase) {
    return compareEqualCategories((T)rhsBase);
  }

  protected abstract int compareEqualCategories(T rhs);
}
