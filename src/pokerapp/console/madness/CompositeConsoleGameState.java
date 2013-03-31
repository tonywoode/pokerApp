package pokerapp.console.madness;

import java.util.ArrayList;
import java.util.List;

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
