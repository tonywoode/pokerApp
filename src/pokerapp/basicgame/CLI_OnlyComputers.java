package pokerapp.basicgame;

import pokerapp.console.DriverOnlyComputers;

/**
 * User: ari
 * Date: 11/03/2013
 * Time: 14:11
 * Created with IntelliJ IDEA.
 */
public class CLI_OnlyComputers {
  public static void main(String[] args) {
    try {

      new DriverOnlyComputers().gameLoop();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
