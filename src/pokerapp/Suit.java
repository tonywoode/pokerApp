package pokerapp;

import lombok.Getter;
import pokerapp.utils.Constants;
import pokerapp.utils.textformat.AbstractFormattable;
import pokerapp.utils.textformat.Format;
import pokerapp.utils.textformat.FormatResolver;
import pokerapp.utils.textformat.Formats;

/**
 * Describes suits (in correct order which is clubs, diamonds, hearts, spades) for pokerapp
 *
 * @author Steve
 * @version 1.0
 */
public class Suit extends AbstractFormattable<Suit> {

  @Getter
  private final int number;
  @Getter
  private final char code;

  @Getter
  private final char symbol;
  @Getter
  private final String name;

  private Suit(int num, char code, char symbol, String name) {
    this.number = num;
    this.code = Character.toUpperCase(code);
    this.symbol = symbol;
    this.name = name;
  }

  //the java unicode encodings are black suit symbols
  public final static Suit Clubs = new Suit(Constants.POS_CLUB, Constants.CHAR_CLUB, '\u2663' , "Clubs");
  public final static Suit Diamonds = new Suit(Constants.POS_DIAMOND, Constants.CHAR_DIAMOND, '\u2666', "Diamonds");
  public final static Suit Hearts = new Suit(Constants.POS_HEART, Constants.CHAR_HEART, '\u2665', "Hearts");
  public final static Suit Spades = new Suit(Constants.POS_SPADE, Constants.CHAR_SPADE, '\u2660', "Spades");

  public final static Suit[] AllSuits = new Suit[]{
      Clubs, Diamonds, Hearts, Spades
  };

  /**
   * Use the new Formats<T> object to store strongly-typed formatting information.
   * Would be a lot nicer with Java 8's lambda syntax.
   */
  public static final Formats<Suit> FORMATS = new Formats<>(
      new Format<>("n|num|number", new FormatResolver<Suit>() {
        @Override
        public String resolve(Suit suit) {
          return Integer.toString(suit.number);
        }
      }),
      new Format<>("c|code", new FormatResolver<Suit>() {
        @Override
        public String resolve(Suit suit) {
          return "" + suit.code;
        }
      }),
      new Format<>("s|symbol", new FormatResolver<Suit>() {
        @Override
        public String resolve(Suit suit) {
          return "" + suit.symbol;
        }
      }),
      new Format<>("m|name", new FormatResolver<Suit>() {
        @Override
        public String resolve(Suit suit) {
          return suit.name;
        }
      })
  );

  /**
   * When passed a character from a card representing a suit, will convert to suit or complain
   *
   * @param c a character representing a suit
   * @return suit the character represents
   * @throws IllegalArgumentException if the character isn't C, D, H, S or the corresponding symbol
   */
  public static Suit from(char c) throws IllegalArgumentException {
    c = Character.toUpperCase(c);
    for (Suit suit : AllSuits)
      if (suit.getCode() == c || suit.getSymbol() == c)
        return suit;
    throw new IllegalArgumentException("Unknown suit type: " + c);
  }

  public String toString() {
    return "" + symbol;
  }

  public String toFancyString() {
    return AllSuits[number].toString();
  }

  @Override
  public Formats getFormats() {
    return FORMATS;
  }
}
