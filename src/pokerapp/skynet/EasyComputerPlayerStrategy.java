package pokerapp.skynet;

import lombok.AllArgsConstructor;
import pokerapp.Dealer;
import pokerapp.Hand;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
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

    int numCardsToExchange = rng.nextInteger(0, Hand.HAND_SIZE - 1);

    // TODO: allows the same card (position) to be exchanged multiple times
    for (int iter = 0; iter != numCardsToExchange; ++iter)
      dealer.exchangeCard(hand, hand.getCard(rng.nextInteger(0, Hand.HAND_SIZE - 1)));
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
