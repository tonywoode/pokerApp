package pokerapp.scorer.domain;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.HighToLowCardComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Provides a simulated typedef to facilitate the
 * Ubiquitous Language of the poker domain model.
 * <p>
 * However, this article suggests that misusing
 * inheritance in this way is an anti-pattern:
 * http://www.ibm.com/developerworks/library/j-jtp02216/
 * <p>
 * However, the pitfalls mentioned in the article
 * do not apply here.
 * 
 * @author Steve Faulmann
 *
 */
public class Spares extends OrderedCards {
  public Spares(Card... cards) {
    super(cards);
  }

  public Spares(ArrayList<Card> cards) {
    super(cards);
  }

    public Spares(Hand hand) {
     super(hand);
    }

    public List<Card> getKickers()
    {
        Iterator<Card> iter = iterator();
        List<Card> kickList = new ArrayList<Card>();

        while(iter.hasNext())
            kickList.add(iter.next());

        return kickList;
    }
}
