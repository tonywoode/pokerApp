package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.Card;
import pokerapp.HandMatrix;
import pokerapp.HandRankHistogram;
import pokerapp.scorer.categories.StraightHandCategory;
import pokerapp.utils.Constants;

import java.util.ArrayList;

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
      HandRankHistogram handRankHistogram = new HandRankHistogram(hand);
    if (isStraight(handRankHistogram))
          return true;
    else {
          handRankHistogram.lowAcesOn();
          boolean retval = (isStraight(handRankHistogram));
          handRankHistogram.lowAcesOff();
          return  retval;
       }
  }

  private boolean isStraight(HandRankHistogram handRankHistogram) {
      return(handRankHistogram.toString().contains("11111"));
  }
}
