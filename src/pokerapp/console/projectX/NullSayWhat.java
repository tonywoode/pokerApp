package pokerapp.console.projectX;

/**
 * <p>
 *   A null implementation of SayWhat, for those platforms
 *   which we do not have a working TTS engine.
 * </p>
 * <p>
 *   Implements the Null Object pattern.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class NullSayWhat extends SayWhat {
  @Override
  public void sayWhat(String message) {
    // empty implementation as we're not on a supported platform
  }
}
