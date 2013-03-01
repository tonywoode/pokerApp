package pokerapp;


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
public class HandSuitHistogram {

    private final Hand hand;
    int[] suits = new int[Constants.MAX_SUITS];

/**
 * determines how many cards of each suit are in a hand
 * @param hand a hand of cards
 */
    
    public HandSuitHistogram(Hand hand){
        this.hand = hand;

        // Determine how many cards of each suit are in the hand
        for(Card card: hand)
            ++suits[card.getSuit().getNumber()];

    }
    //TODO: move somewhere more appropriate e.g. the flush resolver
    private boolean isFlush(){

        for(int iter = 1; iter <= Constants.MAX_SUITS; ++iter)
            if(suits[iter] == Constants.FULL_DECK) return true;
        return false;
    }

}
