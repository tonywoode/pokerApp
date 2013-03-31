package pokerapp;

import lombok.Data;
import lombok.Getter;
import pokerapp.utils.textformat.*;


/**
 * creates cards for the poker app
 *
 * @author Steve
 * @version 1.0
 */
@Data
public class Card implements Formattable {
  public static final int NUM_SUITS = 4;
  public static final int NUM_RANKS = 14;
  @Getter
  private Suit suit;
  @Getter
  private Rank rank;

  public Card(Suit suit, Rank rank) {
    if (suit == null)
      throw new IllegalArgumentException("Suit must not be null");

    // Only supports aces high
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
   * @return rank and suit of card
   */
  public String toFancyString() {
    return getRank().getSymbol() + getSuit().getSymbol();
  }

  public static final CompositeFormattable<Card> FORMATS
      = new CompositeFormattable<Card>()
      .add("s|suit", new FormattableResolver<Card>() {
        @Override
        public Formattable resolve(Card card) {
          return card.getSuit();
        }
      })
      .add("r|rank", new FormattableResolver<Card>() {
        @Override
        public Formattable resolve(Card card) {
          return card.getRank();
        }
      });

  @Override
  public Formats getFormats() {
    return null; // this is fine, because no clients use it.
  }

  @Override
  public String format(String format) throws IllegalFormatCodeException, FormatStringException {
    return FORMATS.format(this, format);
  }
}
