package pokerapp;

import lombok.AllArgsConstructor;
import pokerapp.scorer.ScoredPlayer;
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
@AllArgsConstructor
public class TiedSimpleGameResult extends GameResult {

  private final List<Player> players;
  private List<ScoredPlayer> scoredPlayers;

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

  @Override
  public Iterable<ScoredPlayer> getScoredPlayersInRankOrder() {
    return scoredPlayers;
  }
}
