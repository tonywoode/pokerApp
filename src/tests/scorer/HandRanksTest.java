package tests.scorer;

import org.junit.Test;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.scorer.HandRanks;

import static junit.framework.Assert.assertEquals;


/**
 * User: ari
 * Date: 03/03/2013
 * Time: 22:02
 * Created with IntelliJ IDEA.
 */
public class HandRanksTest {

    HandFactory testHandFactory = new HandFactory();
    String[] Str_4_7 = {"H7","D7","C7","S7","C2"};
    String[] Str_4_14 = {"H14","D14","C14","S14","C2"} ;
    String[] Str_3_7 = {"H7","D7","C8","S7","C2"};
    String[] Str_2_7_2_8 = {"H7","D7","C8","S8","C2"};
    String[] Str_2_7 = {"H6","D7","C4","S7","C2"};
    String[] Str_Flush = {"C7","C4","C2","C8","C10"};
    String[] Str_Straight = {"H6","D7","C8","S9","C10"};
    

    @Test
    public void testInstance() throws Exception{

        try {

            Hand testHandF = testHandFactory.create(Str_Flush);
            HandRanks test = new HandRanks(testHandF);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test
    public void testGetCount() throws Exception {
        try {

            Hand H_4_7 = testHandFactory.create(Str_4_7);
            HandRanks HRH_4_7 = new HandRanks(H_4_7);
            Hand H_4_14 = testHandFactory.create(Str_4_14);
            HandRanks HRH_4_14 = new HandRanks(H_4_14);
            Hand H_3_7 = testHandFactory.create(Str_3_7);
            HandRanks HRH_3_7 = new HandRanks(H_3_7);
            Hand H_2_7_2_8 = testHandFactory.create(Str_2_7_2_8);
            HandRanks HRH_2_7_2_8 = new HandRanks(H_2_7_2_8);
            Hand H_2_7 = testHandFactory.create(Str_2_7);
            HandRanks HRH_2_7 = new HandRanks(H_2_7);
            Hand H_Straight = testHandFactory.create(Str_Straight);
            HandRanks HRH_Straight = new HandRanks(H_Straight);

            assertEquals(1, HRH_4_7.countMultiple(4));
            assertEquals(1, HRH_4_14.countMultiple(4));
            assertEquals(1, HRH_3_7.countMultiple(3));
            assertEquals(2, HRH_2_7_2_8.countMultiple(2));
            assertEquals(1, HRH_2_7.countMultiple(2));
            assertEquals(5,HRH_Straight.countMultiple(1));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testIterator() throws Exception {

    }

    @Test
    public void testGetRankOfMultiple() throws Exception {
        try {

            Hand H_4_7 = testHandFactory.create(Str_4_7);
            //need hand summaries here as they create hists
            HandRanks HRH_4_7 = new HandRanks(H_4_7);
            Hand H_3_7 = testHandFactory.create(Str_3_7);
            HandRanks HRH_3_7 = new HandRanks(H_3_7);
            Hand H_2_7_2_8 = testHandFactory.create(Str_2_7_2_8);
            HandRanks HRH_2_7_2_8 = new HandRanks(H_2_7_2_8);
            Hand H_2_7 = testHandFactory.create(Str_2_7);
            HandRanks HRH_2_7 = new HandRanks(H_2_7);
            Hand H_Straight = testHandFactory.create(Str_Straight);
            HandRanks HRH_Straight = new HandRanks(H_Straight);

            assertEquals(7, HRH_4_7.getRankOfMultiple(4));
            assertEquals(7, HRH_3_7.getRankOfMultiple(3));
            assertEquals(8, HRH_2_7_2_8.getRankOfMultiple(2)); //returns rank of higher pair
            assertEquals(7, HRH_2_7.getRankOfMultiple(2));
            assertEquals(10,HRH_Straight.getRankOfMultiple(1));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testIsAcesLow() throws Exception {

    }

    @Test
    public void testSetAcesLow() throws Exception {

    }

    @Test
    public void testLowAcesOn() throws Exception {

    }

    @Test
    public void testLowAcesOff() throws Exception {

    }
}
