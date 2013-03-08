package tests.scorer.resolvers;

import org.junit.Test;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.StraightScorer;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Ari G
 * Date: 25/02/13
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
public class StraightHandScorerTestFixture extends HandScorerTestFixtureBase {

    //TODO: could perhaps use Sam's permutation or variation thereof to populate test cases

    public StraightHandScorerTestFixture() {
      super(new StraightScorer());
    }

    @Test
    public void Hand_Is_Wheel() {
      ScoredHand hand = resolveHand("D2", "S3", "C4", "D5", "H14");

      assertEquals("Is straight", "Straight", hand.getName());
    }

    @Test
    public void Hand_Is_Straight_in_order() {
      ScoredHand hand = resolveHand("D2", "S3", "C4", "D5", "H6");

      assertEquals("Is straight", "Straight", hand.getName());
    }
    @Test
    public void Hand_Is_Straight_not_in_order() {
      ScoredHand hand = resolveHand("D3", "S5", "C2", "D4", "H6");

      assertEquals("Is straight", "Straight", hand.getName());
    }
    @Test
    public void Hand_Is_Not_Straight() {
      ScoredHand hand = resolveHand("D3", "S9", "C2", "D4", "H6");

      assertEquals("Is straight", null, hand);
    }

}
