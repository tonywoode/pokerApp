package pokerapp;

import lombok.Getter;
import pokerapp.utils.textformat.*;

/**
 * Describes ranks, assigns each rank name a value, and allows printing to screen of the rank - it was decided that
 * 10 is 10, Jack is J, King K, Queen Q and Ace A or 1
 *
 * @author Tony
 */

/*
      case DEUCE: return "Deuce";
    	case THREE: return "Three";
    	case FOUR: return "Four";
    	case FIVE: return "Five";
    	case SIX: return "Six";
    	case SEVEN: return "Seven";
    	case EIGHT: return "Eight";
    	case NINE: return "Nine";
    	case TEN: return "Ten";
    	case JACK: return "Jack";
    	case QUEEN: return "Queen";
    	case KING: return "King";
    	case ACE: return "Ace";
    	case ACE_LOW: return "Low Ace";
 */

public enum Rank implements Formattable<Rank> { // enums implicitly extend Enum & we can't therefore use our own base
  // class
  DEUCE(2, "Deuce"),
  THREE(3, "Three"),
  FOUR(4, "Four"),
  FIVE(5, "Five"),
  SIX(6, "Six"),
  SEVEN(7, "Seven"),
  EIGHT(8, "Eight"),
  NINE(9, "Nine"),
  TEN(10, "Ten"),
  JACK(2, "Jack", "J"),
  QUEEN(12, "Queen", "Q"),
  KING(13, "King", "K"),
  ACE(14, "Ace", "A"),
  ACE_LOW(1, "Ace", "A");

  @Getter
  private int number;
  @Getter
  private String name;
  @Getter
  private String symbol;

  public static Formats<Rank> FORMATS = new Formats<>(
      new Format<>("n|num|number", new FormatResolver<Rank>() {
        @Override
        public String resolve(Rank rank) {
          return Integer.toString(rank.getNumber());
        }
      }),
      new Format<>("s|symbol", new FormatResolver<Rank>() {
        @Override
        public String resolve(Rank rank) {
          return rank.getSymbol();
        }
      }),
      new Format<>("m|name", new FormatResolver<Rank>() {
        @Override
        public String resolve(Rank rank) {
          return rank.getName();
        }
      })
  );

  /**
   * @param number rank of cards 1 to 10
   * @param symbol necessary for jack, queen, king, ace
   * @throws IllegalArgumentException in case constructor receives a second argument that's not ten to ace
   */
  Rank(int number, String name, String symbol) { //ENUM constructors are private
    this.number = number;
    this.name = name;
    this.symbol = symbol;

    if ((symbol.length() > 1) && (!symbol.equals("10"))) { // if >= 2 digits and it's NOT a 10
      throw new IllegalArgumentException("Invalid Symbol, that's not a card rank");
    }
  }

  /**
   * Even cards < 11 need two parameters, we pass the number as the second for card ranks < 11
   *
   * @param number
   */
  Rank(int number, String name) {
    this(number, name, Integer.toString(number));
  }

  /**
   * Returns the Rank in a form that can be printed onscreen
   *
   * @throws IllegalArgumentException because it won't be a rank
   */
  @Override
  public String toString() {
    return name;
  }

  /**
   * @return The Formats instance for this Value Type
   */
  @Override
  public Formats getFormats() {
    return FORMATS;
  }

  /**
   * @param format The name of the format to use when rendering the Value Object as text
   * @return A string holding the textual representation of the value object, according to the named format
   * @throws IllegalFormatCodeException
   * @throws FormatStringException
   */
  @Override
  public String format(String format) throws IllegalFormatCodeException, FormatStringException {
    return getFormats().format(this, format);
  }
}