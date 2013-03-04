package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.scorer.HandRanks;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 23/02/13
 * Time: 22:55
 *
 * Holds data required by the HandCategoryResolvers
 *
 */
public class HandCategoryResolverRequest {
  private final Hand hand;
  private final HandRanks rankHistogram;

  public HandCategoryResolverRequest(Hand hand) {
    this.hand = hand;
    this.rankHistogram = new HandRanks(hand);
  }

  public Hand getHand() { return hand;}
  public HandRanks getRankHistogram() { return rankHistogram; }
}
