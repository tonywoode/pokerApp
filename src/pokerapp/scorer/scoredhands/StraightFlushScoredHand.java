package pokerapp.scorer.scoredhands;

import lombok.Getter;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;

import java.util.List;

/**
 * Describes a straight flush
 *
 * @author steve
 */
public class StraightFlushScoredHand extends AbstractScoredHand<StraightFlushScoredHand> {

  @Getter
  private Rank rank;

  public StraightFlushScoredHand(int handNumber, Hand hand, Rank rank) {
    super(handNumber, hand);
    this.rank = rank;
  }

  @Override
  protected int compareEqualCategories(StraightFlushScoredHand rhs) {
    return rank.compareTo(rhs.rank);
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