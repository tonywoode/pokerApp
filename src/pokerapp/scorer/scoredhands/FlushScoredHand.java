package pokerapp.scorer.scoredhands;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.HandVisitor;
import pokerapp.scorer.domain.OrderedCards;
import pokerapp.scorer.typetag.Flush;
import pokerapp.scorer.typetag.HandType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

/**
 * Describes a flush hand
 * @author Steve
 * @version 1.0
 */
public class FlushScoredHand extends AbstractScoredHand<FlushScoredHand> {
  private final Hand hand;
  private final OrderedCards cards;

  public FlushScoredHand(int handNumber, Hand hand) {
    super(handNumber, hand, new Flush());
    this.hand = hand;
    this.cards = new OrderedCards(hand);
  }

  @Override
  public String getName() {
    return "Flush";
  }

  @Override
  public Rank getHandRank() {
    return null; // TODO: fix me
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

    public void visit(HandVisitor visitor) {
        handType.visit(this, visitor);
    }
}
