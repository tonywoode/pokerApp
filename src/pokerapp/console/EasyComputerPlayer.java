package pokerapp.console;

import pokerapp.Card;
import pokerapp.Rank;
import pokerapp.utils.Constants;

import java.util.Random;

/**
 * @author ari
 *         Date: 11/03/2013
 *         Time: 01:55
 *         Created with IntelliJ IDEA.
 */
public class EasyComputerPlayer extends ComputerPlayer {

  public EasyComputerPlayer(String name) {
    setPlayerName(name);
  }

  public EasyComputerPlayer() {
    this("");
  }


  @Override
  protected String exchangeDecision(StringBuilder commandBuilder, String handType) {

    Random generator = new Random(19580427); //TODO:magic number?

    Rank r = Rank.from(generator.nextInt(Constants.NUM_RANKS));

    setTargetRank(r);

    int n = 0;
    for (Card card : getHand()) {
      n++;
      if (card.getRank().beats(targetRank) && commandBuilder.length() < 6)  //TODO:magic number, no longer 6
        commandBuilder.append(n).append(" ");
    }
    return commandBuilder.toString();
  }
}
