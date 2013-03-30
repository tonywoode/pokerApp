package pokerapp;

import lombok.Getter;
import pokerapp.scorer.PokerGameEvaluator;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.HandScorer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Holds players for the poker app, is able to compare to pick a winning player
 *
 * @author Steve
 * @version 1.0
 */
public class Players implements Iterable<Player> {

  @Getter
  ArrayList<Player> players = new ArrayList<Player>();
  private final PokerGameEvaluator pokerGameEvaluator;


  /**
   * Takes its dependency on the HandScorer through DI
   *
   * @param pokerGameEvaluator The PokerGameEvaluator bridge to the Scoring Engine
   */
  public Players(PokerGameEvaluator pokerGameEvaluator) {
    this.pokerGameEvaluator = pokerGameEvaluator;
  }

  /**
   * Player registration is handled through a separate method
   *
   * @param players varargs ordered array of players for the current game
   * @return
   */
  public Players register(Player... players) {
    for (Player player : players)
      this.players.add(player);
    return this;
  }

  public GameResult evaluateGame() {
    return pokerGameEvaluator.evaluate(players);
  }

  public boolean isWinner(Player player) {
    return evaluateGame().isWinner(player);
  }

  @Override
  public Iterator<Player> iterator() {
    return players.iterator();
  }
}
