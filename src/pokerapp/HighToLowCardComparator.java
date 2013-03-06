package pokerapp;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 02:57
 * To change this template use File | Settings | File Templates.
 */
public class HighToLowCardComparator implements Comparator<Card> {
  @Override
  public int compare(Card lhs, Card rhs) {
    return Integer.compare(rhs.getRank(), lhs.getRank()); // ie, reverse order
  }

  public static final HighToLowCardComparator Default = new HighToLowCardComparator();
}
