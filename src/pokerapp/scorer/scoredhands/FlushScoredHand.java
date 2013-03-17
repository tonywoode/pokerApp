package pokerapp.scorer.scoredhands;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.scorer.domain.OrderedCards;

import java.util.List;

/**
 * Describes a flush hand
 * @author Steve
 * @version 1.0
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

    @Override
    public List<Card> getRelevantCards() {
        return hand.getSortedCards();
    }

   /**
   * Compares two equal flush hands for which is the greater
   * actually, only the highest card needs to be checked
   */
  @Override
  protected int compareEqualCategories(FlushScoredHand rhs) {
    return cards.compareTo(rhs.cards);
  }
}
