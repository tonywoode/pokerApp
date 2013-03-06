package pokerapp.scorer.resolvers;


import pokerapp.Hand;
import pokerapp.scorer.categories.HandCategory;

/**
 * Uses the CHAIN OF RESPONSIBILITY pattern to determine which scoring cards a particular card has
 * @author Steve
 * @version 1.0
 */
public abstract class HandCategoryResolver {

  protected HandCategoryResolver nextResolver;
  protected int number;
  protected final HandCategory _prototypeCategory;

  protected HandCategoryResolver(HandCategory prototypeCategory) {
    _prototypeCategory = prototypeCategory;
  }

  /**
   * so we can cycle through the (ordered) scoring hand types
   * @param next next scoring hand type
   */
  public void setNextScorer(HandCategoryResolver next) {
    nextResolver = next;
  }

  public void setCategoryNumber(int cn) {
    number = cn;
  }

  //TODO: NEED TO DESCRIBE THIS METHOD AND THE ONE BELOW IT BETTER, OR IS THIS A FUDGE? OR CAN THESE METHODS BE IN A BETER ORDER
  /**
   * Allows the resolver to handle requests when passed a hand - returns null if none exists
   * @param hand a hand of cards
   * @return a request to resolve a scoring hand
   */
  // keeps existing clients from breaking from the introduction of the HandCategoryResolverRequest
  public HandCategory resolve(Hand hand) {
    try {
      return resolve(new HandCategoryResolverRequest(hand));
    } catch(Exception e) {
      return null;
    }
  }

  /**
   * When passed a request to determine if a hand scores, will begin a request to score a hand or pass resolution of next scoring hand
   * @param request a request for a resolver which began from a hand to be scored
   * @return the next resolver request //TODO: what????
   * @throws Exception
   */
  public HandCategory resolve(HandCategoryResolverRequest request) throws Exception {
    if (matches(request))
      return createFromPrototype(request);
    else
      return this.nextResolver.resolve(request);
  }

  /**
   * creates in instance of a scoring category so we can match against it for the resolve method //TODO: ???
   * @param request a request to to score an actual hand
   * @return a class of scoring hand based on the elements of the current hand to be scored
   * @throws Exception
   */
  protected abstract boolean matches(HandCategoryResolverRequest request) throws Exception;

  protected HandCategory createFromPrototype(HandCategoryResolverRequest request) throws Exception {
    return _prototypeCategory.clone(this.number, request.getHand(), determineRank(request), request.getRankHistogram());
  }

  protected int determineRank(HandCategoryResolverRequest request) throws Exception {
    return -1; // ie, not implemented //TODO: WHAT HAPPENS ABOUT THIS THEN?
  }
}
