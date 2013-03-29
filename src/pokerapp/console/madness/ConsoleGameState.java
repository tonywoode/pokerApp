package pokerapp.console.madness;

import pokerapp.console.Console;
import pokerapp.console.StandardConsole;
import pokerapp.utils.textformat.StringFormatter;

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
public abstract class ConsoleGameState {
  private final Console console = new StandardConsole(new StringFormatter());

  protected Console getConsole() { return console; }

  public abstract void execute(ConsoleGameModel model);

}
