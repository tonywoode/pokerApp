package pokerapp.scorer.scoredhands;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.typetag.StraightFlush;

import java.util.List;

/**
 * Describes a straight flush
 *
 * @author steve
 */
public class StraightFlushScoredHand extends AbstractScoredHand<StraightFlushScoredHand,StraightFlush> {

  @Getter
  private Rank rank;

  public StraightFlushScoredHand(int handNumber, Hand hand, Rank rank) {
    super(handNumber, hand);
    this.rank = rank;
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/scorer-application-context.xml");
    this.handType = (StraightFlush)appContext.getBean("StraightFlush");
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