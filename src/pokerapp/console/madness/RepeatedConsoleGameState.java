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