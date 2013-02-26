package pokerapp;

import pokerapp.utils.Constants;


/**
 * Instantiates valid passed cards and creates hand instances from them. Can also create
 * hands from text descriptions of cards 
 * @author steve
 * @version 1.0
 */
public class HandFactory {

/**
 * Takes a variable number of cards and returns them in a hand
 * @param cards
 * @return hand of cards
 * @throws Exception 
 */
	//TODO: never just throw "exception" - what exception are you expecting?
  public Hand create(String... cards) throws Exception {
    Hand hand = new Hand();

    for (String card : cards)
      hand.add(createCard(card));

    return hand;
  }

/**
 * When  passed a string representing a hand, will return a hand comprising the represented cards
 * @param line a string representing a hand e.g. "S4 D5 H6 C7 S8" - a straight
 * @return a hand of cards recognisable by the application "S4", "D5", "H6", "C7", "S8"
 * @throws Exception TODO: what kind of exception, where does it go
 */
  public Hand createFromLine(String line) throws Exception {
    return create(line.split(" "));
  }

/**
 * When  passed an abbreviated (in accordance with pokerapp's conventions)
 * card name, returns a corresponding Card instance
 * @param card string representation of card used by pokerapp eg: "H4" for 4 or Hearts
 * @return a Card instantiated with the values in the abbreviation
 * @throws IllegalArgumentException
 */
  private Card createCard(String card) throws IllegalArgumentException {
    if (card.length() < Constants.LEN_CARD || card.length() > 1 + Constants.LEN_CARD)
      throw new IllegalArgumentException("Illegal card name: " + card);

    Suit suit = Suit.from(card.charAt(0));

    return new Card(suit, Integer.parseInt(card.substring(1)));
  }

}
