package pokerapp.console.projectX;

import lombok.AllArgsConstructor;
import pokerapp.Suit;
import pokerapp.console.Console;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.utils.textformat.StringFormatter;

/**
 * @author Steve
 * @version 1.0
 */
@AllArgsConstructor
public class ProjectXConsole implements Console {
  private final SayWhat sayWhat;
  private final Console inner;
  private final StringFormatter formatter;

  public static String removeSuitEmoji(String msg, Object... args) {
    for (Suit suit : Suit.AllSuits) {
      msg = msg.replace("" + suit.getSymbol(), suit.getName());
    }

    return msg;
  }

  public static String removeAsterisk(String msg, Object... args) {
    msg = msg.replace("*", "");
    return msg;
  }

  public static String removeDot(String msg, Object... args) {
    msg = msg.replace(".", "");
    return msg;
  }

  @Override
  public void writeMessage(String msg) {
    inner.writeMessage(msg);
    sayWhat.sayWhat(removeDot(removeAsterisk(removeSuitEmoji(msg))));
  }

  @Override
  public void writeMessage(String msg, Object... args) throws FormatStringException, IllegalFormatCodeException {
    msg = formatter.format(msg, args);
    inner.writeMessage(msg);
    sayWhat.sayWhat(removeDot(removeAsterisk(removeSuitEmoji(msg))));
  }

  @Override
  public String readString() {
    return inner.readString();
  }

  @Override
  public String readLine() {
    return inner.readLine();
  }

  @Override
  public int readInteger() {
    return inner.readInteger();
  }
}
