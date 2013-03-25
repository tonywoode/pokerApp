package pokerapp.view.card;

import pokerapp.Card;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.utils.textformat.StringFormatter;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Factory for converting cards into card image references
 *
 * @author Steve
 * @version 1
 */
public class CardImageFactoryImpl implements CardImageFactory {

  private final String path;
  private final StringFormatter formatter;

  public CardImageFactoryImpl(String path, StringFormatter formatter) {
    this.path = path;
    this.formatter = formatter;
  }

  /**
   * when passed a card, will return the image from path
   */
  @Override
  public CardView create(Card card) throws IOException, FormatStringException, IllegalFormatCodeException {
    String filename = path + formatter.format("{0:s=c;r=s}.gif", card);

    return new CardImage(ImageIO.read(new File(filename)));
  }
}
