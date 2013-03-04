package pokerapp.scorer.categories;

import pokerapp.scorer.HandRanks;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 23/02/13
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public abstract class RankBasedHandCategory extends HandCategory {
  private HandRanks rankHistogram;

  public RankBasedHandCategory(String name) {
    super(name);
  }

  protected HandRanks getRankHistogram() { return rankHistogram; }
}
