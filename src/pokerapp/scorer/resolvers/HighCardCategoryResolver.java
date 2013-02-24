package pokerapp.scorer.resolvers;

import pokerapp.scorer.categories.HighCardCategory;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 02:34
 * To change this template use File | Settings | File Templates.
 */
public class HighCardCategoryResolver extends HandCategoryResolver {
  public HighCardCategoryResolver() {
    super(new HighCardCategory("highCard"));
  }

  @Override
  protected boolean matches(HandCategoryResolverRequest request) throws Exception {
    return true;
  }
}
