package pokerapp.scorer.categories;

import pokerapp.Card;

import java.util.ArrayList;

/**
 * Describes a flush hand
 * @author Steve
 * @version 1.0
 */
public class FlushHandCategory extends HandCategory {
  public FlushHandCategory(String name) {
    super(name);
  }

  @Override
  public FlushHandCategory clone() {
    return new FlushHandCategory(this.getName());
  }

/**
 * Compares two equal flush hands for which is the greater
 * @return TODO:
 */
  @Override
  protected int compareEqualCategories(HandCategory rhs) {
    // highest top ranking card wins; on tie, try next highest card & so on

    FlushHandCategory rhsFlush = (FlushHandCategory)rhs;

    ArrayList<Card> lhsSortedCards = hand.getSortedCards(),
                    rhsSortedCards = rhsFlush.hand.getSortedCards();

    // TODO: move this logic into a helper method; basically the same as comparing spares (in PairCategory)
    for (int iter = 0; iter < lhsSortedCards.size(); ++iter) {
      int c = Integer.compare(lhsSortedCards.get(iter).getRank(), rhsSortedCards.get(iter).getRank());
      if (c != 0)
        return c;
    }

    return 0;
  }
}
