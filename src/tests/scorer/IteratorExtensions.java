package tests.scorer;

import java.util.Iterator;

/**
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
