package pokerapp.console;

import pokerapp.Card;
import pokerapp.utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @author tony
 * @author tony
 * Date: 22/02/13
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
public class Deck implements Iterable<Card> {
	
	
	private ArrayList<Card> deck = new ArrayList<>(); //singleton


  public Deck() {
	  card = Card.getcard();
	  deck.create(Card card);
  }
	  
	  
	public ArrayList<Card> create(Card card) throws IndexOutOfBoundsException { 
    // create all 52 deck...
		    if (deck.size() >= Constants.FULL_DECK)
	        throw new IndexOutOfBoundsException("Deck is full");
		    
		    deck.add(card);
		    
		    return deck;
  }

  public void shuffle() {
    Collections.shuffle(deck);
  }

  public Card pop() {
    Card card = deck.get(deck.size() - 1);
    deck.remove(card);
    return card;
  }

  public void returnToBottom(Card card) {
    deck.add(0, card);
  }
  
  public Iterator<Card> iterator() {
	    return deck.iterator();
	  }
  
  
}
