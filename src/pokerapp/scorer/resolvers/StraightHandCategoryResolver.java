package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.categories.StraightHandCategory;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 01:58
 * To change this template use File | Settings | File Templates.
 */
public class StraightHandCategoryResolver extends HandCategoryResolver {

  public StraightHandCategoryResolver() {
    super(new StraightHandCategory("straight"));
  }

  @Override
  protected boolean matches(HandCategoryResolverRequest request) throws Exception {
    return isStraight(request.getHand());
  }

  private boolean isStraight(Hand hand) {
      HandRanks handRanks = new HandRanks(hand);
    if (isStraight(handRanks))
          return true;
    else {
          handRanks.lowAcesOn();
          boolean retval = (isStraight(handRanks));
          handRanks.lowAcesOff();
          return  retval;
       }
  }

  private boolean isStraight(HandRanks handRanks) {
      return(handRanks.toString().contains("11111"));
  }
}
