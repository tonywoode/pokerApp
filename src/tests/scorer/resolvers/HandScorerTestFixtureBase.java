package tests.scorer.resolvers;

import org.junit.Before;

import static org.junit.Assert.*;

import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.HandCategoryResolver;
import pokerapp.scorer.resolvers.HandCategoryResolverRequest;


/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 18:51
 * To change this template use File | Settings | File Templates.
 */
public class HandScorerTestFixtureBase {

  private HandCategoryResolver resolver;
  private HandCategoryResolver nullResolver;
  private HandFactory handFactory = new HandFactory();

  protected HandScorerTestFixtureBase(HandCategoryResolver resolver) {
    this.resolver = resolver;
  }

  protected HandCategoryResolver getResolver() {
    return resolver;
  }

  private class NullResolver extends HandCategoryResolver {
    private NullResolver() { super(null); }

    @Override
    public HandCategory resolve(HandCategoryResolverRequest request) throws Exception { return null; }

    @Override
    protected boolean matches(HandCategoryResolverRequest request) throws Exception { return false; }
  }

  @Before
  public void Setup() {
    //nullResolver = mock(HandCategoryResolver.class);

    //when(nullResolver.resolve(anyObject()).returnThis(null);

    //getResolver().setNextScorer(nullResolver);

    getResolver().setNextScorer(new NullResolver());
  }

  protected Hand createHand(String... cards) {
    try {
      return handFactory.create(cards);
    } catch (Exception e) {
      return null;
    }
  }

  protected HandCategory resolveHand(String... cards) {
    return getResolver().resolve(createHand(cards));
  }

  protected Hand pickWinner(Hand lhs, Hand rhs) {
    HandCategory lhsCat = getResolver().resolve(lhs),
        rhsCat = getResolver().resolve(rhs);

    int result = 0;
    try {
      result = lhsCat.compareTo(rhsCat);
    } catch (Exception e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

    // TODO: clients should not have to do this
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
