package pokerapp.console;

import lombok.AllArgsConstructor;
import pokerapp.GameResult;
import pokerapp.Player;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.HandScorer;

/**
 *
 * Converts a game result into a human-readable message.
 *
 * For example:
 *
 *   Steve won with a Flush (cards making up flush)
 *   Jessica lost with a Pair (card list)
 *
 * Or
 *
 *   Steve lost with [X] high
 *
 * Or
 *
 *   Steve won with 8 Flush
 *   Jessica lost with a 4 Flush
 *
 * @author Steve
 * @author Ari
 * @version 1
 *
 */

@AllArgsConstructor
public class WinMessageRenderer {
  private final HandScorer handScorer;

  public void writeMessage(GameResult result, Console console) {

    // simple case: no more than two players

    if (result.getNumPlayers() != 2)
      throw new IllegalArgumentException("No more than 2 players currently supported");

    Player winner = result.getWinner();
    Player loser  = result.getLoser();

    ScoredHand winningHand = handScorer.score(winner.getHand());
    ScoredHand losingHand = handScorer.score(loser.getHand());

    if (!winningHand.getName().equals(losingHand.getName())) {
      // case: different hand categories (e.g., flush beats pair
      console.writeMessage("{0} won with a {1} ({2})", winner.getPlayerName(), winningHand.getName(), winner.getHand().toFancyUserString());
      console.writeMessage("{0} lost with a {1} ({2})", loser.getPlayerName(), losingHand.getName(), loser.getHand().toFancyUserString());

    }
    else
      console.writeMessage("Don't know why the game was won!");


  }

}
