package tests;

import org.junit.Test;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.scorer.HandMatrix;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 28/02/13
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
public class HandMatrixTest {
    @Test
    public void testInitialiseMatrix(){

        HandFactory handFactory = new HandFactory();
        String[] testHandString = {"D9", "S4", "C1", "H3", "C5"};

        try {
            Hand testHand = handFactory.create(testHandString);
            HandMatrix testHandMatrix = new HandMatrix(testHand);
            System.out.println(testHandMatrix.toString());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
