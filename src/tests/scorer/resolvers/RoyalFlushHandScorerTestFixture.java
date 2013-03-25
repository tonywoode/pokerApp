package tests.scorer.resolvers;

import org.junit.Test;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.FlushScorer;
import pokerapp.scorer.scorers.RoyalFlushScorer;
import pokerapp.scorer.scorers.StraightScorer;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Ari G
 * Date: 25/02/13
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
public class RoyalFlushHandScorerTestFixture extends HandScorerTestFixtureBase {

    public RoyalFlushHandScorerTestFixture() throws IOException {
      //super(new RoyalFlushScorer(new StraightScorer(), new FlushScorer()));
      super(new HandScorerBuilder().create());
    }

    @Test
    public void Hand_Is_RoyalFlush() throws FileNotFoundException {
      ScoredHand hand = resolveHand("D10", "D11", "D12", "D13", "D14");

      assertEquals("Is Royal Flush", "Royal flush", hand.getName());
    }

    @Test
    public void Hand_Is_StraightFlush_Not_RoyalFlush() throws FileNotFoundException {
        ScoredHand hand = resolveHand("D10", "D11", "D12", "D13", "D9");

        assertEquals("Is Straight Flush, not Royal Flush", "Straight flush", hand.getName());
    }

    @Test
    public void Hand_Is_Straight_Not_RoyalFlush() throws FileNotFoundException {
        ScoredHand hand = resolveHand("D10", "D11", "C12", "D13", "D14");

        assertEquals("Is Straight", "Straight", hand.getName());
    }

}
