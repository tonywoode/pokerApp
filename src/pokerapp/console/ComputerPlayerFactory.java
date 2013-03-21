package pokerapp.console;

/**
 * @author Ari
 * @version 1.0
 */
class ComputerPlayerFactory {

  public final int HARD_COMPUTER = 3;
  public final int STANDARD_COMPUTER = 2;
  public final int EASY_COMPUTER = 1;

  public ComputerPlayer makeComputerPlayer(String playerName, int playerDifficulty) {

    switch (playerDifficulty) {

      case HARD_COMPUTER:
        return new HardComputerPlayer(playerName);

      case STANDARD_COMPUTER:
        return new StandardComputerPlayer(playerName);

      case EASY_COMPUTER:
        return new EasyComputerPlayer(playerName);

    }

   return null;

  }


}


