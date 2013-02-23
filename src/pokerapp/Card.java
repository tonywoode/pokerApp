package pokerapp;


/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 00:51
 * added line
 */
public class Card {
  private Suit suit;
  private int rank;

  public Card(Suit suit, int rank) throws IllegalArgumentException {
    if (suit == null)
      throw new IllegalArgumentException("Suit must not be null");

    // supports aces high & low; TODO: is this sensible?
    if (rank < 1 && rank > 14) // TODO: remove magic numbers
      throw new IllegalArgumentException("Illegal Rank: " + rank);

    this.suit = suit;
    this.rank = rank;
  }

  public Suit getSuit() { return suit; }

  public int getRank() { return rank; }

  public int getOrdinal() { return suit.getNumber() * getRank(); }

  @Override
  public String toString() {
    return suit.toString() + getRank();
  }

}
