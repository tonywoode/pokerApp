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
public class FullHouseHandScorerTestFixture extends HandScorerTestFixtureBase {

    public FullHouseHandScorerTestFixture() throws IOException {
      //super(new RoyalFlushScorer(new StraightScorer(), new FlushScorer()));
      super(new HandScorerBuilder().create());
    }

    @Test
    public void Hand_Is_FullHouse() throws FileNotFoundException {
      ScoredHand hand = resolveHand("S9", "D9", "C9", "D2", "S2");

      assertEquals("Is Full House", "Full house", hand.getName());
    }

    @Test
    public void Hand_Is_FullHouse_Not_Threeofakind() throws FileNotFoundException {
        ScoredHand hand = resolveHand("S9", "D9", "C9", "D2", "S3");

        assertEquals("Is Three of a kind, not Full house", "Three of a kind", hand.getName());
    }

}
