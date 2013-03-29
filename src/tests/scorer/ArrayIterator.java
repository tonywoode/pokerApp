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
public class ArrayIterator<T> implements Iterator<T> {
  private final T[] array;
  private int current;

  public ArrayIterator(T[] array) {
    this.array = array;
    current = 0;
  }

  @Override
  public boolean hasNext() {
    return current < array.length;
  }

  @Override
  public T next() {
    return array[current++];
  }

  @Override
  public void remove() { }
}
