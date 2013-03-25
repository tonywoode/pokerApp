package pokerapp.view.card;

import pokerapp.Card;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.view.hand.CardViewModel;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * creates card references and images for the card view models
 *
 * @author Steve
 * @version 1
 */
public class CardViewModelFactory {
  private final CardImageFactory cardImageFactory;
  private final CardImageFactory selectedCardImageFactory;

  public CardViewModelFactory(CardImageFactory cardImageFactory, CardImageFactory selectedCardImageFactory) {
    this.cardImageFactory = cardImageFactory;
    this.selectedCardImageFactory = selectedCardImageFactory;
  }

  public CardViewModel create(Card card) throws FormatStringException, IOException, IllegalFormatCodeException {
    return new CardViewModel(card, getImage(cardImageFactory.create(card)), getImage(selectedCardImageFactory.create
        (card)));
  }

  protected BufferedImage getImage(CardView cv) {
    return ((CardImage) cv).getImage();
  }

}
