package pokerapp.tests;

import org.junit.Test;
import pokerapp.Hand;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.RankedHandCategoryResolver;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class FourHandCategoryResolverTestFixture extends HandCategoryResolverTestFixtureBase {
  public FourHandCategoryResolverTestFixture() {
    super(new RankedHandCategoryResolver("four", 4));
  }

  @Test // TODO: these should use data providers...
  public void HandIsFour_first3() {
    HandCategory category = resolveHand("D4", "S4", "C4", "H4", "C5");

    assertEquals("Is four", "four", category.getName());
  }

  @Test // TODO: these should use data providers...
  public void HandIsNotThree() {
    HandCategory category = resolveHand("D4", "S4", "C4", "H3", "C5");

    assertEquals("Is not four", null, category);
  }

  @Test
  public void CompareHands_LhsWins() {
    Hand lhs = createHand("D4", "S4", "C4", "H4", "C8"),
         rhs = createHand("D5", "S5", "C5", "H5", "C9");

    verifyWinner(lhs, rhs, rhs);
  }

  @Test
  public void CompareHands_RhsWins() {
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
