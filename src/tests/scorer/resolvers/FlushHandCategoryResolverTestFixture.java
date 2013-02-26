package tests.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.FlushHandCategoryResolver;
import pokerapp.scorer.resolvers.RankedHandCategoryResolver;
import org.junit.*;
import pokerapp.utils.HandPermutationGenerator;

import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 26/02/13
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 */
public class FlushHandCategoryResolverTestFixture extends HandCategoryResolverTestFixtureBase {
    public FlushHandCategoryResolverTestFixture() {
        super(new FlushHandCategoryResolver());
    }

    @Test // TODO: these should use data providers...
    public void Simple_Flush() {
        HandCategory category = resolveHand("D4", "D5", "D6", "D7", "D9");

        assertEquals("Is flush", "flush", category.getName());
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

        Assert.assertFalse(category.getName().equals("flush"));
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
