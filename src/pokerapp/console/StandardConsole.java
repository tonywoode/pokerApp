package pokerapp.console;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 09/03/13
 * Time: 19:39
 * To change this template use File | Settings | File Templates.
 */
public class StandardConsole implements IConsole {
  @Override
  public void writeMessage(String msg) {
    System.out.println(msg);
  }

  @Override
  public void writeMessage(String msg, Object... args) {
    writeMessage(String.format(msg, args));
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
    return Integer.getInteger(readLine());
  }
}
