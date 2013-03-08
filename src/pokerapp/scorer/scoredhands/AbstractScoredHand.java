package pokerapp.scorer.scoredhands;

import pokerapp.Hand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:19
 *
 * @author Steve Faulmann
 *
 * Implements Coplien's Curiously Recurring Template Pattern to
 * avoid issues with Java's lack of covariant parameter types.
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
