package pokerapp.utils.textformat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Provides a new (better?) approach to formatting strings,
 * inspired by C#'s string.format() method and Python's
 * string interpolation.
 * </p>
 * <p>
 * No patterns used.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class StringFormatter {

  private static int INDEX = 1, FORMAT = 2;

  //private static Pattern pattern = Pattern.compile("\\{(\\d)(:.*)*}");
  private static Pattern pattern = Pattern.compile("\\{(\\d+)(?::(.*))?}");

  public String format(String text, Object... args) throws FormatStringException, IllegalFormatCodeException {
    Matcher matcher = pattern.matcher(text);

    StringBuffer sb = new StringBuffer();

    while (matcher.find()) {
      String grp = matcher.group(INDEX);
      int index = Integer.parseInt(grp);

      if (index < 0 || index >= args.length)
        throw new FormatStringException("No such argument: {0} is out of bounds ({1})", index, args.length);

      /* TODO: Had to manually parse the format string, because
         I can't get the second capturing group in the regex
         to work properly   */
      String format = null;
      if (matcher.groupCount() == FORMAT + 1)
        format = matcher.group(FORMAT);
      else {
        String test = matcher.group(0);
        int pos = test.indexOf(':');
        if (pos != -1) {
          format = test.substring(pos + 1, test.length() - 1);
        }
      }


      String str;

      boolean requireFormatter = format != null;

      if (args[index] instanceof Formattable && format != null)
        str = ((Formattable) args[index]).format(format);
      else if (requireFormatter)
        throw new FormatStringException("Format string provided for a non-formattable object!");
      else
        str = args[index].toString();

      matcher.appendReplacement(sb, str);
    }

    matcher.appendTail(sb); // get any remaining text from the original input

    return sb.toString();
  }
}