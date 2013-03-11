package pokerapp.console;

/**
 * @author Ari
 * Date: 11/03/2013
 * Time: 10:54
 * Created with IntelliJ IDEA.
 */
public  class ComputerPlayerFactory {

  public ComputerPlayer makeComputerPlayer(String playerName, int playerDifficulty) {

    switch (playerDifficulty) {

      case 3:
        return new HardComputerPlayer(playerName);

      case 2:
        return new StandardComputerPlayer(playerName);

      case 1:
        return new EasyComputerPlayer(playerName);

    }

   return null;

  }


}


