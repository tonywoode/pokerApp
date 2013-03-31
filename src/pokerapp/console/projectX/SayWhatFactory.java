package pokerapp.console.projectX;

import org.apache.commons.lang3.SystemUtils;

/**
 * Provides a instance of the SayWhat type,
 * based on the underlying OS.
 *
 * We currently support Windows and Mac OS X.
 *
 * We're using Apache Commons Lang3 for
 * platform detection.
 *
 * Used by spring to automagically give clients
 * the correct SayWhat instance.
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
