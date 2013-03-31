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
public class EvaluateGameState extends ConsoleGameState {
  @Override
  public void execute(ConsoleGameModel model) {
    getConsole().writeMessage("Somebody won! But who?");

    // pick winner
    // display win message
  }
}
