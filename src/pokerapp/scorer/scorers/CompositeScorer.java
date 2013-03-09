package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.scoredhands.ScoredHand;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 21:15
 *
 * Pattern: Implements the Composite pattern
 *
 */
public abstract class CompositeScorer extends HandScorer {
  private ArrayList<HandScorer> scorers = new ArrayList<HandScorer>();

  public CompositeScorer(HandScorer... scorers) {
    for (HandScorer scorer : scorers)
      this.scorers.add(scorer);
  }

  @Override
  protected ScoredHand resolveCore(Hand hand) {
    ArrayList<ScoredHand> scoredHands = new ArrayList<ScoredHand>();
    for (HandScorer scorer : scorers) {
      ScoredHand scoredHand = scorer.score(hand);
      if (scoredHand == null)
        return null;
      scoredHands.add(scoredHand);
    }
    return createCategory(hand, scoredHands);
  }

  // TODO: fix this hacky solution
  public class NullScorer extends HandScorer {

    public class NullScoredHand extends ScoredHand {

      public NullScoredHand() {
        super(-100, null);
      }

      @Override
      public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
      }

      @Override
      protected int compareEqualCategories(ScoredHand rhs) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
      }
    }


    @Override
    protected ScoredHand resolveCore(Hand hand) {
      return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
  }

  protected abstract ScoredHand createCategory(Hand hand, ArrayList<ScoredHand> scoredHands);
}
