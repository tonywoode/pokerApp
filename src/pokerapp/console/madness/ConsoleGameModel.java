package pokerapp.console.madness;

import pokerapp.Dealer;
import pokerapp.Players;

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
public class ConsoleGameModel {
  private Dealer dealer;
  private Players players;

  private int numTurns;
  private int numExchanges;
}
