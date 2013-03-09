package pokerapp.console;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:51
 * To change this template use File | Settings | File Templates.
 */
public interface IConsole {

    //TODO: this is to aid unit tests - a seam (Michael Feathers)
    //TODO: this manages interaction

  void writeMessage(String msg);
  void writeMessage(String msg, Object... args);

  String readString();
  String readLine();

  int readInteger();

}
