package pokerapp.utils.textformat;

/**
 * <p>
 * Enables a Value Object to describe the formatting
 * strategy for a particular format.
 * </p>
 * <p>
 * Implements the Strategy pattern.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public abstract class FormatResolver<T> {
  /**
   * Convert a Value Object to a string for a given type of format
   *
   * @param object The instance of the value object to format
   * @return A string holding the textual representation of the value object, according to the named format
   */
  public abstract String resolve(T object);
}
