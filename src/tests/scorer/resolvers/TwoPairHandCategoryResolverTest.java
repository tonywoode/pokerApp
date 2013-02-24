package tests.scorer.resolvers;

import org.junit.Test;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.RankedHandCategoryResolver;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 23/02/13
 * Time: 14:31
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairHandCategoryResolverTest extends HandCategoryResolverTestFixtureBase{

    public TwoPairHandCategoryResolverTest() {
        super(new RankedHandCategoryResolver("2pair", 2, 2));
    }

    @Test // TODO: these should use data providers...
    public void HandIsTwoPair_first4() {
        HandCategory category = resolveHand("D4", "S4", "D3", "C3", "C5");

        assertEquals("Is two", "2pair", category.getName());
    }

    @Test // TODO: these should use data providers...
    public void HandIsNotTwoPair() {
        HandCategory category = resolveHand("D4", "S4", "C2", "C3", "C5");

        assertEquals("Is not two", null, category);
    }


}
