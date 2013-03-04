package pokerapp.scorer;


import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.utils.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 24/02/13
 * Time: 18:14
 *
 * Stores frequency of suit in hand
 * Includes a method to check if flush (temporarily)
 */
public class HandSuits {

    private Hand hand = new Hand();
    public int[] suit_histogram = new int[Constants.NUM_SUITS + 1];

/**
 * determines how many cards of each suit are in a hand
 * @param hand a hand of cards
 */
    //first ctor takes a hand
    public HandSuits(Hand hand){
        this.hand = hand;

        // Determine how many cards of each suit are in the hand
        for(Card card: hand)
            ++suit_histogram[card.getSuit().getNumber()];

    }

   //second ctor takes a hand summary
    public HandSuits(HandGrid handGrid){

        for(int j = 1; j < Constants.NUM_RANKS + 1; j++) {
            for(int i = 1; i < Constants.NUM_SUITS + 1; i++) {
               suit_histogram[i] = suit_histogram[i] + handGrid.matrix[i][j];
            }
        }
    }

    //TODO: move somewhere more appropriate e.g. the flush resolver
    private boolean isFlush(){

        for(int iter = 1; iter <= Constants.NUM_SUITS; ++iter)
            if(suit_histogram[iter] == Constants.HAND_SIZE) return true;
        return false;
    }

}
