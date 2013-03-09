package pokerapp;

import lombok.Getter;
import pokerapp.utils.Constants;

/**
 * Describes suits (in correct order which is clubs, diamonds, hearts, spades) for pokerapp
 * @author Steve
 * @version 1.0
 */
public class Suit {

  @Getter private final int number;
  @Getter private final char code;

  private Suit(int num, char code) {
    this.number = num;
    this.code = Character.toUpperCase(code);
  }

  public final static Suit Clubs    = new Suit(Constants.POS_CLUB, Constants.CHAR_CLUB);
  public final static Suit Diamonds = new Suit(Constants.POS_DIAMOND, Constants.CHAR_DIAMOND);
  public final static Suit Hearts   = new Suit(Constants.POS_HEART, Constants.CHAR_HEART);
  public final static Suit Spades   = new Suit(Constants.POS_SPADE, Constants.CHAR_SPADE);

  public final static Suit[] AllSuits = new Suit[] {
    Clubs, Diamonds, Hearts, Spades
  };

  /**
   * When passed a character from a card representing a suit, will convert to suit or complain
   * @param c a character representing a suit
   * @return suit the character represents
   * @throws IllegalArgumentException if the character isn't C,D,H,S
   */
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
