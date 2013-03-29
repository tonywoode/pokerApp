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
