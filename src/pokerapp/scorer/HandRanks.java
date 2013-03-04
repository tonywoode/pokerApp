package pokerapp.scorer;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.utils.Constants;
import pokerapp.utils.ReverseArrayIterator;

/**
 * Created with IntelliJ IDEA.
 * User: steve  + Ari
 * Date: 22/02/13
 * Time: 00:57
 *
 * Represents the statistical summary of the rank_histogram of the cards in a hand. It determines how many cards of each rank are in the hand
 *
 * See [wiki page] for details. TODO: Ari was (maybe) going to write this key data structure up. & write a test
 *
 */
public class HandRanks {


  int[] rank_histogram = new int[Constants.NUM_RANKS];
  private boolean acesLow;

  public HandRanks(Hand hand) {
    // Determine how many cards of each rank are in the hand
    for (Card card : hand)
      ++rank_histogram[card.getRank()];
  }

  public HandRanks(HandGrid handGrid){

    for(int j = 1; j < Constants.NUM_RANKS + 1; j++) {
        for(int i = 1; i < Constants.NUM_SUITS + 1; i++) {
            rank_histogram[j] = rank_histogram[j] + handGrid.matrix[i][j];
        }
    }
  }


    /**
   * Determines how many times a specified multiple appears in a hand
   * @param targetMultiple  the multiple e.g. 3 for three of a kind
   * @return the number of multiples in the hand e.g. 2 for two pairs
   */
  public int countMultiple(int targetMultiple) {
    int count = 0;
     for(int rank : rank_histogram)
       if(rank == targetMultiple) ++count;
    return count;
  }

  /**
   *  Factory method to create an iterator which moves backwards through
   *  the array that makes up the histogram
   * @return a ReverseArrayIterator
   */
  
  public ReverseArrayIterator iterator() {
    return new ReverseArrayIterator(rank_histogram);
  }

 /** Finds the highest rank of a given multiple numCards (i.e the number of cards with that rank in the hand)
  * if numCards = 3 it will return the rank of the triple in the hand
  * if there isn't a triple it throws an exception
  * @param numCards the multiple we are looking for in the hand
  * @return the highest rank of the multiple, even when there is more than one - only applies for pairs or singles.
  * @throws Exception if there is no multiple of numCards in the histogram
  */

  public int getRankOfMultiple(int numCards) throws Exception {
    for (int iter = Constants.NUM_RANKS -1; iter >= 0; --iter)
      if (rank_histogram[iter] == numCards)
        return iter;

    throw new Exception(new StringBuilder().append(numCards).append(" of a kind does not exist in hand").toString());
  }

  /**
   * @return boolean indicating whether the histogram is treating aces as being low
   * 
   */
  //TODO: make code nicer
  public boolean isAcesLow() {
    return acesLow;
  }

  /**
   * Change the Aces Low flag
   * @param acesLow
   */
  // TODO: should this not be private? Are clients supposed to use this directly?
  public void setAcesLow(boolean acesLow) {
    this.acesLow = acesLow;
  }

  /**
   * Changes the histogram to treat Aces as being Low. Aces continue to be treated as High as well.
   */
  // TODO: can we not have a single function that does this, depending on a boolean flag?
  public void lowAcesOn(){
      if(rank_histogram[Constants.NUM_RANKS] != 0){
           rank_histogram[1] = rank_histogram[Constants.NUM_RANKS];
           rank_histogram[Constants.NUM_RANKS] = 0;
           setAcesLow(true);
      }
  }
  /**
   *  Changes the histogram to treat Aces as being High. Aces will no longer be treated as Low.
   */
  public void lowAcesOff(){
      if(rank_histogram[1] != 0){
          rank_histogram[Constants.NUM_RANKS] = rank_histogram[1];
          rank_histogram[1] = 0;
          setAcesLow(false);
      }
  }
}
