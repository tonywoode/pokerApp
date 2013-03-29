package tests;

import org.junit.Test;
import pokerapp.Card;
import pokerapp.Rank;
import pokerapp.Suit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 26/02/13
 * Time: 00:05
 * To change this template use File | Settings | File Templates.
 */
public class CardTest {
  private final Suit clubs = Suit.Clubs;
  private final Suit diamonds = Suit.Diamonds;
  private final Suit hearts = Suit.Hearts;
  private final Suit spades = Suit.Spades;

  @Test
  public void testGetRank() throws Exception {
    assertEquals(13, new Card(hearts, Rank.KING).getRank().getNumber());
    assertEquals(11, new Card(hearts, Rank.JACK).getRank().getNumber());
    assertEquals(10, new Card(hearts, Rank.TEN).getRank().getNumber());

    assertEquals(8, new Card(diamonds, Rank.EIGHT).getRank().getNumber());
    assertEquals(7, new Card(diamonds, Rank.SEVEN).getRank().getNumber());
    assertEquals(6, new Card(diamonds, Rank.SIX).getRank().getNumber());
    assertEquals(5, new Card(diamonds, Rank.FIVE).getRank().getNumber());

    assertEquals(3, new Card(clubs, Rank.THREE).getRank().getNumber());
    assertEquals(2, new Card(clubs, Rank.DEUCE).getRank().getNumber());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoSuit() throws Exception {

    try {
      new Card(null, Rank.THREE);

      fail("didn't throw exception for null suit");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Suit must not be null");
    }
    throw new IllegalArgumentException();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadSuit() throws Exception {

    try {
      new Card(Suit.from('Q'), Rank.from(3));

      fail("didn't throw exception for bad suit");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Unknown suit type: Q");
    }
    throw new IllegalArgumentException();
  }
}
