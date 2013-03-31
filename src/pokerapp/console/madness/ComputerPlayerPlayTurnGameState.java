package pokerapp.console.madness;

import pokerapp.ComputerPlayer;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

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
public class ComputerPlayerPlayTurnGameState extends ConsoleGameState {
  private final ComputerPlayer cp;

  public ComputerPlayerPlayTurnGameState(ComputerPlayer computerPlayer) {
    cp = computerPlayer;
  }

  @Override
  public void execute(ConsoleGameModel model) {
    try {
      getConsole().writeMessage("Computer Player {0} - Play Turn", cp.getPlayerName());
    } catch (FormatStringException e) {
      // TODO: fix
    } catch (IllegalFormatCodeException e) {
      // TODO: fix
    }
  }
}
