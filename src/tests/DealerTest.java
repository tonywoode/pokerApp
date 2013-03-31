package tests;

import org.junit.Test;
import pokerapp.*;
import pokerapp.scorer.PokerGameEvaluator;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Tony, Sam, Ari
 */
public class DealerTest {

  @Test
  public void ArePlayersDealtDifferentCards() throws IOException {
    Deck deck = Deck.createDeck();
    Dealer dealer = new Dealer(deck);

    MockPlayer playerOne = new MockPlayer(),
        playerTwo = new MockPlayer();

    // Player registration code changed
    Players players = new Players(PokerGameEvaluator.create()).register(playerOne, playerTwo);

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
    public void visit(PlayerVisitor visitor) { }
  }

}

