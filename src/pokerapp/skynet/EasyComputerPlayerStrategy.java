package pokerapp.skynet;

import lombok.AllArgsConstructor;
import pokerapp.Card;
import pokerapp.Dealer;
import pokerapp.Hand;
import pokerapp.scorer.HandVisitor;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.typetag.*;

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
public class EasyComputerPlayerStrategy extends ComputerPlayerStrategy {
  private final RandomNumberGenerator rng;

  @Override
  public void playTurn(Dealer dealer, ScoredHand handType) {
    Hand hand = handType.getHand();

    int numCardsToExchange = rng.nextInteger(0, Hand.HAND_SIZE);

    // TODO: allows the same card (position) to be exchanged multiple times
    for (int iter = 0; iter != numCardsToExchange; ++iter)
      dealer.exchangeCard(hand, hand.getCard(rng.nextInteger(0, Hand.HAND_SIZE)));
  }

  @Override
  public ComputerPlayerStrategy createNew() {
    return new EasyComputerPlayerStrategy(rng);
  }

  @Override
  public String toString() {
    return "Easy";
  }
}
