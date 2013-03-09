package pokerapp.scorer.domain;

import pokerapp.Card;
import pokerapp.HighToLowCardComparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Provides a simulated typedef to facilitate the
 * Ubiquitous Language of the poker domain model.
 * <p>
 * However, this article suggests that misusing
 * inheritance in this way is an anti-pattern:
 * http://www.ibm.com/developerworks/library/j-jtp02216/
 * <p>
 * However, the pitfalls mentioned in the article
 * do not apply here. TODO: explain why...
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
}
