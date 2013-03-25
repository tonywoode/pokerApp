package pokerapp.view.card;

import pokerapp.Card;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import java.io.IOException;

/**
 * Returns a null card image which is used by card image fatories
 *
 * @author Steve
 * @version 1
 */
public class NullCardImageFactory implements CardImageFactory {
  @Override
  public CardView create(Card card) throws IOException, FormatStringException, IllegalFormatCodeException {
    return new CardImage(null);
  }
}
