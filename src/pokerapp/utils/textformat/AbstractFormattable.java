package pokerapp.utils.textformat;

/**
 * <p>
 * Provides a default, generically-typed implementation of
 * the Formattable interface.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public abstract class AbstractFormattable<T> implements Formattable {

  /**
   * @return The Formats instance for this Value Type
   */
  @Override
  public abstract Formats getFormats();

  /**
   * @param format The name of the format to use when rendering the Value Object as text
   * @return A string holding the textual representation of the value object, according to the named format
   * @throws IllegalFormatCodeException
   * @throws FormatStringException
   */
  @Override
  public String format(String format) throws IllegalFormatCodeException, FormatStringException {
    return getFormats().format((T) this, format);
  }
}
