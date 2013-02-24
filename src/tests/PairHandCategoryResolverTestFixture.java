package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import pokerapp.Hand;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.RankedHandCategoryResolver;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */

public class PairHandCategoryResolverTestFixture extends HandCategoryResolverTestFixtureBase {

  public PairHandCategoryResolverTestFixture() {
    super(new RankedHandCategoryResolver("pair", 2));
  }

  @Test // TODO: these should use data providers...
  public void HandIsPair_first2() {
    HandCategory category = resolveHand("D4", "S4", "C2", "C3", "C5");
	
	  assertEquals("Is pair", "pair", category.getName());
  }
  
  @Test
  public void HandIsPair_second2() {
    HandCategory category = resolveHand("C2", "D4", "S4", "C3", "C5");

    assertEquals("Is pair", "pair", category.getName());
  }
  
  @Test
  public void HandIsPair_third2() {
    HandCategory category = resolveHand("C2", "C3", "D4", "S4", "C5");

    assertEquals("Is pair", "pair", category.getName());
  }  
  
  @Test
  public void HandIsPair_fourth2() {
    HandCategory category = resolveHand("C2", "C3", "C5", "D4", "S4");

    assertEquals("Is pair", "pair", category.getName());
  }    

  @Test
  public void HandIsNotPair() {
    HandCategory category = resolveHand("D4", "S3");
	
	  assertSame("Is pair", null, category);
  }
  

  @Test
  public void RhsWins() {
    Hand lhs = createHand("D4", "S4"),
	       rhs = createHand("D5", "S5");

	  verifyWinner(lhs, rhs, rhs);
  }
  
  @Test
  public void LhsWins() {
    Hand lhs = createHand("D5", "S5"),
	       rhs = createHand("D4", "S4");

	  verifyWinner(lhs, rhs, lhs);
  }  
  
  @Test
  public void HighestSpareWins_wins() {
    Hand lhs = createHand("D5", "S5", "C6", "C7", "C8"),
	       rhs = createHand("H5", "C5", "C6", "C7", "C9");

	  verifyWinner(lhs, rhs, rhs);
  }  

  @Test
  public void SecondHighestSpareWins_wins() {
    Hand lhs = createHand("D5", "S5", "C6", "C7", "C9"),
	       rhs = createHand("H5", "C5", "C6", "C8", "C9");

	  verifyWinner(lhs, rhs, rhs);
  }  

  @Test
  public void ThirdHighestSpareWins_wins() {
    Hand lhs = createHand("D5", "S5", "C6", "C8", "C9"),
	       rhs = createHand("H5", "C5", "H7", "H8", "H9");

	  verifyWinner(lhs, rhs, rhs);
  }  

  @Test
  public void Pair_tie() {
    Hand lhs = createHand("D3", "S3", "C5", "C6", "C7"),
	       rhs = createHand("H3", "C3", "H5", "H6", "H7");

	  verifyWinner(lhs, rhs, null);
  }  
  
}