package pokerapp.console.turns;

import lombok.AllArgsConstructor;
import pokerapp.ComputerPlayer;
import pokerapp.Dealer;
import pokerapp.Deck;
import pokerapp.Player;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.PokerGameEvaluator;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * <p>
 *   Handles the console-based ComputerPlayer turn. This essentially
 *   means that it logs events to the console.
 * </p>
 *
 * @author Steve
 * @version 1
 */
@AllArgsConstructor
public class ComputerPlayerTurn implements ConsolePlayerTurn {
  private final ComputerPlayer player;
  private final ExchangeSetting exchangeSetting;
  private final PokerGameEvaluator pokerGameEvaluator;
  
  @Override
  public void playTurn(Dealer dealer, Console console) {
    Class playerClass = player.getTurnStrategy().getClass();
    String playerType = playerClass.getSimpleName().replace("ComputerPlayerStrategy","");

    ScoredHand scoredHand = pokerGameEvaluator.score(player.getHand());
    String handType = scoredHand.getName();
    console.writeMessage(player.getPlayerName() + " (" + playerType + ") has: " + player.getHand().toFancyUserString() + " " +
          handType);

    player.playTurn(dealer, scoredHand, exchangeSetting);

    handType = scoredHand.getName();

    console.writeMessage(player.getPlayerName() + " (" + playerType + ") has: " + player.getHand().toFancyUserString() + " " +
          handType);
  }
}
