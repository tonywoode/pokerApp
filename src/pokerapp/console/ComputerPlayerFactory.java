package pokerapp.console;

/**
 * @author Ari
 * @version 1.0
 */
class ComputerPlayerFactory {

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


