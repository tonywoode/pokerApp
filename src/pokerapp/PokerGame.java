package pokerapp;

import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.HandScorer;

/**
 * <p>
 *   Represents a single game of poker, including the Dealer and all
 *   the players, with their hands.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class PokerGame {
  private final Deck deck;
  private final Dealer dealer;
  private final Players players;
  private final int numTurns;
  private final int maxExchanges;
  private final HandScorer handScorer;

  public PokerGame(Deck deck, Dealer dealer, Players players, int numTurns, int maxExchanges, HandScorer handScorer) {
    this.deck = deck;
    this.dealer = dealer;
    this.players = players;
    this.numTurns = numTurns;
    this.maxExchanges = maxExchanges;
    this.handScorer = handScorer;
  }

}
