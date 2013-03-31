package tests.scorer;

import java.util.Iterator;

/**
 *
 * @author Steve
 * @version 1
 */
public class IterableAdapter<T> implements Iterable<T> {
  private final Iterator<T> iter;

  public IterableAdapter(Iterator<T> iter) {
    this.iter = iter;
  }

  @Override
  public Iterator<T> iterator() {
    return iter;
  }
}
