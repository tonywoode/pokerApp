package pokerapp.console;

import lombok.Getter;
import pokerapp.scorer.HandCategoryResolverBuilder;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.HandCategoryResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds players for the poker app, is able to compare to pick a winning player
 * @author Steve
 * @version 1.0
 */

public class Players {



  @Getter
  ArrayList<Player> players = new ArrayList<Player>();
  HandCategoryResolver resolver = new HandCategoryResolverBuilder().create();

  public Players(Player... players) {
    for (Player player : players)
     this.players.add(player);
  }

  /**
   * Uses the current players to pick a winner
   * @return the player that has the highest ranking
   */
  public Player pickWinner() {
    Player winner = players.get(0);

    for (int iter = 1; iter < players.size(); ++iter) {
      Player challenger = players.get(iter);

      winner = pickWinner(winner, challenger);
    }

    return winner;
  }

  /**
   * When passed two players, will compare the hand category grade of the two players 
   * for a hand of poker, and return which of them compares higher
   * @param lhs player one
   * @param rhs player two
   * @return the player with the higher hand grade TODO: and their score?
   */
  protected Player pickWinner(Player lhs, Player rhs) {
    HandCategory lhsCat = resolver.resolve(lhs.getHand()),
                 rhsCat = resolver.resolve(rhs.getHand());

    int result = 0;
    try {
      result = lhsCat.compareTo(rhsCat);
    } catch (Exception e) {
      e.printStackTrace();
      return null; // TODO: fix this...
    }

    // TODO: clients should not have to do this
    if (result == 0)
      return null;
    else if (result < 0)
      return rhs;
    else
      return lhs;
  }
}
