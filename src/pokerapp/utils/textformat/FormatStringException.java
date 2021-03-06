package pokerapp.utils.textformat;

/**
 * <p>
 * Describes the error in the FormatString.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class FormatStringException extends IllegalArgumentException {
  public FormatStringException(String msg, Object... args) throws FormatStringException, IllegalFormatCodeException {
    super(new StringFormatter().format(msg, args));
  }
}

