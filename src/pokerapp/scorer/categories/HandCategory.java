package pokerapp.scorer.categories;


import pokerapp.Hand;
import pokerapp.HandRankHistogram;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 01:22
 * To change this template use File | Settings | File Templates.
 */
public abstract class HandCategory {
  private String name;
  private int categoryNumber;
  protected Hand hand;

  private int rank;

  protected int getRank() { return rank; }

  protected HandCategory(String name, int categoryNumber, Hand hand, int rank) {
    this.name = name;
    this.categoryNumber = categoryNumber;
    this.hand = hand;
    this.rank = rank;
  }

  public String getName() { return name; }

  public int compareTo(HandCategory rhs) throws Exception {
    if (categoryNumber == rhs.categoryNumber)
      return compareEqualCategories(rhs);
    else
      return compareTo(categoryNumber, rhs.categoryNumber);
  }

  protected abstract int compareEqualCategories(HandCategory rhs) throws Exception;

  protected int compareTo(int lhs, int rhs) {
    if (lhs == rhs)
      return 0;
    else
      return lhs < rhs ? -1 : 1;
  }

}
