package pokerapp.console;

import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.utils.textformat.StringFormatter;

import java.util.Scanner;

/**
 * Provides a default implementation of the Console interface.
 * It outputs to System.out and formats strings using an
 * injected StringFormatter.
 *
 * @author Steve
 */
public class StandardConsole implements Console {
  private final StringFormatter formatter;

  public StandardConsole(StringFormatter formatter) {
    this.formatter = formatter;
  }

  @Override
  public void writeMessage(String msg) {
    System.out.println(msg);
  }

  @Override
  public void writeMessage(String msg, Object... args) throws FormatStringException, IllegalFormatCodeException {
    writeMessage(formatter.format(msg, args));
  }

  @Override
  public String readString() {
    return readLine();
  }

  @Override
  public String readLine() {
    return new Scanner(System.in).nextLine();
  }

  @Override
  public int readInteger() {
    try {
      String line = readLine();
      return Integer.parseInt(line);
    } catch (NumberFormatException e) {
      // TODO: Ari wants to use the strategy pattern to display different types of messages, depending on a range of factors
      writeMessage("Try again... you moron!");
      // Sam suggested we use recursion here... nice!
      return readInteger();
    }
  }
}
