package pokerapp.utils.textformat;

import java.util.HashMap;

/**
 * <p>
 * Represents a named format of a Value Object. The format
 * can have multiple names. The actual formatting of the
 * Value Object is delegated to a strategy object which
 * extends the FormatResolver abstract base class.
 * </p>
 * <p>
 * Uses the Strategy pattern to implement the actual
 * conversion of the Value Object to a string.
 * </p>
 * <p>
 * Names are separated by the | (pipe, or vertical bar) character.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class Format<T> {

  private HashMap<String, FormatResolver<T>> resolvers = new HashMap<>();

  /**
   * Construct a single format (textual representation provider) for a set of names. Note that
   * names are (currently) always converted to lower case.
   *
   * @param names    A vertical bar separated list of names for the format
   * @param resolver An format-specific 'resolver' which converts the Value Object to a string
   */
  public Format(String names, FormatResolver<T> resolver) {
    for (String name : names.split("\\|"))
      this.resolvers.put(name.toLowerCase(), resolver);
  }

  /**
   * @param object The instance of the value object to format
   * @param name   The name of the format to use
   * @return A string holding the textual representation of the value object, according to the named format
   */
  public String format(T object, String name) {
    if (resolvers.containsKey(name = name.toLowerCase()))
      return resolvers.get(name).resolve(object);
    else
      return null;
  }

}
