package pokerapp.scorer;

import pokerapp.scorer.scorers.*;

import java.util.ArrayList;

/**
 * Builds the categories of scoring hands and returns the ordered list of them
 * User: steve
 * Date: 22/02/13
 * Time: 01:55
 * To change this template use File | Settings | File Templates.
 */
public class HandScorerBuilder {

  public HandScorer create() {
    ArrayList<HandScorer> scorers = new ArrayList<HandScorer>();

    scorers.add(new StraightFlushScorer(new StraightScorer(), new FlushScorer()));
    scorers.add(new SameRankHandScorer("four", 4, 1));
    scorers.add(new FullHouseScorer(new SameRankHandScorer("three", 3, 1), new SameRankHandScorer("pair", 2, 1)));
    scorers.add(new FlushScorer());
    scorers.add(new StraightScorer());
    scorers.add(new SameRankHandScorer("three", 3, 1));
    scorers.add(new TwoPairScorer());
    scorers.add(new SameRankHandScorer("pair", 2, 1));
    scorers.add(new NoPairScorer());
    scorers.add(null);

    for (int iter = 0; iter < scorers.size() - 1; ++iter) {
      scorers.get(iter).setNextScorer(scorers.get(iter + 1));
      scorers.get(iter).setHandNumber(scorers.size() - iter);
    }

    return scorers.get(0);
  }

}
