package pokerapp;


import pokerapp.utils.ReverseArrayIterator;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 00:57
 * To change this template use File | Settings | File Templates.
 */
public class HandRankHistogram {

  private static final int MAX_RANKS = 14;

  private final Hand hand;
  int[] ranks = new int[MAX_RANKS];
  private int rank;

  public HandRankHistogram(Hand hand) {
    this.hand = hand;

    // initialise
    for (int iter = 0; iter < MAX_RANKS; ++iter)
      ranks[iter] = 0;

    for (Card card : hand)
      ++ranks[card.getRank() - 1];
  }

  public int getCount(int targetRank) {
    int count = 0;
    for (int rank : ranks)
      if (rank == targetRank)
        ++count;

    return count;
  }

  // TODO: it's not clear that there is actually a 'rank' for all categories; cf. two pairs == two ranks!
  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  // TODO: add error handling. What happens if 'target' is not found?
  public void setRankFromCount(int target) {
    for (int iter = 0; iter < MAX_RANKS; ++iter)
      if (ranks[iter] == target)
        setRank(iter + 1);
  }

  public ReverseArrayIterator iterator() {
    return new ReverseArrayIterator(ranks);
  }

  public int findRankWithCount(int target) throws Exception {
    for (int iter = 0; iter < MAX_RANKS; ++iter)
      if (ranks[iter] == target)
        return iter + 1;

    throw new Exception("No such count");
  }
}
