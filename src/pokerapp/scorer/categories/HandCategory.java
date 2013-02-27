package pokerapp.scorer.categories;


import pokerapp.Hand;
import pokerapp.HandRankHistogram;
import lombok.Getter;


/**
 * Base class for hand categories which describe scoring hands
 * @author Steve
 * @version 1.0
 */
public abstract class HandCategory {
  @Getter  private String name;
  private int categoryNumber = -1;
  protected Hand hand;

  @Getter private int rank = -1;
  private HandRankHistogram rankHistogram;

  protected HandCategory(String name) {
    this.name = name;
  }

/**
 * Clones a hand category when passed info about a hand. 
 * Implements the Prototype pattern by supporting instance cloning. Customises the cloned instance before returning.
 * 
 * @param cn a number representing //TODO: what exactly?
 * @param hand category for holding a hand of cards
 * @param rank category for holding the rank of the hand
 * @param rankHistogram category for holding the histogram representing the position of each card in a hand
 * @return a copy of this instance of (the subclass of) HandCategory
 */
  
  public HandCategory clone(int cn, Hand hand, int rank, HandRankHistogram rankHistogram) {
    HandCategory cat = clone();
    cat.categoryNumber = cn;
    cat.hand = hand;
    cat.rank = rank;
    cat.rankHistogram = rankHistogram;
    return cat;
  }

/**
 *   Implements the Prototype pattern by supporting instance cloning
 *   @return a copy of this instance of (the subclass of) HandCategory TODO: no it doesn't - do you  mean its children do?
 */
  protected abstract HandCategory clone();

  protected HandRankHistogram getRankHistogram() { return rankHistogram; }

/**
 * Compares two hand categories, returns numerical result of the comparison  
 * @param rhs a hand category
 * @return a number representing the comparison
 * @throws Exception TODO: which exception?
 */
  public int compareTo(HandCategory rhs) throws Exception {
    if (categoryNumber == rhs.categoryNumber)
      return compareEqualCategories(rhs);
    else
      return Integer.compare(categoryNumber, rhs.categoryNumber);
  }

  
  protected abstract int compareEqualCategories(HandCategory rhs) throws Exception;
}
