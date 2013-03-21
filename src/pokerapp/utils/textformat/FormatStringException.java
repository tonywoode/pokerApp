package pokerapp.utils.textformat;

/**
 * <p>
 * Describes the error in the FormatString.
 * </p>
 * <p>
 * No pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class FormatStringException extends Exception {
  public FormatStringException(String msg, Object... args) throws FormatStringException, IllegalFormatCodeException {
    super(new StringFormatter().format(msg, args));
  }
}

