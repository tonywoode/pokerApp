package tests.scorer.resolvers;

import org.junit.Test;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;

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
public class StraightFlushHandScorerTestFixture extends HandScorerTestFixtureBase {

    public StraightFlushHandScorerTestFixture() throws IOException {
      //super(new RoyalFlushScorer(new StraightScorer(), new FlushScorer()));
      super(new HandScorerBuilder().create());
    }

    @Test
    public void Hand_Is_StraightFlush() throws FileNotFoundException {
      ScoredHand hand = resolveHand("D9", "D11", "D12", "D13", "D13");

      assertEquals("Is Straight Flush", "Straight flush", hand.getName());
    }

    @Test
    public void Hand_Is_StraightFlush_Not_Fourofakind() throws FileNotFoundException {
        ScoredHand hand = resolveHand("D10", "D11", "D12", "D13", "S9");

        assertEquals("Is Four of a kind, not Straight Flush", "Four of a kind", hand.getName());
    }

}
