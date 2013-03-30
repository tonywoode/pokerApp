package pokerapp.console.projectX;

import org.apache.commons.lang3.SystemUtils;

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
public class SayWhatFactory {
  public SayWhat create() {
    if (SystemUtils.IS_OS_MAC_OSX)
      return new MacSayWhat("Vicki");
    else if (SystemUtils.IS_OS_WINDOWS)
      return new WindowsSayWhat("Fred");
    else
      return new NullSayWhat();
  }
}
