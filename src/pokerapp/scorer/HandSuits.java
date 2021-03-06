package pokerapp.scorer;


import pokerapp.Card;
import pokerapp.Hand;

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

  public int[] suit_histogram = new int[Card.NUM_SUITS + 1];

/**
 * determines how many cards of each suit are in a hand
 * @param hand a hand of cards
 */
    //first ctor takes a hand
    public HandSuits(Hand hand){
      Hand hand1 = hand;

        // Determine how many cards of each suit are in the hand
        for(Card card: hand)
            ++suit_histogram[card.getSuit().getNumber()];

    }

   //second ctor takes a hand summary
    public HandSuits(HandGrid handGrid){

        for(int j = 1; j < HandRanks.HIST_SIZE; j++) {
            for(int i = 1; i < Card.NUM_SUITS + 1; i++) {
               suit_histogram[i] = suit_histogram[i] + handGrid.matrix[i][j];
            }
        }
    }

    public boolean hasCount(int count) {
      for (int iter = 1; iter <= Card.NUM_SUITS; ++iter)
        if (suit_histogram[iter] == count)
          return true;
      return false;
    }

}
