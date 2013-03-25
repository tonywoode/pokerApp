package pokerapp.view.card;

import pokerapp.Card;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Dishes out cards images for pokerapp when passed a filepath
 *
 * @author Steve
 * @version 1
 */
public class CardBackImageFactory implements CardImageFactory {
  private final String path;

  public CardBackImageFactory(String path) {
    this.path = path;
  }

  /**
   * creates a card image object from the gif's of cards
   */
  @Override
  public CardView create(Card card) throws IOException, FormatStringException, IllegalFormatCodeException {
    return new CardImage(ImageIO.read(new File(path + "back.gif")));
  }
}
