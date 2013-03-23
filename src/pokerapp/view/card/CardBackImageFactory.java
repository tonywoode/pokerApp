package pokerapp.view.card;

import pokerapp.Card;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 * Describe whether the class uses/is part of a pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class CardBackImageFactory implements CardImageFactory {
  private final String path;

  public CardBackImageFactory(String path) {
    this.path = path;
  }

  @Override
  public CardView create(Card card) throws IOException, FormatStringException, IllegalFormatCodeException {
    return new CardImage(ImageIO.read(new File(path + "back.gif")));
  }
}
