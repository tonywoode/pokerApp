package pokerapp.scorer.scorers;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scoredhands.StraightScoredHand;
import pokerapp.utils.Constants;

/**
 *
 * @author Steve
 * @author Ari
 *
 * checks if the hand is a straight and assigns a rank
 * the rank is the highest card in the straight
 */
public class StraightScorer extends HandScorer {
  //private static final int NUM_CARDS_IN_STRAIGHT = 5;

  protected ScoredHand resolveCore(Hand hand) {
    HandRanks rh = new HandRanks(hand);
    int rank = 0;

    // TODO: fix hardcoded "11111"; would like: "1".repeat(NUM_CARDS_IN_STRAIGHT)
    // addressed this by adding a new constant STRAIGHT_SIGNATURE, I know it's not ideal
    //TODO: Steve, why does the resolver continue once it has identified this is a straight?


    if(rh.toString().contains(Constants.STRAIGHT_SIGNATURE)) {
      for(Card c : hand){
        if(c.getRank() > rank){
          rank = c.getRank();
        }
      }
      return new StraightScoredHand(getHandNumber(), hand, rank);
    }
    else{
      char hi_ace_count = rh.toString().charAt(Constants.NUM_RANKS);
      StringBuilder builder_check_wheel = new StringBuilder(rh.toString());
      builder_check_wheel.setCharAt(1, hi_ace_count);
      String check_wheel = builder_check_wheel.toString();
      if (check_wheel.contains(Constants.STRAIGHT_SIGNATURE))
        return new StraightScoredHand(getHandNumber(),hand,rank );
      else return null;
    }
  }
}
