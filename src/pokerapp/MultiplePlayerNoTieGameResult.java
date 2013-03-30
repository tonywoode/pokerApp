package pokerapp;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 * Describe whether the class uses/is part of a pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
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
