package tests.scorer.resolvers;

import org.junit.Test;
import pokerapp.Hand;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.FlushScorer;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays + Ari
 * Date: 26/02/13
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 */
public class FlushHandScorerTestFixture extends HandScorerTestFixtureBase {
  public FlushHandScorerTestFixture() {
    super(new FlushScorer());
  }

  @Test
  public void Simple_Flush() throws FileNotFoundException {
    ScoredHand hand = resolveHand("D4", "D5", "D6", "D7", "D9");

    assert ("Flush".equals(hand.getName()));
  }

  @Test
  public void HandIsNotFlush() {
    ScoredHand hand = resolveHand("D4", "D3", "D2", "D5", "C6");

    assertEquals(null, hand);
  }

  @Test
  public void CompareHands_RhsWins() {
    Hand lhs = createHand("D3", "D5", "D6", "D7", "D9"),
         rhs = createHand("D4", "D5", "D6", "D7", "D9");

    verifyWinner(lhs, rhs, rhs);
  }

  @Test
  public void CompareHands_LhsWins() {
    Hand lhs = createHand("D4", "D5", "D6", "D7", "D9"),
         rhs = createHand("D4", "D5", "D6", "D7", "D8");

    verifyWinner(lhs, rhs, lhs);
  }
}