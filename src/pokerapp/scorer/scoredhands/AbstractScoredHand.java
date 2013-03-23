package pokerapp.scorer.scoredhands;

import pokerapp.Hand;
import pokerapp.scorer.typetag.HandTypeTag;

/**
 * Implements Coplien's Curiously Recurring Template Pattern to
 * avoid issues with Java's lack of covariant parameter types.
 * 
 * @author Steve Faulmann
 *
 */
public abstract class AbstractScoredHand<T,U extends HandTypeTag> extends ScoredHand<U> {

  protected AbstractScoredHand(int handNumber, Hand hand) {
    super(handNumber, hand);
  }

  @Override
  protected int compareEqualCategories(ScoredHand rhsBase) {
    return compareEqualCategories((T)rhsBase);
  }

  protected abstract int compareEqualCategories(T rhs);
}
