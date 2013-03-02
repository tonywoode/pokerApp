/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import pokerapp.Card;

/**
 * @author Tony
 *
 */
public class DealerTest {

	Map<String, Card> cardMap = new HashMap<>();

	/**
	 * Test method for {@link pokerapp.console.Dealer#dealCards(int, pokerapp.console.Players)}.
	 */
	@Test
	public final void testDealCards() {
		//test that every player has a set of independent cards


		//check the remaining card in the set are in the deck
		//has hashmap that maps every card in a shuffled deck, got through players that have cards retured to them
		//take hashmap - check that card that's in the set is in the hashmap
		//take the remaining deck then say has the card been removed from the deck
		//method should be returning a deck that has a reduced number of cards in it
		//

	}
}

