package pokerapp.scorer.scoredhands;

import lombok.Getter;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.typetag.HandType;
import pokerapp.scorer.typetag.StraightFlush;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

/**
 * Describes a straight flush
 *
 * @author steve
 */
public class StraightFlushScoredHand extends AbstractScoredHand<StraightFlushScoredHand> {

  @Getter
  private Rank rank;

  public StraightFlushScoredHand(int handNumber, Hand hand, Rank rank, HandType handType) {
    super(handNumber, hand, handType);
    this.rank = rank;
  }

  public StraightFlushScoredHand(int handNumber, Hand hand, Rank rank) {
    this(handNumber, hand, rank, new StraightFlush());
  }

  @Override
  protected int compareEqualCategories(StraightFlushScoredHand rhs) {
    return rank.compareTo(rhs.rank);
  }

  @Override
  public String getName() throws FileNotFoundException {
    return "Straight flush";
  }

  @Override
  public List<Card> getRelevantCards() {
    return hand.getSortedCards();
  }
}