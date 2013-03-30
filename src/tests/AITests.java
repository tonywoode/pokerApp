package tests;

import org.junit.Test;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.skynet.HardLogic;
import tests.scorer.MockPlayer;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 30/03/13
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
public class AITests {
    @Test
        public void test2NearStraight()
        {
            HandFactory handFactory = new HandFactory();
            Hand hand = handFactory.createFromLine("D2 D3 D4 D10 D5");
            HardLogic hardComputerPlayerStrategy= new HardLogic(new MockPlayer(hand,1));
            assertEquals("♦10", hardComputerPlayerStrategy.getNearStraightRemoval(1).get(0).toString());
        }

    @Test
    public void test2NearStraightGap()
    {
        HandFactory handFactory = new HandFactory();
        Hand hand = handFactory.createFromLine("D2 D3 D4 D10 D6");
        HardLogic hardComputerPlayerStrategy= new HardLogic(new MockPlayer(hand,1));
        ArrayList<Card> testReturn = hardComputerPlayerStrategy.getNearStraightRemoval(2);
        assertEquals("♦10", testReturn.get(0).toString());
        assertEquals("♦2", testReturn.get(1).toString());
    }

    @Test
    public void test2NearStraightGap2()
    {
        HandFactory handFactory = new HandFactory();
        Hand hand = handFactory.createFromLine("D2 D3 D4 D10 D11");
        HardLogic hardComputerPlayerStrategy= new HardLogic(new MockPlayer(hand,1));
        ArrayList<Card> testReturn = hardComputerPlayerStrategy.getNearStraightRemoval(2);
        assertNull(testReturn);
    }

    @Test
    public void test2NearStraightGap3()
    {
        HandFactory handFactory = new HandFactory();
        Hand hand = handFactory.createFromLine("D2 D3 D4 D10 D11");
        HardLogic hardComputerPlayerStrategy= new HardLogic(new MockPlayer(hand,1));
        ArrayList<Card> testReturn = hardComputerPlayerStrategy.getNearStraightRemoval(3);
        assertEquals("♦4", testReturn.get(0).toString());
        assertEquals("♦3", testReturn.get(1).toString());
        assertEquals("♦2", testReturn.get(2).toString());
    }


    @Test
    public void test2NearStraightGapFail()
    {
        HandFactory handFactory = new HandFactory();
        Hand hand = handFactory.createFromLine("D2 D3 D4 D10 D7");
        HardLogic hardComputerPlayerStrategy= new HardLogic(new MockPlayer(hand,1));
        ArrayList<Card> testReturn = hardComputerPlayerStrategy.getNearStraightRemoval(2);
        assertEquals("♦10", testReturn.get(0).toString());
        assertEquals("♦7", testReturn.get(1).toString());
    }

    @Test
    public void test3NearStraightGap()
    {
        HandFactory handFactory = new HandFactory();
        Hand hand = handFactory.createFromLine("D2 D3 D4 D10 D7");
        HardLogic hardComputerPlayerStrategy= new HardLogic(new MockPlayer(hand,1));
        ArrayList<Card> testReturn = hardComputerPlayerStrategy.getNearStraightRemoval(3);
        assertEquals("♦7", testReturn.get(0).toString());
        assertEquals("♦3", testReturn.get(1).toString());
        assertEquals("♦2", testReturn.get(2).toString());
    }

    @Test
    public void test3NearStraightGap2()
    {
        HandFactory handFactory = new HandFactory();
        Hand hand = handFactory.createFromLine("D2 D3 D12 D10 D6");
        HardLogic hardComputerPlayerStrategy= new HardLogic(new MockPlayer(hand,1));
        ArrayList<Card> testReturn = hardComputerPlayerStrategy.getNearStraightRemoval(3);
        assertEquals("♦10", testReturn.get(0).toString());
        assertEquals("♦6", testReturn.get(1).toString());
        assertEquals("♦2", testReturn.get(2).toString());
    }

    @Test
    public void test3NearStraightGap3()
    {
        HandFactory handFactory = new HandFactory();
        Hand hand = handFactory.createFromLine("D2 D3 D13 D10 D6");
        HardLogic hardComputerPlayerStrategy= new HardLogic(new MockPlayer(hand,1));
        ArrayList<Card> testReturn = hardComputerPlayerStrategy.getNearStraightRemoval(3);
        assertEquals("♦10", testReturn.get(0).toString());
        assertEquals("♦6", testReturn.get(1).toString());
        assertEquals("♦2", testReturn.get(2).toString());
    }

    @Test
    public void testWheel1()
    {
        HandFactory handFactory = new HandFactory();
        Hand hand = handFactory.createFromLine("D2 D3 D13 D10 D14");
        HardLogic hardComputerPlayerStrategy= new HardLogic(new MockPlayer(hand,1));
        ArrayList<Card> testReturn = hardComputerPlayerStrategy.getNearStraightRemoval(1);
        assertEquals("♦10", testReturn.get(0).toString());
    }

    @Test
    public void testWheel2()
    {
        HandFactory handFactory = new HandFactory();
        Hand hand = handFactory.createFromLine("D2 D3 D8 D7 D14");
        HardLogic hardComputerPlayerStrategy= new HardLogic(new MockPlayer(hand,1));
        ArrayList<Card> testReturn = hardComputerPlayerStrategy.getNearStraightRemoval(2);
        assertNull(testReturn);
    }

    @Test
    public void testWheel3()
    {
        HandFactory handFactory = new HandFactory();
        Hand hand = handFactory.createFromLine("D5 D3 D13 D10 D14");
        HardLogic hardComputerPlayerStrategy= new HardLogic(new MockPlayer(hand,1));
        ArrayList<Card> testReturn = hardComputerPlayerStrategy.getNearStraightRemoval(3);
        assertEquals("♦10", testReturn.get(0).toString());
    }

}
