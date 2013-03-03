package pokerapp.console;

import pokerapp.Card;
import pokerapp.utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *  @author Tony, Sam, Ari
 * Date: 22/02/13
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
public class Deck implements Iterable<Card> {
    //TODO: here because it was scratch impl for console app

	private ArrayList<Card> arrayDeck; //TODO: singleton ?

  public Deck() {
	  //Card.getCards()
	  //deck.create(Card card)
  }
	  
	  
	public ArrayList<Card> create(Card card) throws IndexOutOfBoundsException { 
    // create all 52 deck...
		    if (arrayDeck.size() >= Constants.FULL_DECK)
	        throw new IndexOutOfBoundsException("Deck is full");
		    
		    arrayDeck.add(card);
		    
		    return arrayDeck;
  }

  public void shuffle() {
    Collections.shuffle(arrayDeck);
  }

  public Card pop() {
    Card card = arrayDeck.get(arrayDeck.size() - 1);
    arrayDeck.remove(card);
    return card;
  }

  public void returnToBottom(Card card) {
    arrayDeck.add(0, card);
  }
  
  public Iterator<Card> iterator() {
	    return arrayDeck.iterator();
	  }
  
  
}
