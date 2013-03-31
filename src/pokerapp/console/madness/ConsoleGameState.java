package pokerapp.console.madness;

import pokerapp.console.Console;
import pokerapp.console.StandardConsole;
import pokerapp.utils.textformat.StringFormatter;

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
public abstract class ConsoleGameState {
  private final Console console = new StandardConsole(new StringFormatter());

  protected Console getConsole() { return console; }

  public abstract void execute(ConsoleGameModel model);

}
