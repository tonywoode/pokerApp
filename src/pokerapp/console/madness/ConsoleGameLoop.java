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
