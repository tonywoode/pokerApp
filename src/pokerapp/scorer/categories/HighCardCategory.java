package pokerapp.scorer.categories;

import pokerapp.Hand;
import pokerapp.HandRankHistogram;

/**
 * Describes the lowest poker hand (AKA no-pair) where the only scoring potential is the highest card of the hand 
 * @author steve
 * @version 1.0
 */

public class HighCardCategory extends RankedHandCategory {

  public HighCardCategory(String name) {
    super(name);
  }

  @Override
  public HighCardCategory clone() {
    return new HighCardCategory(this.getName());
  }

  @Override
  public int compareEqualCategories(HandCategory rhs) {
    // only has 'spares'
    return compareSpares((HighCardCategory)rhs);
  }
}
