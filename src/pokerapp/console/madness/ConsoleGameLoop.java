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
public class ConsoleGameLoop {

  public ConsoleGameState create() {

    List<ConsoleGameState> states = new ArrayList<>();

    initialiseGame(states);

    ConsoleGameState turn = createGameTurn();

    states.add(new RepeatedConsoleGameState(turn, 3));

    states.add(new EvaluateGameState());
    states.add(new PlayAgainGameState());


    return new CompositeConsoleGameState(states);
  }

  private void initialiseGame(List<ConsoleGameState> states) {

  }

  private ConsoleGameState createGameTurn() {
    return new DisplayMessageGameState("Play a turn!");
  }

}
