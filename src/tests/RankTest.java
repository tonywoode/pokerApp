/**
 *
 */
package tests;

import org.junit.Test;
import pokerapp.Rank;

import static org.junit.Assert.assertEquals;

/**
 * Tests the Rank class that it return the numerical value of a rank plus its printable description
 *
 * @author Tony
 */
public class RankTest {


  @Test
  public void testReturnNumericalsOfARank() {
    assertEquals("Three's code is 3,3", "3,3", Rank.THREE.getNumber() + "," + Rank.THREE.getSymbol());
  }


  @Test
  public void testTextReturnOfARank() {
    assertEquals("Three's text is 3", "3", Rank.THREE.toString());
  }

  @Test
  public void testRankInt() {
    assertEquals("3", 3, Rank.THREE.getNumber());
  }


//TODO: clean this  /*
	public static void Main(String[] args) {

		for (Rank rank : Rank.values() ) {
			//System.out.println(rank + "'s code is " + rank.toString());
			System.out.println(rank + "'s code is " + rank.getNumber() + "," + rank.getSymbol());
		}
	}
	*/
}
