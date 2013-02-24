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

    // initialise
    for (int iter = 0; iter < MAX_RANKS; ++iter)
      ranks[iter] = 0;

    // Determine how many cards of each rank are in the hand
    for (Card card : hand)
      ++ranks[card.getRank() - 1];
  }

  // Determines how many ranks have the specified targetRank
  // @returns the number of ranks with the specified targetRank
  // TODO: the fn description & returns appear to repeat. This is presumably not what to do.
  public int getCount(int targetRank) {
    int count = 0;
    for (int rank : ranks)
      if (rank == targetRank)
        ++count;

    return count;
  }

  // Factory method to create an iterator which moves backwards through
  // the array that makes up the histogram
  // @returns a ReverseArrayIterator
  public ReverseArrayIterator iterator() {
    return new ReverseArrayIterator(ranks);
  }

  // Finds the highest rank with the given rankValue (i.e, the count - the # cards with that rank in the hand)
  // @param rankValue the rank count to look for
  // @returns the highest card's rank, even when there are multiple cards of the same rank
  // @throws Exception if there is no rankValue in the histogram
  public int getRankFromCount(int rankValue) throws Exception {
    for (int iter = MAX_RANKS - 1; iter >= 0; --iter)
      if (ranks[iter] == rankValue)
        return iter + 1;

    throw new Exception("rankValue does not exist");
  }

  // @returns boolean indicating whether the histogram is treating aces as being low
  //TODO: make code nicer
  public boolean isAcesLow() {
    return acesLow;
  }

  // Change the Aces Low flag
  // TODO: should this not be private? Are clients supposed to use this directly?
  public void setAcesLow(boolean acesLow) {
    this.acesLow = acesLow;
  }

  // Changes the histogram to treat Aces as being Low. Aces continue to be treated as High as well.
  // TODO: can we not have a single function that does this, depending on a boolean flag?
  public void lowAcesOn(){
      if(ranks[MAX_RANKS] != 0){
           ranks[1] = ranks[MAX_RANKS];
           ranks[MAX_RANKS] = 0;
           setAcesLow(true);
      }
  }

  // Changes the histogram to treat Aces as being High. Aces will no longer be treated as Low.
  public void lowAcesOff(){
      if(ranks[1] != 0){
          ranks[MAX_RANKS] = ranks[1];
          ranks[1] = 0;
          setAcesLow(false);
      }
  }
}
