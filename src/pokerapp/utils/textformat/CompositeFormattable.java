package pokerapp.utils.textformat;

import java.util.HashMap;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 * Implements the Builder pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class CompositeFormattable<T> {
  HashMap<String, FormattableResolver<T>> resolvers = new HashMap<>();

  public CompositeFormattable<T> add(String names, FormattableResolver<T> resolver) {
    for (String name : names.split("|"))
      this.resolvers.put(name.toLowerCase(), resolver);
    return this;
  }

  public String format(T instance, String format) throws FormatStringException, IllegalFormatCodeException {
    StringBuilder sb = new StringBuilder();
    for (String part : format.split(";")) {
      String[] p = part.split("=");
      String property = p[0],
          fmt = p[1];

      sb.append(formatProperty(instance, property, fmt));

    }
    return sb.toString();
  }

  private String formatProperty(T instance, String property, String fmt) throws FormatStringException,
      IllegalFormatCodeException {
    return resolvers.get(property).resolve(instance).format(fmt);
  }
}
