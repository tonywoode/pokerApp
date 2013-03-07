package tests.scorer.resolvers;

import org.junit.Test;
import pokerapp.Hand;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.FlushHandCategoryResolver;
import tests.scorer.resolvers.HandCategoryResolverTestFixtureBase.NullResolver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays + Ari
 * Date: 26/02/13
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 */
public class FlushHandCategoryResolverTestFixture extends HandCategoryResolverTestFixtureBase {
    public FlushHandCategoryResolverTestFixture() {
        super(new FlushHandCategoryResolver());
        getResolver().setNextScorer(null);
    }

    @Test // TODO: these should use data providers...
    public void Simple_Flush() {
        HandCategory category = resolveHand("D4", "D5", "D6", "D7", "D9");

        assert("flush".equals(category.getName()));
    }

    // permutation will need a way of passing hand resolver a hand rather than a string
//    @Test // TODO: these should use data providers...
//    public void Permutation_Flush() {
//
//        HandFactory testHandFactory = new HandFactory();
//        String[] testHandString = {"D4", "D5", "D6", "D7", "D9"};
//        try {
//            Hand testHand = testHandFactory.create(testHandString);
//            ArrayList<Hand> results = HandPermutationGenerator.permute(testHand);
//            for(Hand result : results) {
//                HandCategory category = resolveHand(result.);
//                assertEquals("Is flush", "flush", category.getName());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        HandCategory category = resolveHand("D4", "D5", "D6", "D7", "D9");
//
//        assertEquals("Is flush", "flush", category.getName());
//    }
//

    @Test // TODO: these should use data providers...
    public void HandIsNotFlush() {
        HandCategory category = resolveHand("D4", "D3", "D1", "D5", "C6");

        assertSame("Is flush", null, category);
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
