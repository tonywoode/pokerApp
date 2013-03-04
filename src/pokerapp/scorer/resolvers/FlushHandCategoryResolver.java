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
    int[] suits = new int[Constants.NUM_SUITS];
    for (int iter = 0; iter < Constants.NUM_SUITS; ++iter)
      suits[iter] = 0;

    for (Card card : hand)
      ++suits[card.getSuit().getNumber() - 1];

    for (int iter = 0; iter < Constants.NUM_SUITS; ++iter)
      if (suits[iter] == Constants.HAND_SIZE)
        return true;

    return false;
  }
}
