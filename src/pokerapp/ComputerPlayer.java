package pokerapp;

import pokerapp.console.ExchangeSetting;
import pokerapp.console.Console;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.skynet.ComputerPlayerStrategy;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import java.io.IOException;


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

  public ComputerPlayer createNew() {
    return new ComputerPlayer(getPlayerName(), turnStrategy.createNew());
  }

  public void playTurn(Console console, Dealer dealer, Deck deck, ExchangeSetting exchangeSetting) throws IOException, FormatStringException, IllegalFormatCodeException {

    for (int numberExchanges = 0; numberExchanges < exchangeSetting.getNumTimes(); ++numberExchanges) {

      Class playerClass = turnStrategy.getClass();
      String playerType = playerClass.getSimpleName().replace("ComputerPlayerStrategy","");

      ScoredHand scoredHand = new HandScorerBuilder().create().score(getHand());
      String handType = scoredHand.getName();
      console.writeMessage(getPlayerName() + " (" + playerType + ") has: " + getHand().toFancyUserString() + " " +
          handType);

      scoredHand = new HandScorerBuilder().create().score(getHand());

      turnStrategy.playTurn(dealer, scoredHand);

      handType = scoredHand.getName();

      console.writeMessage(getPlayerName() + " (" + playerType + ") has: " + getHand().toFancyUserString() + " " +
          handType);

    }
  }

  public String getStrategyFancyName() {
    return turnStrategy.toString();
  }
}
