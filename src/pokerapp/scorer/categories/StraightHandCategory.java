package pokerapp.scorer.categories;

/**
 * Created with IntelliJ IDEA.
 * User: steve  + Ari
 * Date: 22/02/13
 * Time: 02:15
 * To change this template use File | Settings | File Templates.
 */
public class StraightHandCategory extends HandCategory {
  public StraightHandCategory(String name) {
    super(name);
  }


  //TODO:Steve, please write up this clone method
  @Override
  public StraightHandCategory clone() {
    return new StraightHandCategory(this.getName());
  }

    /**
     * highest top ranking card wins; on tie, try next highest card & so on
     * @param rhs the hand passed in to compare against this
     * @return 1 if host winds, 0 for tie, -1 if rhs wins
     */
  @Override
  public int compareEqualCategories(HandCategory rhs) {

    int rhs_score = Integer.parseInt (rhs.getRankHistogram().toString());
    int lhs_score = Integer.parseInt (this.getRankHistogram().toString());

    return(Integer.compare(lhs_score, rhs_score));
  }
}
