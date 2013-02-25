package pokerapp;

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
    private static final int MAX_SUITS = 4;

    private final Hand hand;
    int[] suits = new int[MAX_SUITS];

    //1 = Clubs, 2 = Diamonds, 3 = Hearts, 4 = Spades
    //http://wiki.answers.com/Q/What_is_the_suit_order_in_a_deck_of_cards_for_poker

/**
 * determines how many cards of each suit are in a hand
 * @param hand a hand of cards
 */
    
    public HandSuitHistogram(Hand hand){
        this.hand = hand;

        //initialise  TODO: do we really need to initialise
        for(int iter = 0; iter <= MAX_SUITS; ++iter) {
            suits[iter] = 0;
        }

        // Determine how many cards of each suit are in the hand
        for(Card card: hand)
            ++suits[card.getSuit().getNumber()];

    }
    //TODO: move somewhere more appropriate e.g. the flush resolver
    private boolean isFlush(){
        int FLUSH_COUNT = 5;
        for(int iter = 1; iter <= MAX_SUITS; ++iter)
            if(suits[iter] == FLUSH_COUNT) return true;
        return false;
    }




}
