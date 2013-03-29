package pokerapp.scorer.scoredhands;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.typetag.Straight;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

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
    super(handNumber, hand, new Straight());
    this.rank = rank;
  }

  @Override
  protected int compareEqualCategories(StraightScoredHand rhs) {
    return rank.compareTo(rank);
  }

  @Override
  public String getName() {
      if(name == null)
      {
          Properties prop = new Properties();
          try {
              InputStreamReader in = new InputStreamReader(getClass().getResourceAsStream("/handnames.properties"));
              prop.load(in);
              in.close();
              name = prop.getProperty("Straight");
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      return name;
  }

  @Override
  public List<Card> getRelevantCards() {
    return hand.getSortedCards();
  }

}
