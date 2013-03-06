package tests.scorer.resolvers;

import org.junit.Test;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.StraightHandCategoryResolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created with IntelliJ IDEA.
 * User: Ari G
 * Date: 25/02/13
 * Time: 21:22
 *
 */
public class StraightHandCategoryResolverTestFixture extends HandCategoryResolverTestFixtureBase {
     //TODO: wheel evaluator
    //TODO: could perhaps use Sam's permutator or variation thereof to populate test cases
    public StraightHandCategoryResolverTestFixture(){
        super(new StraightHandCategoryResolver());
    }

    @Test
    public void Hand_Is_Straight_in_order() {
        HandCategory category = resolveHand("D2", "S3", "C4", "D5", "H6");

        assertEquals("Is straight", "straight", category.getName());
    }
    @Test
    public void Hand_Is_Straight_not_in_order() {
        HandCategory category = resolveHand("D3", "S5", "C2", "D4", "H6");

        assertEquals("Is straight", "straight", category.getName());
    }

  @Test
  public void Hand_Is_Wheel() {
    HandCategory category = resolveHand("D2", "S3", "C4", "D5", "H14");

    assertEquals("Is straight", "straight", category.getName());
  }

    @Test
    public void Hand_Is_Not_Straight() {
        HandCategory category = resolveHand("D3", "S9", "C2", "D4", "H6");

        assertFalse("straight".equals(category.getName()));
    }


}
