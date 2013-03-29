package tests;

import org.junit.Test;
import pokerapp.*;
import pokerapp.console.projectX.ProjectXConsole;
import pokerapp.console.projectX.SayWhat;

/**
 * @param //TODO:Parameter Description
 * @author Ari
 * @author Steve
 * @version 1.0
 * @return //TODO:Return Description
 * @throws //TODO:ExceptionType
 */
public class SayWhatTest {


  @Test
  public void testVickiSays_text() throws Exception {
     SayWhat.vickiSays("H4 h3");
  }

  @Test
  public void testVickiSays_suit_Clubs_text() throws Exception {
    SayWhat.vickiSays("Clubs");
  }

@Test
public void testVickiSays_suit() throws Exception {
  Card c = new Card(Suit.Clubs, Rank.ACE);
  String msg = c.getSuit().toString();
  SayWhat.vickiSays(msg);

}


  @Test
  public void testVickiSays_suit_Clubs_unicode_literal() throws Exception {
    SayWhat.vickiSays(ProjectXConsole.removeSuitEmoji("♣"));
  }


  @Test
  public void testVickiSays_card() throws Exception {
    HandFactory hf = new HandFactory();
    Hand h = hf.createFromLine("H14 H13 H11 C14 S12");
    String msg = h.toFancyUserString();
    SayWhat.vickiSays(ProjectXConsole.removeSuitEmoji(msg));

  }
}
