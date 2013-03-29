package pokerapp.utils;

/**
 * Provides a simple adapter over walking backwards through an array
 *
 * Only supports integers (e.g. built-in 'int') as Java does not support reified generic.
 *
 * @author Steve
 */
public class ReverseArrayIterator {
  private final int[] src;
  private int index;

  public ReverseArrayIterator(int[] src) {
    this.src = src;
    this.index = src.length - 1;
  }

  public boolean hasPrevious() {
    return index >= 0;
  }

  public int previous() {
    return src[index--];
  }

  public int previousIndex() {
    return index;
  }
}
