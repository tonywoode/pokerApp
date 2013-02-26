package pokerapp;

import pokerapp.utils.ReverseArrayIterator;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 00:57
 *
 * Represents the statistical summary of the ranks of the cards in a hand. It determines how many cards of each rank are in the hand
 *
 * See [wiki page] for details. TODO: Ari was (maybe) going to write this key data structure up.
 *
 */
public class HandRankHistogram {

  // TODO: This, along with lots of other constants, are repeated throughout a range of different classes. We need to consolidate them in a single location.
  private static final int MAX_RANKS = 14;

  private final Hand hand;
  int[] ranks = new int[MAX_RANKS];
  private int rank;

  private boolean acesLow;

  public HandRankHistogram(Hand hand) {
    this.hand = hand;

    // initialise TODO: do we need to initialise?
    for (int iter = 0; iter < MAX_RANKS; ++iter)
      ranks[iter] = 0;

    // Determine how many cards of each rank are in the hand
    for (Card card : hand)
      ++ranks[card.getRank()-1];
  }

  /**
   * Determines how many cards in the hand have a specified rank
   * @param targetRank  the rank under evaluation
   * @return the number of cards in the hand of rank = targetRank
   */
  public int getCount(int targetRank) {
    int count = 0;
     for(int rank : ranks)
       if(rank == targetRank) ++count;
    return count;
  }

  /**
   *  Factory method to create an iterator which moves backwards through
   *  the array that makes up the histogram
   * @return a ReverseArrayIterator
   */
  
  public ReverseArrayIterator iterator() {
    return new ReverseArrayIterator(ranks);
  }

 /** Finds the highest rank of a given multiple numCards (i.e the number of cards with that rank in the hand)
  * if numCards = 3 it will return the rank of the triple in the hand
  * if there isn't a triple it throws an exception
  * @param numCards the multiple we are looking for in the hand
  * @return the highest rank of the multiple, even when there is more than one - only applies for pairs or singles.
  * @throws Exception if there is no multiple of numCards in the histogram
  */
  //TODO: straights need to be checked before this is called with numCounts = 1 which simply returns the high card
  public int getRankOfMultiple(int numCards) throws Exception {
    for (int iter = MAX_RANKS-1; iter >= 0; --iter)
      if (ranks[iter] == numCards)
        return iter+1;

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
      if(ranks[MAX_RANKS] != 0){
           ranks[1] = ranks[MAX_RANKS];
           ranks[MAX_RANKS] = 0;
           setAcesLow(true);
      }
  }

  /**
   *  Changes the histogram to treat Aces as being High. Aces will no longer be treated as Low.
   */
  public void lowAcesOff(){
      if(ranks[1] != 0){
          ranks[MAX_RANKS] = ranks[1];
          ranks[1] = 0;
          setAcesLow(false);
      }
  }
}
