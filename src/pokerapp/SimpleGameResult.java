package pokerapp;

import lombok.AllArgsConstructor;
import pokerapp.scorer.ScoredPlayer;
import tests.scorer.ArrayIterator;
import tests.scorer.IterableAdapter;

/**
 * <p>
 *   Represents the outcome of a win/lose game of poker
 *   between two players
 * </p>
 *
 * @author Steve
 * @version 1
 */
@AllArgsConstructor
public class SimpleGameResult extends GameResult {
  private final ScoredPlayer winner;
  private final ScoredPlayer loser;

  @Override
  public Player getWinner() { return winner.getPlayer(); }

  @Override
  public Player getLoser() {
    return loser.getPlayer();
  }

  @Override
  public boolean isWinner(Player player) {
    return player == winner.getPlayer();
  }

  @Override
  public boolean isLoser(Player player) {
    return player == loser.getPlayer();
  }

  @Override
  public boolean isTie() {
    return false;
  }

  @Override
  public Iterable<Player> getPlayersInRankOrder() {
    return new IterableAdapter<Player>(new ArrayIterator(new Player[] { winner.getPlayer(), loser.getPlayer() }));
  }

  @Override
  public Iterable<ScoredPlayer> getScoredPlayersInRankOrder() {
    return new IterableAdapter<ScoredPlayer>(new ArrayIterator(new ScoredPlayer[] { winner, loser }));
  }

  @Override
  public int getNumPlayers() {
    return 2;
  }
}
