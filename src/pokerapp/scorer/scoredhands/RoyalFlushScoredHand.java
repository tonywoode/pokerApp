package pokerapp.scorer.scoredhands;

import pokerapp.Card;
import pokerapp.Hand;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 09/03/13
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class RoyalFlushScoredHand extends StraightFlushScoredHand {

    public RoyalFlushScoredHand(int handNumber, Hand hand, int rank) {
        super(handNumber, hand, rank);
    }

    public RoyalFlushScoredHand(StraightFlushScoredHand hand) {
        this(hand.getHandNumber(), hand.getHand(), hand.getRank());
    }


    @Override
    public String getName() {
        return "Royal flush";
    }

    @Override
    public List<Card> getRelevantCards() {
        return hand.getSortedCards();
    }

}
