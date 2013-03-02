/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Tony
 *
 */
public class DeckTest {

	/**
	 * Test method for {@link pokerapp.console.Deck#Deck()}.
	 */
	@Test
	public final void testDeck() {
		//check that we have 52 cards
	}

	/**
	 * Test method for {@link pokerapp.console.Deck#shuffle()}.
	 */
	@Test
	public final void testShuffle() {
		//we won't test collection functions
	}

	/**
	 * Test method for {@link pokerapp.console.Deck#pop()}.
	 */
	@Test
	public final void testPop() {
		//do we need to check the card we want to pop?
		//check that the number of cards has reduced by one
		//check that you are being returned a card
	}

	/**
	 * Test method for {@link pokerapp.console.Deck#returnToBottom(pokerapp.Card)}.
	 */
	@Test
	public final void testReturnToBottom() {
		//pop card, check card, return to bottom, check bottom
	}

}
