package pokerapp;

import pokerapp.utils.Constants;


/**
 * creates cards for the poker app
 * @author Steve
 * @version 1.0
 */
public class Card {
  private Suit suit;
  private int rank;

  public Card(Suit suit, int rank) throws IllegalArgumentException {
    if (suit == null)
      throw new IllegalArgumentException("Suit must not be null");

    // supports aces high & low; TODO: is this sensible?
    if (rank < Constants.RANK_ACE_LO && rank > Constants.MAX_RANKS)
      throw new IllegalArgumentException("Illegal Rank: " + rank);

    this.suit = suit;
    this.rank = rank;
  }

  /**
   * gets the suit of the card
   * @return the card's suit
   */
  public Suit getSuit() { return suit; }

  /**
   * gets the rank of the card
   * @return the card's rank
   */
  public int getRank() { return rank; }
  
  /**
   * gets the ordinal of the card
   * @return the card's ordinal
   */
  //TODO: what is that exactly?
  public int getOrdinal() { return suit.getNumber() * getRank(); }

  /**
   * returns the suit and rank of card
   * @return suit and rank of card
   */
  @Override
  public String toString() {
    return suit.toString() + getRank();
  }

}
