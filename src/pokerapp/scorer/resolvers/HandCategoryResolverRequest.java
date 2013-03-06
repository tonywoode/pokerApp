package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.scorer.HandRanks;

/**
 * Holds data required by the HandCategoryResolvers
 * @author Steve
 * @version 1.0
 */

public class HandCategoryResolverRequest {
  private final Hand hand;
  private final HandRanks rankHistogram;

  /**
   * pass this constructor a hand it will hold the hand and the histogram representing that hand
   * @param hand a hand of cards
   */
  public HandCategoryResolverRequest(Hand hand) {
    this.hand = hand;
    this.rankHistogram = new HandRanks(hand);
  }

  public Hand getHand() { return hand;}
  public HandRanks getRankHistogram() { return rankHistogram; } //histogram rates a hand
}
