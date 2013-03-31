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
    turnStrategy.setPlayer(this);
  }

  public ComputerPlayer(ComputerPlayerStrategy turnStrategy) {
    this("Computer", turnStrategy);

  }

  public ComputerPlayer createNew() {
    return new ComputerPlayer(getPlayerName(), turnStrategy.createNew());
  }

  public void playTurn(Dealer dealer, ScoredHand scoredHand, ExchangeSetting exchangeSetting) {
    turnStrategy.playTurn(dealer, scoredHand);
  }

  public String getStrategyFancyName() {
    return turnStrategy.toString();
  }

  public ComputerPlayerStrategy getTurnStrategy() {
    return turnStrategy;
  }

  @Override
  public void visit(PlayerVisitor visitor) {
    visitor.accept(this);
  }
}
