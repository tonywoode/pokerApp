package pokerapp.console;

/**
 * @author steve
 * this class manages interaction to aid unit tests - a seam
 * (Michael Feathers)
 */
public interface IConsole {

  void writeMessage(String msg);
  void writeMessage(String msg, Object... args);

  String readString();
  String readLine();

  int readInteger();

}
