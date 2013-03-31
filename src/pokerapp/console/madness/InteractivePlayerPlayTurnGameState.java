package pokerapp.console.madness;

import pokerapp.InteractivePlayer;
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
