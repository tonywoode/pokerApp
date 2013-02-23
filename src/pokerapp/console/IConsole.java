package pokerapp.console;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:51
 * To change this template use File | Settings | File Templates.
 */
public interface IConsole {

  void writeMessage(String msg);

  String readString();

  int readInteger();

}
