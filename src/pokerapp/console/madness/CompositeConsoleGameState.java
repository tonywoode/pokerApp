package pokerapp.console.madness;

import java.util.ArrayList;
import java.util.List;

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
public class CompositeConsoleGameState extends ConsoleGameState {
  private final List<ConsoleGameState> states;

  public CompositeConsoleGameState(List<ConsoleGameState> states) {
    this.states = states;
  }

  @Override
  public void execute(ConsoleGameModel model) {
    for (ConsoleGameState state : states)
      state.execute(model);
  }
}
