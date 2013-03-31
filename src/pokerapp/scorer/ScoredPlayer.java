package pokerapp.scorer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pokerapp.Player;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * Represents a Player whose hand has been scored.
 *
 * @author Steve
 * @version 1
 */
@RequiredArgsConstructor
public class ScoredPlayer {
  @Getter
  private final Player player;
  @Getter private final ScoredHand scoredHand;
  @Getter int numWins;
  @Getter int numLosses;
  @Getter int numTies;

  public int compareTo(ScoredPlayer rhs) {
    int c = getScoredHand().compareTo(rhs.getScoredHand());
    if (c == 0)
      ++numTies;
    else if (c == 1)
      ++numLosses;
    else
      ++numWins;
    return c;
  }
}
