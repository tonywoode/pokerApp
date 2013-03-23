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
  @Setter
  private String difficultyCode = "";

  public ComputerPlayer(String name) {
    setPlayerName(name);

  }

  public ComputerPlayer() {
    this("Computer");
  }

  public void playTurn(IConsole console, Deck deck, ExchangeSetting exchangeSetting) {

    for (int numberExchanges = 0; numberExchanges < exchangeSetting.getNumTimes(); ++numberExchanges) {

      StringBuilder commandBuilder = new StringBuilder();
      ScoredHand scoredHand = new HandScorerBuilder().create().score(getHand());
      String handType = scoredHand.getName();
      console.writeMessage(getPlayerName() + " (" + difficultyCode + ") has: " + getHand().toFancyUserString() +
          handType);

      exchangeDecision(scoredHand);

     // console.writeMessage(getPlayerName() + " (" + difficultyCode + ") exchanged "); TODO - eh what to do here?

      scoredHand = new HandScorerBuilder().create().score(getHand());
      handType = scoredHand.getName();
      console.writeMessage(getPlayerName() + " (" + difficultyCode + ") has: " + getHand().toFancyUserString() +
          handType);

    }
  }

  protected abstract void exchangeDecision(ScoredHand handType);
}
