package pokerapp.scorer.categories;

import pokerapp.Hand;
import pokerapp.HandRankHistogram;

/**
 * Adds the rank histogram to the hand categories
 * @author Steve
 * @version 1.0
 */
public abstract class RankBasedHandCategory extends HandCategory {
  private HandRankHistogram rankHistogram;

  public RankBasedHandCategory(String name) {
    super(name);
  }

  protected HandRankHistogram getRankHistogram() { return rankHistogram; }
}
