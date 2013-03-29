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
public class PlayAgainGameState extends ConsoleGameState {
  @Override
  public void execute(ConsoleGameModel model) {
    boolean shouldQuit = false;

    if (shouldQuit)
      quit();
    else
      playAgain();
  }

  private void playAgain() {
    // stateMachine.reset();
  }

  private void quit() {
    // empty impl; once last state each, app will exit
  }
}
