package tests.scorer.resolvers;

import org.junit.Before;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.HandScorer;

import static org.junit.Assert.assertSame;


/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 18:51
 * To change this template use File | Settings | File Templates.
 */
public class HandScorerTestFixtureBase {

  private HandScorer scorer;
  private HandScorer nullScorer;
  private HandFactory handFactory = new HandFactory();

  protected HandScorerTestFixtureBase(HandScorer scorer) {
    this.scorer = scorer;
  }

  protected HandScorer getScorer() {
    return scorer;
  }

  private class NullScorer extends HandScorer {
    public ScoredHand score(Hand hand) {
      return null;
    }

    protected ScoredHand resolveCore(Hand hand) {
      return null;
    }
  }

  @Before
  public void Setup() {
    //nullResolver = mock(HandCategoryResolver.class);

    //when(nullResolver.resolve(anyObject()).returnThis(null);

    //getResolver().setNextScorer(nullResolver);

      if (getScorer().isEndOfChain())
        getScorer().setNextScorer(new NullScorer());
  }

  protected Hand createHand(String... cards) {
    return handFactory.create(cards);
  }

  protected ScoredHand resolveHand(String... cards) {
    return getScorer().score(createHand(cards));
  }

  protected Hand pickWinner(Hand lhs, Hand rhs) {
    ScoredHand lhsHand = getScorer().score(lhs),
        rhsHand = getScorer().score(rhs);

    int result = lhsHand.compareTo(rhsHand);

    if (result == 0)
      return null;
    else if (result < 0)
      return rhs;
    else
      return lhs;
  }

  protected void verifyWinner(Hand lhs, Hand rhs, Hand expectedWinner) {
    Hand winner = pickWinner(lhs, rhs);

    assertSame("Winner", expectedWinner, winner);
  }
}
