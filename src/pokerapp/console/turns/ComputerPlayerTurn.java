package pokerapp.console.turns;

import lombok.AllArgsConstructor;
import pokerapp.ComputerPlayer;
import pokerapp.Dealer;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;
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
    console.writeMessage("{0} plays", player.getPlayerName());

    ScoredHand scoredHand = pokerGameEvaluator.score(player.getHand());

    player.playTurn(dealer, scoredHand, exchangeSetting);
  }
}
