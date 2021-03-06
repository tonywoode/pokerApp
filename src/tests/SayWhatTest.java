package tests;

import org.junit.Test;
import pokerapp.*;
import pokerapp.console.projectX.MacSayWhat;
import pokerapp.console.projectX.ProjectXConsole;
import pokerapp.console.projectX.SayWhat;

/**
 * @author Ari
 * @author Steve
 * @version 1.0
 */
public class SayWhatTest {

  @Test
  public void testVickiSays_text() throws Exception {
     MacSayWhat.vickiSays("H4 h3");
  }

  @Test
  public void testVickiSays_suit_Clubs_text() throws Exception {
    MacSayWhat.vickiSays("Clubs");
  }

  @Test
  public void testVickiSays_suit() throws Exception {
    Card c = new Card(Suit.Clubs, Rank.ACE);
    String msg = c.getSuit().toString();
    MacSayWhat.vickiSays(msg);
  }

  @Test
  public void testVickiSays_suit_Clubs_unicode_literal() throws Exception {
   MacSayWhat.vickiSays(ProjectXConsole.removeSuitEmoji("♣"));
  }

  @Test
  public void testVickiSays_card() throws Exception {
    HandFactory hf = new HandFactory();
    Hand h = hf.createFromLine("H14 H13 H11 C14 S12");
    String msg = h.toFancyUserString();
    MacSayWhat.vickiSays(ProjectXConsole.removeSuitEmoji(msg));
  }
}
