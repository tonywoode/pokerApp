/**
 * 
 */
package tests;

import org.junit.Test;
import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.Suit;

import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * @author Tony
 *
 * TODO:get these tests working with the new deck

 *
 */
class
public class DeckTest {

	/**
	 * Test method for {@link pokerapp.console.Deck#Deck()}.
	 */
	@Test
	public final void testDeck() {
		check that we have 52 cards

	}

	/**
	 * Test method for {@link pokerapp.console.Deck#pop()}.
	 */
	@Test
	public final void testPop() {
		//do we need to check the card we want to pop?
		//check that the number of cards has reduced by one
		//check that you are being returned a card

		Deck testDeck = new Deck(true);
//		testDeck.add(new Card(Suit.Hearts, 13));
		Card c = testDeck.pop();

	  assertEquals(13,c.getRank());
		assertTrue(!testDeck.iterator().hasNext());
	}

	/**
	 * Test method for {@link pokerapp.console.Deck#returnToBottom(pokerapp.Card)}.
	 */
	@Test
	public final void testReturnToBottom() {
		Deck testDeck = new Deck(true);
//		testDeck.create(new Card(Suit.Hearts, 13));
//		testDeck.create(new Card(Suit.Diamonds, 11));
		Card c = testDeck.pop();

		testDeck.returnToBottom(c);

		Iterator<Card> i = testDeck.iterator();

		assertEquals(13, i.next().getRank());
		assertEquals(11, i.next().getRank());
	}

}
