package pokerapp.scorer.scoredhands;

import lombok.Getter;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:16
 * To change this template use File | Settings | File Templates.
 */
public class StraightScoredHand extends AbstractScoredHand<StraightScoredHand> {

  @Getter
  private Rank rank;

  public StraightScoredHand(int handNumber, Hand hand, Rank rank) {
    super(handNumber, hand);
    this.rank = rank;
  }

  @Override
  protected int compareEqualCategories(StraightScoredHand rhs) {
    return rank.compareTo(rank);
  }

  @Override
  public String getName() {
    return "Straight";
  }

  @Override
  public List<Card> getRelevantCards() {
    return hand.getSortedCards();
  }

}
