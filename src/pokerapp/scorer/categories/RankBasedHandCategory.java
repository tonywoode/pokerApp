package pokerapp.scorer.categories;

import pokerapp.Hand;
import pokerapp.HandRankHistogram;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 23/02/13
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public abstract class RankBasedHandCategory extends HandCategory {
  private final HandRankHistogram rankHistogram;

  public RankBasedHandCategory(String name, int cn, Hand hand, int rank, HandRankHistogram rankHistogram) {
    super(name, cn, hand, rank);
    this.rankHistogram = rankHistogram;
  }

  protected HandRankHistogram getRankHistogram() { return rankHistogram; }
}
