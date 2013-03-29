package pokerapp.scorer.scoredhands;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.scorer.typetag.FullHouse;
import pokerapp.utils.Comparator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:05
 * To change this template use File | Settings | File Templates.
 */
public class FullHouseScoredHand extends AbstractScoredHand<FullHouseScoredHand,FullHouse> {
  @Getter private RunScoredHand triple, pair;

  public FullHouseScoredHand(int handNumber, Hand hand, RunScoredHand triple, RunScoredHand pair) {
    super(handNumber, hand);
    this.triple = triple;
    this.pair = pair;
      ApplicationContext appContext = new ClassPathXmlApplicationContext("/scorer-application-context.xml");
      this.handType = (FullHouse)appContext.getBean("FullHouse");
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
      if(name.isEmpty())
      {
          Properties prop = new Properties();
          try {
              InputStreamReader in = new InputStreamReader(getClass().getResourceAsStream("/handnames.properties"));
              prop.load(in);
              in.close();
              name = prop.getProperty("FullHouse");
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
