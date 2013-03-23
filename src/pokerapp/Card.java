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
  @Getter
  private Suit suit;
  @Getter
  private Rank rank;

  public Card(Suit suit, Rank rank) throws IllegalArgumentException {
    if (suit == null)
      throw new IllegalArgumentException("Suit must not be null");

    // supports aces high & low; TODO: is this sensible?
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
    return null; // TODO: how can we fix this?
  }

  @Override
  public String format(String format) throws IllegalFormatCodeException, FormatStringException {
    return FORMATS.format(this, format);
  }
}
