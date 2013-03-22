package view.card;

import pokerapp.Card;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import java.io.IOException;
import java.util.HashMap;

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
