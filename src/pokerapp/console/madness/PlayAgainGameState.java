package pokerapp.console.madness;

/**
 * This is the beginning of a state-based approach
 * to implementing the console game.
 *
 * Eventually, I want to use the ideas here to
 * introduce one game loop to rule them all, even
 * the GUI!
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
