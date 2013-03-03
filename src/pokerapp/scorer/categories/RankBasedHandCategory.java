package pokerapp.scorer.categories;

import pokerapp.scorer.HandRankHistogram;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 23/02/13
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public abstract class RankBasedHandCategory extends HandCategory {
  private HandRankHistogram rankHistogram;

  public RankBasedHandCategory(String name) {
    super(name);
  }

  protected HandRankHistogram getRankHistogram() { return rankHistogram; }
}
