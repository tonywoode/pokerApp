package tests;

import org.junit.Test;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.RankedHandCategoryResolver;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 18:51
 * To change this template use File | Settings | File Templates.
 */
public class ThreeHandCategoryResolverTestFixture extends HandCategoryResolverTestFixtureBase {

  public ThreeHandCategoryResolverTestFixture() {
    super(new RankedHandCategoryResolver("three", 3));
  }

     @Test // TODO: these should use data providers...
    public void HandIsThree_first3() {
        HandCategory category = resolveHand("D4", "S4", "C4", "C3", "C5");

        assertEquals("Is three", "three", category.getName());
    }

    @Test // TODO: these should use data providers...
    public void HandIsNotThree() {
        HandCategory category = resolveHand("D4", "S4", "C2", "C3", "C5");

        assertEquals("Is not three", null, category);
    }


}
