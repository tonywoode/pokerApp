package pokerapp.console;

import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

/**
 * The interface abstracts access to the console. The idea is
 * based on Michael's Feathers work on seams.
 *
 * Using this interface means we can easily mock the console
 * in unit tests and provide additional services, like string
 * formatting and logging, by using the decorator pattern.
 *
 * @author steve
 */
public interface Console {

  void writeMessage(String msg);
  void writeMessage(String msg, Object... args) throws FormatStringException, IllegalFormatCodeException;

  String readString();
  String readLine();

  int readInteger();

}
