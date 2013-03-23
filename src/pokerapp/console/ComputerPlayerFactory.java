package pokerapp.console;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * @author Ari
 * @author Steve
 * @version 1.1
 */
class ComputerPlayerFactory {

  public final int HARD_COMPUTER = 3;
  public final int STANDARD_COMPUTER = 2;
  public final int EASY_COMPUTER = 1;

  public ComputerPlayer makeComputerPlayer(String playerName, int playerDifficulty) {
    ComputerPlayerStrategy strategy = chooseStrategy(playerDifficulty);
    return new ComputerPlayer(playerName, strategy);
  }

  private ComputerPlayerStrategy chooseStrategy(int playerDifficulty) {
    switch (playerDifficulty) {
      case HARD_COMPUTER:
        return new HardComputerPlayerStrategy();
      case STANDARD_COMPUTER:
        return new StandardComputerPlayerStrategy();
      case EASY_COMPUTER:
        return new HardComputerPlayerStrategy();
      default:
        throw new IllegalArgumentException("Unknown player difficulty setting");
    }
  }


}


