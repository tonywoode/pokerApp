package pokerapp.console.madness;

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
public class EvaluateGameState extends ConsoleGameState {
  @Override
  public void execute(ConsoleGameModel model) {
    getConsole().writeMessage("Somebody won! But who?");

    // pick winner
    // display win message
  }
}
