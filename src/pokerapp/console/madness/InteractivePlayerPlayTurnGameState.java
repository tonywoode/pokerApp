package pokerapp.console.madness;

import pokerapp.InteractivePlayer;
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
public class InteractivePlayerPlayTurnGameState extends ConsoleGameState {
  private final InteractivePlayer player;

  public InteractivePlayerPlayTurnGameState(InteractivePlayer player) {
    this.player = player;
  }

  @Override
  public void execute(ConsoleGameModel model) {
    try {
      getConsole().writeMessage("Interactive Player {0} - Play Turn", player.getPlayerName());
    } catch (FormatStringException e) {
      // TODO: fix
    } catch (IllegalFormatCodeException e) {
      // TODO: fix
    }
  }
}
