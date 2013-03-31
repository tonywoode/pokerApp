package pokerapp.console.turns;

import pokerapp.Dealer;
import pokerapp.Deck;
import pokerapp.Player;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;

/**
 * Represents a single turn in a game of poker.
 *
 * @author Steve
 * @version 1
 */
public interface ConsolePlayerTurn {

  public void playTurn(Dealer dealer, Console console);

}
