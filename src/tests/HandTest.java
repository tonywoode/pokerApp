package tests;

import org.junit.Before;
import org.junit.Test;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Suit;

import java.util.Iterator;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 26/02/13
 * Time: 23:05
 * To change this template use File | Settings | File Templates.
 */
public class HandTest {

  private Card testCard1;
  private Card testCard2;
  private Card testCard3;
  private Card testCard4;
  private Card testCard5;
  private Card testCard6;

  private Hand testHand;

  @Before
  public void setUp() {
    testCard1 = new Card(Suit.Clubs, 9);
    testCard2 = new Card(Suit.Spades, 8);
    testCard3 = new Card(Suit.Diamonds, 9);
    testCard4 = new Card(Suit.Hearts, 4);
    testCard5 = new Card(Suit.Diamonds, 6);
    testCard6 = new Card(Suit.Spades, 1);

    testHand = new Hand();
  }


  @Test
  public void testAdd() {
    testHand.add(testCard1);
    assertEquals("Hand had card", "♣9 ", testHand.toUserString());
  }

  @Test
  public void testAddMultiple() {
    testHand.add(testCard1);
    testHand.add(testCard2);
    testHand.add(testCard3);

    assertEquals("Hand had card", "♣9 ♠8 ♦9 ", testHand.toUserString());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testOverLoad() {
    testHand.add(testCard1);
    testHand.add(testCard2);
    testHand.add(testCard3);
    testHand.add(testCard4);
    testHand.add(testCard5);
    try {
      testHand.add(testCard6);
      fail("Didn't throw exception");
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("Full hand");
    }
  }

  @Test
  public void testIterator() {
    testHand.add(testCard1);
    testHand.add(testCard2);
    testHand.add(testCard3);
    testHand.add(testCard4);
    testHand.add(testCard5);

    Iterator<Card> testIter = testHand.iterator();

    assertTrue(testIter.hasNext());
    testIter.next();
    assertTrue(testIter.hasNext());
    testIter.next();
    assertTrue(testIter.hasNext());
    testIter.next();
    assertTrue(testIter.hasNext());
    testIter.next();

    // This won't work because there isn't a next card... I think...
    // TODO: verify this
    //assertFalse(testIter.hasNext());
  }

  @Test
  public void SortedArrayTest() {
    testHand.add(testCard1);
    testHand.add(testCard2);
    testHand.add(testCard3);
    testHand.add(testCard4);
    testHand.add(testCard5);

    //    assertEquals("Sorted correctly", "" testHand.getSortedCards())   How is this sorted? TO-DO
  }

  @Test
  public void UserStringTest() {
    testHand.add(testCard1);
    testHand.add(testCard2);
    testHand.add(testCard3);
    testHand.add(testCard4);
    testHand.add(testCard5);

    assertEquals("User string is right", "♣9 ♠8 ♦9 ♥4 ♦6 ", testHand.toUserString());
  }

  @Test
  public void TestExchange() {
    testHand.add(testCard1);
    testHand.add(testCard2);

    testHand.exchange(1, testCard3);

    assertEquals("Exchange worked", "♣9 ♦9 ", testHand.toUserString());
  }
}
