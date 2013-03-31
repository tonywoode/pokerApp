package pokerapp.utils.textformat;

/**
 * <p>
 *   Returns a Formattable from an arbitrary type. Would be
 *   much nicer with lambdas.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public interface FormattableResolver<T> {
  public Formattable resolve(T instance);
}
