package tests.scorer.resolvers;

import org.junit.Test;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.StraightHandCategoryResolver;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Ari G
 * Date: 25/02/13
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
public class StraightHandScorerTestFixture extends HandScorerTestFixtureBase {
     //TODO: this is just a stub, need to understand the (elegant) class structure
    //TODO: could perhaps use Sam's permutator or variation thereof to populate test cases
    public StraightHandScorerTestFixture(){
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
    public void Hand_Is_Not_Straight() {
        HandCategory category = resolveHand("D3", "S9", "C2", "D4", "H6");

        assertEquals("Is straight", "straight", category.getName());
    }
}
