package pokerapp;

import lombok.Getter;
import pokerapp.utils.Constants;


/**
 * creates cards for the poker app
 * @author Steve
 * @version 1.0
 */
public class Card {
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
   * gets the ordinal of the card
   * @return the card's ordinal
   */
  //TODO: what is that exactly?
  // Ari: I think this is a hangover from card number when we were going to
  // number the deck from 1 to 52
  // in which case it should be
  // suit.getNumber() * (getRank()-1)
  // not suit.getNumber() * getRank(), so I've changed it to the former

  public int getOrdinal() { return suit.getNumber() * (getRank()-1); }

  /**
   * returns the suit and rank of card
   * @return suit and rank of card
   */
  @Override
  public String toString() {
    return suit.toString() + getRank();
  }

}
