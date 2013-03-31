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
public class DisplayMessageGameState extends ConsoleGameState {
  private final String message;

  public DisplayMessageGameState(String message) {
    this.message = message;
  }

  @Override
  public void execute(ConsoleGameModel model) {
    getConsole().writeMessage(message);
  }
}
