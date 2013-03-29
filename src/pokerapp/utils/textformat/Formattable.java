package pokerapp.utils.textformat;

/**
 * <p>
 * Provides a generic interface through which Value Objects can
 * be formatted
 * </p>
 * <p>
 * Formats are implemented using the Strategy pattern. This is
 * new in v2.
 * </p>
 *
 * @author Steve
 * @version 3
 */
public interface Formattable<T> {
  Formats<T> getFormats();

  String format(String format) throws IllegalFormatCodeException, FormatStringException;
}
