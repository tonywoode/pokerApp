package pokerapp;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class HandFactory {

  public Hand create(String... cards) throws Exception {
    Hand hand = new Hand();

    for (String card : cards)
      hand.add(createCard(card));

    return hand;
  }

  private Card createCard(String card) throws InvalidArgumentException {
    if (card.length() < 2 || card.length() > 3)
      throw new InvalidArgumentException(new String[] { "Illegal card name: " + card });

    Suit suit = Suit.from(card.charAt(0));

    return new Card(suit, Integer.parseInt(card.substring(1)));
  }

}
