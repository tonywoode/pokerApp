package pokerapp.scorer.scoredhands;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.typetag.RoyalFlush;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 09/03/13
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class RoyalFlushScoredHand extends StraightFlushScoredHand {

  RoyalFlush handType;

  public RoyalFlushScoredHand(int handNumber, Hand hand, Rank rank) {
    super(handNumber, hand, rank);
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/scorer-application-context.xml");
    this.handType = (RoyalFlush)appContext.getBean("RoyalFlush");
  }

  public RoyalFlushScoredHand(StraightFlushScoredHand hand) {
    this(hand.getHandNumber(), hand.getHand(), hand.getRank());
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
              name = prop.getProperty("StraightFlush");
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
