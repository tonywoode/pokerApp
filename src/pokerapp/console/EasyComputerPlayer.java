package pokerapp.console;

import pokerapp.scorer.scoredhands.ScoredHand;

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
  protected void exchangeDecision(ScoredHand handType) {
    handType.visit(new EasyStrategyVisitor());
  }
}
