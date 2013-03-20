package pokerapp.utils.textformat;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Contains all of the Format objects for a given Value Type.
 * Clients treat it as a composite (cf. composite pattern) and
 * simply call the format method.
 * </p>
 * <p>
 * Implements the Composite Pattern. (NB: does it really? It doesn't
 * actually implement the Format interface...).
 * </p>
 * <p>
 * It also implements the Chain of Responsibility pattern, by
 * delegating to each of the contained Format objects. It's
 * actually a variation of CoR, because it uses an extrinsic
 * linked list (as opposed to the HandScorer CoR, which uses
 * an intrusive linked list).
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class Formats<T> {
  public List<Format<T>> formats = new ArrayList<Format<T>>();

  /**
   * Constructs a Formats<T> object with a fixed number of (ordered) Format<T> objects.
   *
   * @param formats a variable-length array of Format<T> objects.
   */
  public Formats(Format<T>... formats) {
    for (Format<T> format : formats)
      this.formats.add(format);
  }

  /**
   * @param object The instance of the value object to format
   * @param name   The name of the format to use
   * @return A string holding the textual representation of the value object, according to the named format
   * @throws FormatStringException
   * @throws IllegalFormatCodeException
   */
  public String format(T object, String name) throws FormatStringException, IllegalFormatCodeException {
    String result;
    for (Format<T> format : formats) {
      result = format.format(object, name);
      if (result != null)
        return result;
    }
    throw new IllegalFormatCodeException(name, object.getClass());
  }
}
