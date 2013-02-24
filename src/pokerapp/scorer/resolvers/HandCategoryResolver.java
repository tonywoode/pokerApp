package pokerapp.scorer.resolvers;


import pokerapp.Hand;
import pokerapp.HandRankHistogram;
import pokerapp.scorer.categories.FlushHandCategory;
import pokerapp.scorer.categories.HandCategory;

import java.lang.reflect.Constructor;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 01:20
 * To change this template use File | Settings | File Templates.
 *
 *
 * Uses the Chain of Responsibility pattern.
 *
 */
public abstract class HandCategoryResolver {

  protected HandCategoryResolver nextResolver;
  protected int number;
  protected final HandCategory _prototypeCategory;

  protected HandCategoryResolver(HandCategory prototypeCategory) {
    _prototypeCategory = prototypeCategory;
  }

  public void setNextScorer(HandCategoryResolver next) {
    nextResolver = next;
  }

  public void setCategoryNumber(int cn) {
    number = cn;
  }

  // keeps existing clients from breaking from the introduction of the HandCategoryResolverRequest
  public HandCategory resolve(Hand hand) {
    try {
      return resolve(new HandCategoryResolverRequest(hand));
    } catch(Exception e) {
      return null;
    }
  }

  public HandCategory resolve(HandCategoryResolverRequest request) throws Exception {
    if (matches(request))
      return createFromPrototype(request);
    else
      return this.nextResolver.resolve(request);
  }

  protected abstract boolean matches(HandCategoryResolverRequest request) throws Exception;

  protected HandCategory createFromPrototype(HandCategoryResolverRequest request) throws Exception {
    return _prototypeCategory.clone(this.number, request.getHand(), determineRank(request), request.getRankHistogram());
  }

  protected int determineRank(HandCategoryResolverRequest request) throws Exception {
    return -1; // ie, not implemented
  }
}
