package pokerapp;

import lombok.Data;
import lombok.Getter;


/**
 * creates cards for the poker app
 *
 * @author Steve
 * @version 1.0
 */
@Data
public class Card {
  @Getter
  private Suit suit;
  @Getter
  private Rank rank;

  public Card(Suit suit, Rank rank) throws IllegalArgumentException {
    if (suit == null)
      throw new IllegalArgumentException("Suit must not be null");

    // supports aces high & low; TODO: is this sensible?
    if (rank.getNumber() < Rank.DEUCE.getNumber() && rank.getNumber() > Rank.ACE.getNumber())
      throw new IllegalArgumentException("Illegal Rank: " + rank);

    this.suit = suit;
    this.rank = rank;
  }

  /**
   * returns the suit and rank of card
   *
   * @return suit and rank of card
   */
  @Override
  public String toString() {
    return suit.toString() + getRank();
  }

  /**
   * returns the suit and rank symbol of card, e.g. J instead of 11
   *
   * @return suit and rank of card
   */
  public String toFancyString() {
    return getSuit() + Integer.toString(getRank().getNumber());
  }
}
