package pokerapp;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Represents the (most common) outcome where a single player
 * has won when many (>2) were playing.
 *
 * @author Steve
 * @version 1
 */
@AllArgsConstructor
public class MultiplePlayerNoTieGameResult extends GameResult {
  @Getter private final List<Player> playersInWinOrder;

  @Override
  public Player getWinner() { return playersInWinOrder.get(0); }

  @Override
  public boolean isWinner(Player player) {
    return playersInWinOrder.get(0) == player;
  }

  @Override
  public boolean isTie() {
    return false;
  }

  @Override
  public Iterable<Player> getPlayersInRankOrder() {
    return playersInWinOrder;
  }
}
