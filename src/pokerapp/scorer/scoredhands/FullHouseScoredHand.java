package pokerapp.scorer.scoredhands;

import lombok.Getter;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.scorer.typetag.FullHouse;
import pokerapp.utils.Comparator;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:05
 * To change this template use File | Settings | File Templates.
 */
public class FullHouseScoredHand extends AbstractScoredHand<FullHouseScoredHand> {
  @Getter private SameRankScoredHand triple, pair;

  public FullHouseScoredHand(int handNumber, Hand hand, SameRankScoredHand triple, SameRankScoredHand pair) {
    super(handNumber, hand, new FullHouse());
    this.triple = triple;
    this.pair = pair;
  }

  @Override
  protected int compareEqualCategories(FullHouseScoredHand rhs) {
    return Comparator
        .begin(triple.getRank(), rhs.triple.getRank())
        .next(pair.getRank(), rhs.pair.getRank())
        .compare();
  }

  @Override
  public String getName() {
    return "Full house";

  }

    @Override
    public List<Card> getRelevantCards() {
        return hand.getSortedCards();
    }
}
