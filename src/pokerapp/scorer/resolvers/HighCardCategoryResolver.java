package pokerapp.scorer.resolvers;

import pokerapp.scorer.categories.HighCardCategory;

/**
 * Will rate the lowest poker hand (AKA no-pair) where the only scoring potential is the highest card of the hand 
 * @author steve
 * @version 1.0
 */

public class HighCardCategoryResolver extends HandCategoryResolver {
  public HighCardCategoryResolver() {
    super(new HighCardCategory("highCard"));
  }

  @Override
  protected boolean matches(HandCategoryResolverRequest request) throws Exception {
    return true; //TODO: is this always true or are you mocking?
  }
}
