package pokerapp.console.projectX;

/**
 *
 * Provides a platform-agnostic facade over OS native
 * Text-To-Speech engines.
 *
 * <p>
 *   Uses the facade pattern.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public abstract class SayWhat {
  public abstract void sayWhat(String message);
}
