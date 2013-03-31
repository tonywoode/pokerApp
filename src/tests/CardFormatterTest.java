package tests;

import pokerapp.Card;
import pokerapp.Rank;
import pokerapp.Suit;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Steve
 * @version 1
 */
public class CardFormatterTest {
  Card card = new Card(Suit.Clubs, Rank.EIGHT);

  public void Test1() throws FormatStringException, IllegalFormatCodeException {
    String text = card.format("s=s;c=n");

    assertEquals("♣8", text);
  }


  public void Test2() throws FormatStringException, IllegalFormatCodeException {
    String text = card.format("c=n;s=s");

    assertEquals("8♣", text);
  }

}
