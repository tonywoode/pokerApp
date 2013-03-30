package pokerapp;

import tests.scorer.ArrayIterator;
import tests.scorer.IterableAdapter;

import java.util.List;

/**
 * <p>
 *   Encapsulates a tied game between two players
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class TiedSimpleGameResult extends GameResult {

  private final List<Player> players;

  public TiedSimpleGameResult(List<Player> players) {
    this.players = players;
  }

  @Override
  public Player getWinner() { return null; } // TODO: this is what I'm not happy with...

  @Override
  public boolean isWinner(Player player) {
    return false;
  }

  @Override
  public boolean isLoser(Player player) {
    return false;
  }

  @Override
  public boolean isTie() {
    return true;
  }

  @Override
  public Iterable<Player> getPlayersInRankOrder() {
    return players;
  }
}
