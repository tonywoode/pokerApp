package pokerapp.scorer.scoredhands;

import pokerapp.Hand;
import pokerapp.scorer.domain.OrderedCards;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 00:59
 * To change this template use File | Settings | File Templates.
 */
public class FlushScoredHand extends AbstractScoredHand<FlushScoredHand> {

  private final Hand hand;
  private final OrderedCards cards;

  public FlushScoredHand(int handNumber, Hand hand) {
    super(handNumber, hand);
    this.hand = hand;
    this.cards = new OrderedCards(hand);
  }

  @Override
  public String getName() {
    return "Flush";
  }

  // actually, only the highest card needs to be checked
  @Override
  protected int compareEqualCategories(FlushScoredHand rhs) {
    return cards.compareTo(rhs.cards);
  }
}
