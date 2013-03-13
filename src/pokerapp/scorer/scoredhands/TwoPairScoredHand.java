package pokerapp.scorer.scoredhands;

import lombok.Getter;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.scorer.domain.SameRankCards;
import pokerapp.scorer.domain.Spares;
import pokerapp.utils.Comparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:02
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairScoredHand extends AbstractScoredHand<TwoPairScoredHand> {

  private static final int  PAIRLENGTH = 2;

  @Getter private SameRankCards highPair, lowPair;
  @Getter private Spares spares;

  public TwoPairScoredHand(int handNumber, Hand hand, SameRankCards highPair, SameRankCards lowPair, Spares spares) {
    super(handNumber, hand);
    this.highPair = highPair;
    this.lowPair = lowPair;
    this.spares = spares;
  }

  protected int compareEqualCategories(TwoPairScoredHand rhs) { //TODO:issue 82
    return Comparator
        .begin(highPair, rhs.highPair)
        .next(lowPair, rhs.lowPair)
        .next(spares, rhs.spares)
        .compare();
  }

  @Override
  public String getName() {
    return "Two pair";
  }

    @Override
    public List<Card> getRelevantCards() {
        List<Card> relevantArray = new ArrayList<Card>();
        List<SameRankCards> pairSet = new ArrayList<SameRankCards>();

        pairSet.add(lowPair);
        pairSet.add(highPair);

        for (SameRankCards pair : pairSet)
        {
            for(int i = 0; i < PAIRLENGTH;)
            {
                relevantArray.add(pair.get(i));
            }
        }
        return relevantArray;
    }
}