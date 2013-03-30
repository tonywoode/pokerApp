package pokerapp.skynet;

import pokerapp.Dealer;
import pokerapp.scorer.scoredhands.ScoredHand;

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
public abstract class ComputerPlayerStrategy {
  public abstract void playTurn(Dealer dealer, ScoredHand handType);

  /**
   * Implements the prototype pattern
   *
   * @return a clone of the strategy
   */
  public abstract ComputerPlayerStrategy createNew();
}
