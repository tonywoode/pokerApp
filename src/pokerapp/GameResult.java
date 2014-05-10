package pokerapp;

import pokerapp.scorer.ScoredPlayer;

import java.util.List;

/**
 * <p>
 *   Represents the final state of a game of poker: who won and why.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public abstract class GameResult {
  // TODO: not happy with this; how do we handle ties?
  public abstract Player getWinner();
  public abstract Player getLoser();

  public abstract boolean isWinner(Player player);

  public boolean isLoser(Player player) {
    return !isWinner(player);
  }

  public abstract boolean isTie();

  public abstract Iterable<Player> getPlayersInRankOrder();

  public abstract Iterable<ScoredPlayer> getScoredPlayersInRankOrder();

  public abstract int getNumPlayers();
}
