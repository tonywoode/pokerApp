package pokerapp.view.card;

import pokerapp.Card;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import java.io.IOException;
import java.util.HashMap;

/**
 * Supplies card images on demand up to maximum of a deck's worth, to preserve memory
 * @author Steve
 * @version 1
 */
public class CardImageFlyweightFactory implements CardImageFactory {
  private final CardImageFactory cardImageFactory;
  private final HashMap<Card, CardView> cardImages = new HashMap<>();

  public CardImageFlyweightFactory(CardImageFactory cardImageFactory) {
    this.cardImageFactory = cardImageFactory;
  }

  @Override
  public CardView create(Card card) throws FormatStringException, IOException, IllegalFormatCodeException {
    if (cardImages.containsKey(card))
      return cardImages.get(card);
    CardView cardView = cardImageFactory.create(card);
    cardImages.put(card, cardView);
    return cardView;
  }
}
