package pokerapp.console.projectX;

import pokerapp.Suit;
import pokerapp.console.Console;
import pokerapp.console.projectX.SayWhat;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.utils.textformat.StringFormatter;

/**
 * @param //TODO:Parameter Description
 * @author Steve
 * @version 1.0
 * @return //TODO:Return Description
 * @throws //TODO:ExceptionType
 */
public class ProjectXConsole implements Console {
  private final Console inner;
  private final StringFormatter formatter;

  public ProjectXConsole(Console inner, StringFormatter formatter) {
    this.inner = inner;
    this.formatter = formatter;
  }

  public static String removeSuitEmoji(String msg, Object... args) {
    for (Suit suit : Suit.AllSuits) {
      msg = msg.replace("" + suit.getSymbol(), suit.getName());
    }

    return msg;
  }

  @Override
  public void writeMessage(String msg) {
    inner.writeMessage(msg);
    SayWhat.vickiSays(removeSuitEmoji(msg));
  }

  @Override
  public void writeMessage(String msg, Object... args) throws FormatStringException, IllegalFormatCodeException {
    msg = formatter.format(msg, args);
    inner.writeMessage(msg);
    SayWhat.vickiSays(removeSuitEmoji(msg));
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
