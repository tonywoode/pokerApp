package pokerapp.view.card;

import pokerapp.Card;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import java.io.IOException;

/**
 * Interface that will pass card images to the view
 *
 * @author Steve
 * @version 1
 */
public interface CardImageFactory {

  public CardView create(Card card) throws IOException, FormatStringException, IllegalFormatCodeException;

}
