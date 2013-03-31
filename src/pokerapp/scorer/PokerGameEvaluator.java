package pokerapp.scorer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pokerapp.*;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.HandScorer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 *   Implements the facade and bridge patterns.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class PokerGameEvaluator {
  private final HandScorer handScorer;

  public PokerGameEvaluator(HandScorer handScorer) {
    this.handScorer = handScorer;
  }

  public String determineHandName(Hand hand) throws FileNotFoundException {
    ScoredHand scoredHand = handScorer.score(hand);
    return scoredHand.getName();
  }

  public GameResult evaluate(List<Player> players) {
    if (players.size() == 2)
      return simpleGameEvaluator(players);
    else
      return tryMoreThanTwoPlayers(players);
  }

  public ScoredHand score(Hand hand) {
    return handScorer.score(hand);
  }

  private GameResult tryMoreThanTwoPlayers(List<Player> players) {
    List<ScoredPlayer> scoredPlayers = new ArrayList<>();
    for (Player p : players)
      scoredPlayers.add(new ScoredPlayer(p, handScorer.score(p.getHand())));

    Collections.sort(scoredPlayers, new Comparator<ScoredPlayer>() {
      @Override public int compare(ScoredPlayer p1, ScoredPlayer p2) {
        return p2.compareTo(p1);
      }
    });

    // check for ties...

    players = new ArrayList<>();
    for (ScoredPlayer p : scoredPlayers) {
      if (p.numTies != 0)
        throw new IllegalArgumentException("Unable to handle >2 players and ties");
      players.add(p.getPlayer());
    }

    return new MultiplePlayerNoTieGameResult(players, scoredPlayers);
  }

  private GameResult simpleGameEvaluator(List<Player> players) {
    ScoredHand lhs = handScorer.score(players.get(0).getHand()),
               rhs = handScorer.score(players.get(1).getHand());

    List<ScoredPlayer> scoredPlayers = new ArrayList<>();
    scoredPlayers.add(new ScoredPlayer(players.get(0), lhs));
    scoredPlayers.add(new ScoredPlayer(players.get(1), rhs));
    Collections.sort(scoredPlayers, new Comparator<ScoredPlayer>() {
      @Override public int compare(ScoredPlayer p1, ScoredPlayer p2) {
        return p2.compareTo(p1);
      }
    });

    int result = lhs.compareTo(rhs);

    if (result == 0)
      return new TiedSimpleGameResult(players, scoredPlayers);
    else
      return new SimpleGameResult(scoredPlayers.get(0), scoredPlayers.get(1));
  }

  public static PokerGameEvaluator create() throws IOException {
    return new PokerGameEvaluator(new HandScorerBuilder().create());
  }
}
