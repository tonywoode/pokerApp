package pokerapp.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author steve
 *         Date: 06/03/13
 *         Time: 00:45
 *         <p/>
 *         Provides a fluent interface over the logical concept
 *         of multiple, chained comparisons.
 *         <p/>
 *         For example, first pick the higher rank from two pairs.
 *         Then, if they are the same, pick the higher rank from
 *         the highest kicker, and so on, until all the kickers
 *         have been examined.
 *         <p/>
 *         The implementation uses the standard Comparable<T>
 *         interface from the JDK. It is expected that clients
 *         which wish to participate in a Comparator sequence
 *         implement the Comparable<T> interface.
 *         <p/>
 *         Sample code:
 *         ***********
 *         <p/>
 *         return Comparator
 *         .begin(highPair, rhs.highPair)
 *         .next(lowPair, rhs.lowPair)
 *         .next(spares, rhs.spares)
 *         .compare();
 *         <p/>
 *         The use of the Comparable<T> interface allows for
 *         (relatively) lazy evaluation of redundant comparisons.
 *         <p/>
 *         Possible improvements: [tbd]
 *         <p/>
 *         Patterns: [tbd]
 */
public class Comparator {
  //  tracks the last comparison state;
  //  TODO: what happens if no comparisons have been made?
  int c = 0; //needs to start not equal


  /**
   * Initialises a new Comparator object. Integer overloads
   * required, because primitives cannot be used as generic
   * parameters
   *
   * @param lhs the value on the left hand side of the comparison
   * @param rhs the value on the right hand side of the comparison
   * @return a next Comparator object, containing the result of the comparison
   */
  public static Comparator begin(int lhs, int rhs) {
    return new Comparator().next(lhs, rhs);
  }

  /**
   * Initialises a new Comparator object. Uses Comparable<T>
   * for all objects (that implement the interface).
   *
   * @param lhs the value on the left hand side of the comparison
   * @param rhs the value on the right hand side of the comparison
   * @return a next Comparator object, containing the result of the comparison
   */
  public static <T> Comparator begin(Comparable<T> lhs, T rhs) {
    return new Comparator().next(lhs, rhs);
  }

  /**
   * Adds another comparison to the current Comparator object. This int
   * overload is required because primitives cannot be used as
   * parameters for generic types
   *
   * @param lhs the value on the left hand side of the comparison
   * @param rhs the value on the right hand side of the comparison
   * @return the same Comparator object, containing the result of the comparison
   */
  public Comparator next(int lhs, int rhs) {
    if (c == 0)
      c = Integer.compare(lhs, rhs);
    return this;
  }

  /**
   * Adds another comparison to the current Comparator object. This
   * Comparable<T> overload is used by all object instances
   *
   * @param lhs the value on the left hand side of the comparison
   * @param rhs the value on the right hand side of the comparison
   * @return the same Comparator object, containing the result of the comparison
   */
  public <T> Comparator next(Comparable<T> lhs, T rhs) {
    if (c == 0)
      c = lhs.compareTo(rhs);
    return this;
  }

  /**
   * @return the current status of the comparison sequence
   */
  public int compare() {
    return c;
  }
}
