package view.card;

import pokerapp.Card;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import view.imagefilters.IImageFilter;

import java.awt.image.BufferedImage;
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
