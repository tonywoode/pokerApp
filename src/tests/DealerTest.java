package tests;

import org.junit.Test;
import pokerapp.Card;
import pokerapp.Suit;
import pokerapp.console.*;
import pokerapp.utils.Constants;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * @author Tony, Sam, Ari
 *
 */
public class DealerTest {



	/**
	 * Test method for {@link pokerapp.console.Dealer#dealCards(int, pokerapp.console.Players)}.
	 */
	@Test
	public final void testDealCards() {
        Map<String, Card> cardMap = new HashMap<String, Card>();
		//test that every player has a set of independent cards

        for(Suit suit : Suit.AllSuits ){
            for(int rank = 0; rank < Constants.MAX_RANKS; rank++) {
                Card c = new Card(suit, rank);
                cardMap.put(c.toString(),c);
            }
        }

        Deck d = new Deck();
        InteractivePlayer interactivePlayer = new InteractivePlayer();
        ComputerPlayer computerPlayer = new StandardComputerPlayer();
        Dealer dealer = new Dealer(d);
        Players players = new Players(interactivePlayer, computerPlayer);


        dealer.dealCards(2,players);

        for(Player player : players.getPlayers() ){
            for(Card card: player.getHand().getCards()){
                cardMap.get(card.toString());
                cardMap.remove(card.toString());
            }
        }

        for(Iterator iter = d.iterator(); iter.hasNext();){
            cardMap.get(iter.next().toString());
            cardMap.remove(iter.next().toString());
        }

        assertTrue(cardMap.isEmpty());

	}
}

