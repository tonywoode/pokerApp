package pokerapp;

import lombok.AllArgsConstructor;
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
  private final Player winner;
  private final Player loser;

  @Override
  public Player getWinner() { return winner; }

  @Override
  public boolean isWinner(Player player) {
    return player == winner;
  }

  @Override
  public boolean isLoser(Player player) {
    return player == loser;
  }

  @Override
  public boolean isTie() {
    return false;
  }

  @Override
  public Iterable<Player> getPlayersInRankOrder() {
    return new IterableAdapter<Player>(new ArrayIterator(new Player[] { winner, loser }));
  }
}
