package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.scorer.categories.FlushHandCategory;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.Card;
import pokerapp.scorer.categories.StraightHandCategory;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 01:58
 * To change this template use File | Settings | File Templates.
 */
public class StraightHandCategoryResolver extends HandCategoryResolver {

    int RANK_ACE_HI = 14;
    int RANK_ACE_LO = 1;

  public StraightHandCategoryResolver() {
    super(new StraightHandCategory("straight"));
  }

  @Override
  protected boolean matches(HandCategoryResolverRequest request) throws Exception {
    return isStraight(request.getHand());
  }

  private boolean isStraight(Hand hand) {
    ArrayList<Card> sortedCards = hand.getSortedCards();

    if (isStraight(sortedCards)) return true;

    // handle the special case of Ace being low, iff we have an ace
    Card maybeAce = sortedCards.get(0);
    if (maybeAce.getRank() == RANK_ACE_HI) {
      sortedCards.remove(0);
      try {
        sortedCards.add(new Card(maybeAce.getSuit(),RANK_ACE_LO));
      } catch (Exception e) {
        // TODO: fix this; checked exceptions are horrific :)
      }
      if (isStraight(sortedCards)) return true;
    }

    return false;
  }

  private boolean isStraight(ArrayList<Card> sortedCards) {
    Card prevCard = sortedCards.get(0);
    int sequenceLength = 1;

    for (int iter = 1; iter < sortedCards.size(); ++iter) {
      Card currentCard = sortedCards.get(iter);

      if (currentCard.getRank() == prevCard.getRank() + 1)
        if (++sequenceLength == 5)
          return true;

      prevCard = currentCard;
    }
    return false;
  }
}
