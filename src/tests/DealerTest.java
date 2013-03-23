package tests;

import org.junit.Test;
import pokerapp.Card;
import pokerapp.Dealer;
import pokerapp.Deck;
import pokerapp.console.ExchangeSetting;
import pokerapp.console.IConsole;
import pokerapp.console.Player;
import pokerapp.console.Players;
import pokerapp.scorer.HandScorerBuilder;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Tony, Sam, Ari
 */
public class DealerTest {


  // not entirely sure what this test is supposed to do; my attempt is at the end

  /**
   * Test method for .
   */

  /*
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

        Deck d = Deck.createDeck();
        InteractivePlayer interactivePlayer = new InteractivePlayer();
        ComputerPlayer computerPlayer = new StandardComputerPlayer();
        Dealer dealer = new Dealer(d);
        Players players = new Players(interactivePlayer, computerPlayer);

        dealer.dealCards(2, players);

        for (Player player : players.getPlayers()) {
            for (Card card: player.getHand().getCards()) {
                cardMap.get(card.toString());
                cardMap.remove(card.toString());
            }
        }

        for (Iterator iter = d.iterator(); iter.hasNext(); ){
            cardMap.get(iter.next().toString());
            cardMap.remove(iter.next().toString());
        }

        assertTrue(cardMap.isEmpty());

	}
	*/
  @Test
  public void ArePlayersDealtDifferentCards() throws IOException {
    Deck deck = Deck.createDeck();
    Dealer dealer = new Dealer(deck);

    MockPlayer playerOne = new MockPlayer(),
        playerTwo = new MockPlayer();

    // Player registration code changed
    Players players = new Players(new HandScorerBuilder().create()).register(playerOne, playerTwo);

    final int NUM_CARDS_TO_DEAL = 5;

    dealer.dealCards(NUM_CARDS_TO_DEAL, players);

    assertEquals(NUM_CARDS_TO_DEAL, playerOne.cards.size());
    assertEquals(NUM_CARDS_TO_DEAL, playerTwo.cards.size());

    for (int iter = 0; iter < NUM_CARDS_TO_DEAL; ++iter) {
      Card p1Card = playerOne.cards.get(iter);
      assertTrue(cardNotIn(p1Card, playerTwo.cards));

    }

  }

  private boolean cardNotIn(Card checkCard, ArrayList<Card> cards) {
    for (Card card : cards) {
      if (card.equals(checkCard))
        return false;
    }
    return true;
  }

  class MockPlayer extends Player {
    ArrayList<Card> cards = new ArrayList<Card>();

    public void receiveCard(Card card) {
      cards.add(card);
    }

    @Override
    public void playTurn(IConsole console, Deck deck, ExchangeSetting exchangeSetting) {
    }
  }

}

