package pokerapp;

import lombok.Getter;
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
  private final HandScorer scorer;

  /**
   * Takes its dependency on the HandScorer through DI
   *
   * @param scorer The first HandScorer in the Chain of Responsibility
   */
  public Players(HandScorer scorer) {
    this.scorer = scorer;
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

  /**
   * Uses the current players to pick a winner
   *
   * @return the player that has the highest ranking
   */
  public Player pickWinner() {
    Player winner = players.get(0);
    //TODO: make for loop clearer - it isn't in std form
    for (int iter = 1; iter < players.size(); ++iter) {
      Player challenger = players.get(iter);

      winner = pickWinner(winner, challenger);
    }

    return winner;
  }

  /**
   * When passed two players, will compare the hand category grade of the two players
   * for a hand of poker, and return which of them compares higher
   *
   * @param lhs player one
   * @param rhs player two
   * @return the player with the higher hand grade TODO: and their score?
   */
  protected Player pickWinner(Player lhs, Player rhs) {
    ScoredHand lhsCat = scorer.score(lhs.getHand()),
        rhsCat = scorer.score(rhs.getHand());

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

  @Override
  public Iterator<Player> iterator() {
    return players.iterator();
  }
}
