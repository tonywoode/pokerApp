package pokerapp.scorer.resolvers;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 01:53
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairHandCategoryResolver extends RankedHandCategoryResolver {
  public TwoPairHandCategoryResolver() {
    super("2pair", 2, 2);
  }
}
