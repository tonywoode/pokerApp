package pokerapp.scorer.resolvers;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.scorer.categories.FlushHandCategory;
import pokerapp.utils.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 01:58
 * To change this template use File | Settings | File Templates.
 */
public class FlushHandCategoryResolver extends HandCategoryResolver {

  public FlushHandCategoryResolver() {
    super(new FlushHandCategory("flush"));
  }

  @Override
  protected boolean matches(HandCategoryResolverRequest request) throws Exception {
    return isFlush(request.getHand());
  }

  private boolean isFlush(Hand hand) {
    int[] suits = new int[Constants.MAX_SUITS];
    for (int iter = 0; iter < Constants.MAX_SUITS; ++iter)
      suits[iter] = 0;

    for (Card card : hand)
      ++suits[card.getSuit().getNumber() - 1];

    for (int iter = 0; iter < Constants.MAX_SUITS; ++iter)
      if (suits[iter] == Constants.FULL_DECK)
        return true;

    return false;
  }
}
