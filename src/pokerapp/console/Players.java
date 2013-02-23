package pokerapp.console;

import pokerapp.scorer.HandCategoryResolverBuilder;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.HandCategoryResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class Players {
  ArrayList<Player> players = new ArrayList<Player>();
  HandCategoryResolver resolver = new HandCategoryResolverBuilder().create();

  public Players(Player... players) {
    for (Player player : players)
     this.players.add(player);
  }

  public Player pickWinner() {
    Player winner = players.get(0);

    for (int iter = 1; iter < players.size(); ++iter) {
      Player challenger = players.get(iter);

      winner = pickWinner(winner, challenger);
    }

    return winner;
  }

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
