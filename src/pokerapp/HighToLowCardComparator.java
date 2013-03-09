package pokerapp;

import java.util.Comparator;

/**
 * Compares two cards and determines which one is higher based on the rank (ignores suit)
 * @author steve
 */
public class HighToLowCardComparator implements Comparator<Card> {
  @Override
  public int compare(Card lhs, Card rhs) {
    return Integer.compare(rhs.getRank(), lhs.getRank()); // ie, reverse order
  }

  public static final HighToLowCardComparator Default = new HighToLowCardComparator();
}
