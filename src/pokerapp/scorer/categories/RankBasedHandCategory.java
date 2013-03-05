package pokerapp.scorer.categories;

import pokerapp.scorer.HandRanks;

/**
 * Adds the rank histogram to the hand categories
 * @author Steve
 * @version 1.0
 */
public abstract class RankBasedHandCategory extends HandCategory {
  private HandRanks rankHistogram;

  public RankBasedHandCategory(String name) {
    super(name);
  }

  protected HandRanks getRankHistogram() { return rankHistogram; }
}
