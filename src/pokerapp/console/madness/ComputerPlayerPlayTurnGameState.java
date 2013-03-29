package pokerapp.console.madness;

import pokerapp.ComputerPlayer;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

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
