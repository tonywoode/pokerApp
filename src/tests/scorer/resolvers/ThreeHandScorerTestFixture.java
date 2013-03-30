package tests.scorer.resolvers;

import org.junit.Test;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.SameRankHandScorer;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 18:51
 * To change this template use File | Settings | File Templates.
 */
public class ThreeHandScorerTestFixture extends HandScorerTestFixtureBase {

  public ThreeHandScorerTestFixture() {
    super(new SameRankHandScorer("Three of a kind", 3, 1));
  }

     @Test
    public void HandIsThree_first3() throws FileNotFoundException {
      ScoredHand hand = resolveHand("D4", "S4", "C4", "C3", "C5");

      assertEquals("Is three", "Three of a kind", hand.getName());
    }

    @Test
    public void HandIsNotThree() {
      ScoredHand hand = resolveHand("D4", "S4", "C2", "C3", "C5");

      assertEquals("Is not three", null, hand);
    }


}
