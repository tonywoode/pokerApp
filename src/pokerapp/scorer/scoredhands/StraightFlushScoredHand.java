package pokerapp.scorer.scoredhands;

import lombok.Getter;
import pokerapp.Card;
import pokerapp.Hand;

import java.util.List;

/**
 * Describes a straight flush
 * @author steve
 */
public class StraightFlushScoredHand extends AbstractScoredHand<StraightFlushScoredHand> {

  @Getter private int rank;

  public StraightFlushScoredHand(int handNumber, Hand hand, int rank) {
    super(handNumber, hand);
    this.rank = rank;
  }

  @Override
  protected int compareEqualCategories(StraightFlushScoredHand rhs) {
    return Integer.compare(rank, rhs.rank);
  }

  @Override
  public String getName() {
    return "Straight flush";
  }

    @Override
    public List<Card> getRelevantCards() {
        return hand.getSortedCards();
    }
}