package pokerapp.scorer;

import pokerapp.Hand;
import pokerapp.Player;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.HandScorer;

import java.io.FileNotFoundException;
import java.io.IOException;
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

  public Hand pickWinner(Hand... hands) throws IllegalArgumentException {
    if (hands.length < 2)
      throw new IllegalArgumentException("Need at least 2 hands to pick a winner!");

    Hand currentWinner = hands[0];
    for (int iter = 1; iter < hands.length; ++iter) {
      currentWinner = pickWinner(currentWinner, hands[iter]);
      if (currentWinner == null) // tie
        currentWinner = hands[iter];
    }

    return currentWinner;
  }

  public Hand pickWinner(List<Hand> hands) throws IllegalArgumentException {
    if (hands.size() < 2)
      throw new IllegalArgumentException("Need at least 2 hands to pick a winner!");

    Hand currentWinner = hands.get(0);
    for (int iter = 1; iter < hands.size(); ++iter) {
      currentWinner = pickWinner(currentWinner, hands.get(iter));
      if (currentWinner == null) // tie
        currentWinner = hands.get(iter);
    }

    return currentWinner;
  }


  /**
   * When passed two players, will compare the hand category grade of the two players
   * for a hand of poker, and return which of them compares higher
   *
   * <p>
   *   Stolen from Players.java
   * </p>
   *
   * @param lhs player one
   * @param rhs player two
   * @return the player with the higher hand grade
   */
  protected Hand pickWinner(Hand lhs, Hand rhs) {
    ScoredHand lhsCat = handScorer.score(lhs),
               rhsCat = handScorer.score(rhs);

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

  public static PokerGameEvaluator create() throws IOException {
    return new PokerGameEvaluator(new HandScorerBuilder().create());
  }
}
