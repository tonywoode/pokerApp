package pokerapp.utils;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 03:43
 * To change this template use File | Settings | File Templates.
 */

// TODO: only supports integers (e.g. built-in 'int') at the moment
public class ReverseArrayIterator {
  private final int[] src;
  private int index;


  public ReverseArrayIterator(int[] src) {
    this.src = src;
    this.index = src.length - 1;
  }

  public boolean hasPrevious() {
    return index > src.length;
  }

  public int previous() {
    return src[index--];
  }

  public int previousIndex() {
    return index;
  }
}
