package pokerapp.console;

import pokerapp.Deck;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;


/**
 * @author Steve
 * @author Ari
 * @author Sam
 * @version 1.0
 */

public class ComputerPlayer extends Player {

  private final ComputerPlayerStrategy turnStrategy;

  public ComputerPlayer(String name, ComputerPlayerStrategy turnStrategy) {
    this.turnStrategy = turnStrategy;
    setPlayerName(name);
  }

  public ComputerPlayer(ComputerPlayerStrategy turnStrategy) {
    this("Computer", turnStrategy);
  }

  public void playTurn(IConsole console, Deck deck, ExchangeSetting exchangeSetting) {

    for (int numberExchanges = 0; numberExchanges < exchangeSetting.getNumTimes(); ++numberExchanges) {

      Class<? extends Player> playerClass = getClass();
      String playerType = playerClass.getSimpleName().replace("ComputerPlayer","");

      ScoredHand scoredHand = new HandScorerBuilder().create().score(getHand());
      String handType = scoredHand.getName();
      console.writeMessage(getPlayerName() + " (" + playerType + ") has: " + getHand().toFancyUserString() +
          handType);

      scoredHand = new HandScorerBuilder().create().score(getHand());

      turnStrategy.playTurn(scoredHand);

      handType = scoredHand.getName();

      console.writeMessage(getPlayerName() + " (" + playerType + ") has: " + getHand().toFancyUserString() +
          handType);

    }
  }
}
