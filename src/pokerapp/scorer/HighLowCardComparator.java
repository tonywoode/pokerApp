package pokerapp.scorer;

import pokerapp.Card;

import java.util.Comparator;

/**
 * Compares two cards to see which has a higher rank
 * @author Steve
 * @version 1.0
 */
public class HighLowCardComparator implements Comparator<Card> {
  @Override
  public int compare(Card lhs, Card rhs) {
    return Integer.compare(rhs.getRank(), lhs.getRank()); // ie, reverse order
  }
}
