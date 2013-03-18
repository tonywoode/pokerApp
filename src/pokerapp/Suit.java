package pokerapp;

import lombok.Getter;
import pokerapp.utils.Constants;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.Formattable;
import pokerapp.utils.textformat.IllegalFormatCodeException;

/**
 * Describes suits (in correct order which is clubs, diamonds, hearts, spades) for pokerapp
 *
 * @author Steve
 * @version 1.0
 */
public class Suit implements Formattable {

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

  public final static Suit Clubs = new Suit(Constants.POS_CLUB, Constants.CHAR_CLUB, '♣', "Clubs");
  public final static Suit Diamonds = new Suit(Constants.POS_DIAMOND, Constants.CHAR_DIAMOND, '♦', "Diamonds");
  public final static Suit Hearts = new Suit(Constants.POS_HEART, Constants.CHAR_HEART, '♥', "Hearts");
  public final static Suit Spades = new Suit(Constants.POS_SPADE, Constants.CHAR_SPADE, '♠', "Spades");

  public final static Suit[] AllSuits = new Suit[]{
      Clubs, Diamonds, Hearts, Spades
  };

  public static final String NUMBER_FORMAT = "n",
      CODE_FORMAT = "c",
      SYMBOL_FORMAT = "s",
      NAME_FORMAT = "m",
      DEFAULT_FORMAT = SYMBOL_FORMAT;
    public static final int SYMBOL_LOCATION = 0,

    /**
   * When passed a character from a card representing a suit, will convert to suit or complain
   *
   * @param c a character representing a suit
   * @return suit the character represents
   * @throws IllegalArgumentException if the character isn't C,D,H,S
   */
  public static Suit from(char c) throws IllegalArgumentException {
    c = Character.toUpperCase(c);
    for (Suit suit : AllSuits)
      if (suit.getCode() == c || suit.toString().toCharArray()[SYMBOL_LOCATION] == c)
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
  public String format(String format) throws IllegalFormatCodeException, FormatStringException {
    // TODO: not happy with a switch, but expediency...
    switch (format) {
      case NUMBER_FORMAT:
        return Integer.toString(number);
      case CODE_FORMAT:
        return "" + code;
      case SYMBOL_FORMAT:
        return "" + symbol;
      case NAME_FORMAT:
        return name;
      default:
        throw new IllegalFormatCodeException(format, this.getClass());
    }
  }
}
