package tests.scorer.resolvers;

import org.junit.Test;
import pokerapp.Hand;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.SameRankHandScorer;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class FourHandScorerTestFixture extends HandScorerTestFixtureBase {
  public FourHandScorerTestFixture() {
    super(new SameRankHandScorer("Four of a kind", 4, 1));
  }

  @Test
  public void HandIsFour_first3() throws FileNotFoundException {
    ScoredHand hand= resolveHand("D4", "S4", "C4", "H4", "C5");

    assertEquals("Is four", "Four of a kind", hand.getName());
  }

  @Test
  public void HandIsNotThree() {
    ScoredHand hand = resolveHand("D4", "S4", "C4", "H3", "C5");

    assertEquals("Is not four", null, hand);
  }

  @Test
  public void CompareHands_RhsWins() {
    Hand lhs = createHand("D4", "S4", "C4", "H4", "C8"),
         rhs = createHand("D5", "S5", "C5", "H5", "C9");

    verifyWinner(lhs, rhs, rhs);
  }

  @Test
  public void CompareHands_LhsWins() {
    Hand lhs = createHand("D6", "S6", "C6", "H6", "C8"),
         rhs = createHand("D5", "S5", "C5", "H5", "C9");

    verifyWinner(lhs, rhs, lhs);
  }

  @Test
  public void CompareHands_Tie_HighestSpareWins_Lhs() {
    // As Ari pointed out, because we don't have community cards
    // ala Texas Hold'em, we can't have two hands with
    // fours of equal rank

    Hand lhs = createHand("D4", "S4", "C4", "H4", "C8"),
         rhs = createHand("D4", "S4", "C4", "H4", "C9");

    verifyWinner(lhs, rhs, rhs);
  }

}