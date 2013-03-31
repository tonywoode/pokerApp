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
public class RepeatedConsoleGameState extends ConsoleGameState {
  private final ConsoleGameState state;
  private final int repetitions;

  public RepeatedConsoleGameState(ConsoleGameState state, int repetitions) {
    this.state = state;
    this.repetitions = repetitions;
  }

  @Override
  public void execute(ConsoleGameModel model) {
    for (int iter = 0; iter < repetitions; ++iter)
      state.execute(model);
  }
}