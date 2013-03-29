package pokerapp.scorer.scoredhands;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.domain.SameRankCards;
import pokerapp.scorer.domain.Spares;
import pokerapp.scorer.typetag.Run;
import pokerapp.utils.Comparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Sets up ranking for hand ratings, in case we get the same hand rating in more than one hand,
 * we need to know which hand has higher rating TODO//is that right?
 *
 * @author Steve
 * @version 1.0
 */
public class RunScoredHand extends AbstractScoredHand<RunScoredHand, Run> {

  private String name;
  private SameRankCards sameRankCards;
  private Spares spares;

  public RunScoredHand(int handNumber, Hand hand, String name, SameRankCards sameRankCards, Spares spares) {
    super(handNumber, hand);
    this.name = name;
    this.sameRankCards = sameRankCards;
    this.spares = spares;
//    ApplicationContext appContext = new ClassPathXmlApplicationContext("/scorer-application-context.xml");
//    this.handType = (Run)appContext.getBean(Integer.toString(handNumber));
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<Card> getRelevantCards() {
    List<Card> relevantArray = new ArrayList<Card>();
    Iterator<Card> iter = sameRankCards.iterator();

    while (iter.hasNext())
      relevantArray.add(iter.next());

    return relevantArray;
  }

  public Rank getRank() {
    return sameRankCards.getRank();
  }

  @Override
  protected int compareEqualCategories(RunScoredHand rhs) {
    return Comparator
        .begin(sameRankCards, rhs.sameRankCards)
        .next(spares, rhs.spares)
        .compare();
  }
}
