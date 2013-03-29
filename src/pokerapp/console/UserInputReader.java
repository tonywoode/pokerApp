package pokerapp.console;

import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

/**
 * <p>
 *   Abstracts the complexity of reading typed input
 *   from the interactive user.
 * </p>
 * <p>
 *   Implements the facade pattern.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class UserInputReader {
  private final Console console;

  public UserInputReader(Console console) {
    this.console = console;
  }

  public String askForText(String msg, Object... args) throws FormatStringException, IllegalFormatCodeException {
    console.writeMessage(msg, args);
    return console.readLine();
  }

  public int askForInteger(String msg, int min, int max) throws FormatStringException, IllegalFormatCodeException {
    console.writeMessage(msg, min, max);

    while (true) {
      try {

        int num = console.readInteger();

        if (num >= min && num <= max)
          return num;

        console.writeMessage("Please enter a number between {0} and {1}", min, max);

      } catch (NumberFormatException e) {
        console.writeMessage("Please enter a number between {0} and {1}", min, max);
      }
    }
  }

  public boolean requestBoolean(String msg) {
    console.writeMessage(msg);
    do {
      String response = console.readLine().toLowerCase();
      if (response.equals("yes") || response.equals("y"))
        return true;
      else if (response.equals("yes") || response.equals("y"))
        return false;

      console.writeMessage("Please enter yes or no.");

    } while (true);
  }
}