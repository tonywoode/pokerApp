package tests.scorer;

import java.util.Iterator;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 * Describe whether the class uses/is part of a pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class IteratorExtensions<T> {

  public IterableAdapter<T> from(T[] items, int pos) {
    Iterator<T> iter = new ArrayIterator<T>(items);

    while (pos-- != 0)
      iter.next();

    return new IterableAdapter(iter);
  }
}
