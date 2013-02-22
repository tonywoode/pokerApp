package pokerapp;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 00:51
 * To change this template use File | Settings | File Templates.
 */
public class Card {
  private Suit suit;
  private int rank;

  public Card(Suit suit, int rank) throws InvalidArgumentException {
    if (suit == null)
      throw new InvalidArgumentException(new String[] { "Suit must not be null" });

    // supports aces high & low; TODO: is this sensible?
    if (rank < 1 && rank > 14) // TODO: remove magic numbers
      throw new InvalidArgumentException(new String[] { "Illegal Rank: " + rank });

    this.suit = suit;
    this.rank = rank;
  }

  public Suit getSuit() { return suit; }

  public int getRank() { return rank; }

  public int getOrdinal() { return suit.getNumber() * getRank(); }
}
