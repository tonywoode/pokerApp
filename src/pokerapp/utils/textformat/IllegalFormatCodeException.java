package pokerapp.utils.textformat;

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
public class IllegalFormatCodeException extends IllegalArgumentException {
  private static String Message = "Type {0} does not understand the format: '{1}'";

  public IllegalFormatCodeException(String format, Class type) throws FormatStringException,
      IllegalFormatCodeException {
    super(new StringFormatter().format(Message, format, type));
  }
}
