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
  private int categoryNumber = -1;
  protected Hand hand;

  private int rank = -1;
  private HandRankHistogram rankHistogram;

  protected HandCategory(String name) {
    this.name = name;
  }

  // Implements the Prototype pattern by supporting instance cloning. Customises the cloned instance before returning.
  // @return a copy of this instance of (the subclass of) HandCategory
  public HandCategory clone(int cn, Hand hand, int rank, HandRankHistogram rankHistogram) {
    HandCategory cat = clone();
    cat.categoryNumber = cn;
    cat.hand = hand;
    cat.rank = rank;
    cat.rankHistogram = rankHistogram;
    return cat;
  }

  // Implements the Prototype pattern by supporting instance cloning
  // @return a copy of this instance of (the subclass of) HandCategory
  protected abstract HandCategory clone();

  public int getRank() { return rank; }

  public String getName() { return name; }

  protected HandRankHistogram getRankHistogram() { return rankHistogram; }

  public int compareTo(HandCategory rhs) throws Exception {
    if (categoryNumber == rhs.categoryNumber)
      return compareEqualCategories(rhs);
    else
      return Integer.compare(categoryNumber, rhs.categoryNumber);
  }

  protected abstract int compareEqualCategories(HandCategory rhs) throws Exception;
}
