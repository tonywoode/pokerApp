package pokerapp.scorer;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.utils.ReverseArrayIterator;

/**
 * @author Steve Faulmann
 * @author Ari Ghosh
 *         <p/>
 *         Represents the statistical summary of the rank_histogram of the cards in a hand.
 *         It determines how many cards of each rank are in the hand
 *         <p/>
 *         See [wiki page] for details.
 *         <p/>
 *         <p/>
 *         2013-03-06 (sdf):
 *         Simplified interface.
 *         Moved string representation to the toString method. << nice
 *         Removed aces low/high code
 */
public class HandRanks {
  public static final int HIST_SIZE = 15;
  int[] rank_histogram = new int[HIST_SIZE];

  //first ctor takes a hand
  public HandRanks(Hand hand) {
    // Determine how many cards of each rank are in the hand
    for (Card card : hand)
      ++rank_histogram[card.getRank().getNumber()];
  }

  //second ctor takes a hand summary
  public HandRanks(HandGrid handGrid) {

    for (int j = 1; j <= HIST_SIZE; j++) {
      for (int i = 1; i < Card.NUM_SUITS + 1; i++) {
        rank_histogram[j] = rank_histogram[j] + handGrid.matrix[i][j];
      }
    }
  }


  /**
   * Determines how many times a specified multiple appears in a hand
   *
   * @param targetMultiple the multiple e.g. 3 for three of a kind
   * @return the number of multiples in the hand e.g. 2 for two pairs
   */
  public int countMultiple(int targetMultiple) {
    int count = 0;
    for (int rank : rank_histogram)
      if (rank == targetMultiple) ++count;
    return count;
  }

  /**
   * Factory method to create an iterator which moves backwards through
   * the array that makes up the histogram
   *
   * @return a ReverseArrayIterator
   */

  public ReverseArrayIterator iterator() {
    return new ReverseArrayIterator(rank_histogram);
  }

  /**
   * Finds the highest rank of a given multiple numCards (i.e the number of cards with that rank in the hand)
   * if numCards = 3 it will return the rank of the triple in the hand
   * if there isn't a triple it throws an exception
   *
   * @param numCards the multiple we are looking for in the hand
   * @return the highest rank of the multiple, even when there is more than one - only applies for pairs or singles.
   * @throws Exception if there is no multiple of numCards in the histogram
   */

  public int getRankOfMultiple(int numCards) {
    for (int iter = Card.NUM_RANKS; iter >= Rank.DEUCE.getNumber(); --iter)
      if (rank_histogram[iter] == numCards)
        return iter;

    throw new IllegalArgumentException(new StringBuilder().append(numCards).append(" of a kind does not exist in hand").toString());
  }

  // @author Ari Ghosh
  // @author Steve Faulmann
  // SDF: moved body of code to this method.
  // AG:changed StringBuilder name to fit convention
  @Override
  public String toString() {
    StringBuilder buildRankCounts = new StringBuilder();
    for (int count_at_rank : rank_histogram) {
      buildRankCounts.append(count_at_rank);
    }
    return buildRankCounts.toString();
  }
}
