package pokerapp.scorer.scoredhands;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.domain.Spares;
import pokerapp.scorer.typetag.NoPair;
import pokerapp.utils.Comparator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 09/03/13
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
public class NoPairScoredHand extends AbstractScoredHand<NoPairScoredHand> {

    @Getter private Spares spares;

    public NoPairScoredHand(int handNumber, Hand hand, Spares spares) {
        super(handNumber, hand, new NoPair());
        this.spares = spares;
        ApplicationContext appContext = new ClassPathXmlApplicationContext("/scorer-application-context.xml");
        this.handType = (NoPair)appContext.getBean("NoPair");
    }

    @Override
    protected int compareEqualCategories(NoPairScoredHand rhs) {
        return Comparator
                .begin(spares, rhs.spares)
                .compare();
    }

    /**
     * All hands have a 'category' name. Most know their own name,
     * but some must calculate. Hence an abstract property.
     */
    @Override
    public String getName() {
      return "No pair";
    }

  @Override
  public Rank getHandRank() {
    return null; // TODO: fix me!
  }

  @Override
    public List<Card> getRelevantCards() {
        return new ArrayList<Card>();
    }
}
