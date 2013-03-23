package pokerapp.scorer;

import pokerapp.scorer.scorers.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Builds the categories of scoring hands and returns the ordered list of them
 * User: steve
 * Date: 22/02/13
 * Time: 01:55
 * To change this template use File | Settings | File Templates.
 */
public class HandScorerBuilder {

  public HandScorer create() throws IOException {
    ArrayList<HandScorer> scorers = new ArrayList<HandScorer>();
    Properties prop = new Properties();
    InputStreamReader in = new InputStreamReader(getClass().getResourceAsStream("/handnames.properties"));
    prop.load(in);
    in.close();

    scorers.add(new RoyalFlushScorer(new StraightScorer(), new FlushScorer()));
    scorers.add(new StraightFlushScorer(new StraightScorer(), new FlushScorer()));
    scorers.add(new SameRankHandScorer(prop.getProperty("FourOfAKind"), 4, 1));
    scorers.add(new FullHouseScorer(new SameRankHandScorer("ThreeOfAKind", 3, 1), new SameRankHandScorer("Pair", 2, 1)));
    scorers.add(new FlushScorer());
    scorers.add(new StraightScorer());
    scorers.add(new SameRankHandScorer("ThreeOfAKind", 3, 1));
    scorers.add(new TwoPairScorer());
    scorers.add(new SameRankHandScorer("Pair", 2, 1));
    scorers.add(new NoPairScorer());
    scorers.add(null);

    for (int iter = 0; iter < scorers.size() - 1; ++iter) {
      scorers.get(iter).setNextScorer(scorers.get(iter + 1));
      scorers.get(iter).setHandNumber(scorers.size() - iter);
    }

    return scorers.get(0);
  }

}
