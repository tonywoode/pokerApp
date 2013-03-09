package pokerapp;

import lombok.Data;
import lombok.Getter;
import pokerapp.utils.Constants;


/**
 * creates cards for the poker app
 * @author Steve
 * @version 1.0
 */
@Data public class Card {
  @Getter private Suit suit;
  @Getter private int rank;

  public Card(Suit suit, int rank) throws IllegalArgumentException {
    if (suit == null)
      throw new IllegalArgumentException("Suit must not be null");

    // supports aces high & low; TODO: is this sensible?
    if (rank < Constants.RANK_ACE_LO && rank > Constants.NUM_RANKS)
      throw new IllegalArgumentException("Illegal Rank: " + rank);

    this.suit = suit;
    this.rank = rank;
  }

  /**
   * returns the suit and rank of card
   * @return suit and rank of card
   */
  @Override
  public String toString() {
    return suit.toString() + getRank();
  }

}
