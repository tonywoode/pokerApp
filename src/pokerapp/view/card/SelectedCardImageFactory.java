package pokerapp.view.card;

import pokerapp.Card;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.view.imagefilters.IImageFilter;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * returns filtered card images in pokerapp for when the user has selected cards to exchange
 *
 * @author Steve
 * @version 1
 */
public class SelectedCardImageFactory implements CardImageFactory {
  private final CardImageFactory cardImageFactory;
  private final IImageFilter selectedCardImageFilter;

  public SelectedCardImageFactory(CardImageFactory cardImageFactory, IImageFilter selectedCardImageFilter) {
    this.cardImageFactory = cardImageFactory;
    this.selectedCardImageFilter = selectedCardImageFilter;
  }

  @Override
  public CardView create(Card card) throws IOException, FormatStringException, IllegalFormatCodeException {
    BufferedImage img = cardImageFactory.create(card).copyImage();

    return new CardImage(selectedCardImageFilter.filter(img));
  }
}
