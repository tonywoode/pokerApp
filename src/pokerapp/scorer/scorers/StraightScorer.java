package pokerapp.scorer.scorers;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scoredhands.StraightScoredHand;

/**
 * @author Steve
 * @author Ari
 *         <p/>
 *         checks if the hand is a straight and assigns a rank
 *         the rank is the highest card in the straight
 */
public class StraightScorer extends HandScorer {

  public static final String LOW_STRAIGHT_SIGNATURE = "11111";
  public static final String HIGH_STRAIGHT_SIGNATURE = "1111000000001";

  protected ScoredHand resolveCore(Hand hand) {
    HandRanks rh = new HandRanks(hand);
    Rank rank = Rank.DEUCE;

    if (rh.toString().contains(LOW_STRAIGHT_SIGNATURE) ||
        rh.toString().contains(HIGH_STRAIGHT_SIGNATURE)) {
      for (Card c : hand) {
        if (c.getRank().beats(rank))
          rank = c.getRank();
      }
      return new StraightScoredHand(getHandNumber(), hand, rank);
    } else return null;
  }
}
