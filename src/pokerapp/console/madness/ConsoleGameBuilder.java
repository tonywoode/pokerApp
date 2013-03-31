package pokerapp.console.madness;

import pokerapp.ComputerPlayer;
import pokerapp.InteractivePlayer;
import pokerapp.skynet.EasyComputerPlayerStrategy;
import pokerapp.skynet.RandomNumberGenerator;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.utils.textformat.StringFormatter;

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
public class ConsoleGameBuilder {

  public static void main(String[] args) {
    try {
      ConsoleGameState game = new ConsoleGameBuilder().create();

      ConsoleGameModel model = new ConsoleGameModel();

      game.execute(model);

    } catch (FormatStringException e) {
      e.printStackTrace();
    } catch (IllegalFormatCodeException e) {
      e.printStackTrace();
    }

  }

  public ConsoleGameState create() throws FormatStringException, IllegalFormatCodeException {
    List<ConsoleGameState> states = new ArrayList<>();

    CompositeConsoleGameState singleTurn = createSingleTurn();

    RepeatedConsoleGameState playTurns = new RepeatedConsoleGameState(singleTurn, 3);

    states.add(new DisplayMessageGameState("Let's play poker!"));
    states.add(playTurns);
    states.add(new EvaluateGameState());
    states.add(new DisplayMessageGameState("Play again?"));


    return new CompositeConsoleGameState(states);
  }

  private CompositeConsoleGameState createSingleTurn() throws FormatStringException, IllegalFormatCodeException {
    // assume 3 computer players & 1 interactive player
    // TODO: this needs to be configurable
    StringFormatter sf = new StringFormatter();

    List<ConsoleGameState> states = new ArrayList<>();

    for (int iter = 0; iter < 3; ++iter)
      states.add(new ComputerPlayerPlayTurnGameState(new ComputerPlayer(sf.format("Player {0}", iter + 1), new EasyComputerPlayerStrategy(new RandomNumberGenerator()))));

    states.add(new InteractivePlayerPlayTurnGameState(new InteractivePlayer("IP")));

    return new CompositeConsoleGameState(states);
  }

}
