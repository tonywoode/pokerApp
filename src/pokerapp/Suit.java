package pokerapp;

import pokerapp.utils.Constants;

/**
 * Suits for the poker app
 * @author Steve
 * @version 1.0
 */
public class Suit {

  private final int number;
  private final char code;

  private Suit(int num, char code) {
    this.number = num;
    this.code = Character.toUpperCase(code);
  }

  public int getNumber() { return number; }
  public char getCode() { return code; }

  public final static Suit Clubs    = new Suit(Constants.POS_CLUB, Constants.CHAR_CLUB);
  public final static Suit Diamonds = new Suit(Constants.POS_DIAMOND, Constants.CHAR_DIAMOND);
  public final static Suit Hearts   = new Suit(Constants.POS_HEART, Constants.CHAR_HEART);
  public final static Suit Spades   = new Suit(Constants.POS_SPADE, Constants.CHAR_SPADE);

  public final static Suit[] AllSuits = new Suit[] {
    Clubs, Diamonds, Hearts, Spades
  };

  public static Suit from(char c) throws IllegalArgumentException {
    c = Character.toUpperCase(c);
    for (Suit suit : AllSuits)
      if (suit.getCode() == c)
        return suit;
    throw new IllegalArgumentException("Unknown suit type: " + c );
  }

  public String toString() {
      return "" + code;
  }
}
