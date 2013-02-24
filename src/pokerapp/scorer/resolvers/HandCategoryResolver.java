package pokerapp.scorer.resolvers;


import pokerapp.Hand;
import pokerapp.scorer.categories.HandCategory;

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

  public void setNextScorer(HandCategoryResolver next) {
    nextResolver = next;
  }

  public void setCategoryNumber(int cn) {
    number = cn;
  }

  //
  //
  // @descrption: keeps existing clients from breaking from the
  //              introduction of the HandCategoryResolverRequest
  public HandCategory resolve(Hand hand) {
    try {
      return resolve(new HandCategoryResolverRequest(hand));
    } catch(Exception e) {
      return null;
    }
  }

  public abstract HandCategory resolve(HandCategoryResolverRequest request) throws Exception;
}
