package pokerapp;


/**
 * Instantiates valid passsed cards and creates hand instances from them. Can also create
 * hands from text descriptions of cards 
 * @author steve
 * @version 1.0
 */
public class HandFactory {

/**
 * Takes a varaible number of cards and returns them in a hand	
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
 * When  passed a string representging a hand, will return a hand comprising the represented cards 
 * @param line a string representing a hand //TODO: is this clear
 * @return a hand of cards
 * @throws Exception TODO: what kind of exception, where does it go
 */
  public Hand createFromLine(String line) throws Exception {
    return create(line.split(" "));
  }

/**
 * When  passed a pokerapp card name, will return a hand comprising the cards they represent
 * , after checking whether size of string is valid  
 * @param card string representation of card used by pokerapp eg: "H4" for 4 or Hearts
 * @return a Card
 * @throws IllegalArgumentException
 */
  private Card createCard(String card) throws IllegalArgumentException {
    if (card.length() < 2 || card.length() > 3)
      throw new IllegalArgumentException("Illegal card name: " + card);

    Suit suit = Suit.from(card.charAt(0));

    return new Card(suit, Integer.parseInt(card.substring(1)));
  }

}
