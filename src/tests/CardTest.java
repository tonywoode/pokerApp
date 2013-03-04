package tests;

import org.junit.Test;
import pokerapp.Card;
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

        assertEquals(15,new Card(hearts, 15).getRank());       // should complain?
        assertEquals(13,new Card(hearts, 13).getRank());
        assertEquals(11,new Card(hearts, 11).getRank());
        assertEquals(10,new Card(hearts, 10).getRank());



        assertEquals(8,new Card(diamonds, 8).getRank());
        assertEquals(7,new Card(diamonds, 7).getRank());
        assertEquals(6,new Card(diamonds, 6).getRank());
        assertEquals(5,new Card(diamonds, 5).getRank());

        assertEquals(3,new Card(clubs, 3).getRank());
        assertEquals(2,new Card(clubs, 2).getRank());
        assertEquals(1,new Card(clubs, 1).getRank());
        assertEquals(0,new Card(clubs, 0).getRank());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoSuit() throws Exception {

        try{
            new Card(null,3);

            fail("didn't throw exception for null suit");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Suit must not be null");
        }
        throw new IllegalArgumentException();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadSuit() throws Exception {

        try{
            new Card(Suit.from('Q'),3);

            fail("didn't throw exception for bad suit");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Unknown suit type: Q");
        }
        throw new IllegalArgumentException();
    }

//    //TODO: catching AssertionError?
//    @Test(expected = IllegalArgumentException.class)
//    public void testBadNumber() throws Exception{
//
//        try{
//            new Card(Suit.Diamonds,0);
//
//            fail("didn't throw exception for bad number");
//
//        } catch(IllegalArgumentException e){
//            assertEquals(e.getMessage(), "Illegal Rank: 0");
//        }
//        throw new IllegalArgumentException();
//    }


//    public void testGetOrdinal() throws Exception {
//
//    }
//
//    public void testToString() throws Exception {
//
//    }
}
