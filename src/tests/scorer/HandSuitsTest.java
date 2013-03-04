package tests.scorer;

import org.junit.Test;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.scorer.HandGrid;
import pokerapp.scorer.HandSuits;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 24/02/13
 * Time: 19:02
 * To change this template use File | Settings | File Templates.
 */
public class HandSuitsTest {

    @Test
    public void testPair(){

        HandFactory handFactory = new HandFactory();
        String[] testHandString = {"D6", "S13", "C14", "H14", "H9"};

        try {
            Hand testHand = handFactory.create(testHandString);
            HandGrid testHandGrid = new HandGrid(testHand);
            HandSuits testHSHist = new HandSuits(testHandGrid);
            for (int row = 0; row < testHSHist.suit_histogram.length; row++) {

                    System.out.print(testHSHist.suit_histogram[row]);

                System.out.println();
            }
            System.out.println("PAIR\n");
            assertEquals(1,testHSHist.suit_histogram[1]);
            assertEquals(1,testHSHist.suit_histogram[2]);
            assertEquals(2,testHSHist.suit_histogram[3]);
            assertEquals(1,testHSHist.suit_histogram[4]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
