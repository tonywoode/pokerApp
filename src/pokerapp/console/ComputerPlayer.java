package pokerapp.console;

import lombok.Setter;
import pokerapp.Deck;
import pokerapp.Rank;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.typetag.HandTypeTag;


/**
 * @author Steve
 * @author Ari
 * @author Sam
 * @version 1.0
 */

public abstract class ComputerPlayer extends Player {

  @Setter
  Rank targetRank;

  public ComputerPlayer(String name) {
    setPlayerName(name);

  }

  public ComputerPlayer() {
    this("Computer");
  }

  public void playTurn(IConsole console, Deck deck, ExchangeSetting exchangeSetting) {

    for (int numberExchanges = 0; numberExchanges < exchangeSetting.getNumTimes(); ++numberExchanges) {

      Class<? extends Player> playerClass = getClass();
      String playerType = playerClass.getSimpleName().replace("ComputerPlayer","");

      StringBuilder commandBuilder = new StringBuilder();
      ScoredHand scoredHand = new HandScorerBuilder().create().score(getHand());
      String handType = scoredHand.getName();
      console.writeMessage(getPlayerName() + " (" + playerType + ") has: " + getHand().toFancyUserString() +
          handType);

<<<<<<< HEAD
      String command = exchangeDecision(commandBuilder, handType);
      ExchangeCardsInterpreter interpreter = new ExchangeCardsInterpreter(command);
      interpreter.execute(getHand(), deck);
      console.writeMessage(getPlayerName() + " (" + playerType + ") exchanged " + command);
=======
      exchangeDecision(scoredHand);

     // console.writeMessage(getPlayerName() + " (" + difficultyCode + ") exchanged "); TODO - eh what to do here?
>>>>>>> ea022cb5803bdc5f6f682cecad97d9abd30fd38b

      scoredHand = new HandScorerBuilder().create().score(getHand());
      handType = scoredHand.getName();
      console.writeMessage(getPlayerName() + " (" + playerType + ") has: " + getHand().toFancyUserString() +
          handType);

    }
  }

  protected abstract void exchangeDecision(ScoredHand handType);
}
