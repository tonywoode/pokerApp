package utils.Test;

import org.junit.Test;
import pokerapp.Hand;
import pokerapp.Card;
import pokerapp.HandFactory;
import utils.HandPermutationGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 24/02/13
 * Time: 16:46
 * To change this template use File | Settings | File Templates.
 */
public class HandPermutationGeneratorTest {

    static private Set<String> PERMUTATION_TEST_VALUES  = new HashSet<String>(Arrays.asList(new String[]{"D9 S4 C1 H3 C5 ",
            "D9 S4 C1 C5 H3 ",
            "D9 S4 H3 C1 C5 ",
            "D9 S4 H3 C5 C1 ",
            "D9 S4 C5 H3 C1 ",
            "D9 S4 C5 C1 H3 ",
            "D9 C1 S4 H3 C5 ",
            "D9 C1 S4 C5 H3 ",
            "D9 C1 H3 S4 C5 ",
            "D9 C1 H3 C5 S4 ",
            "D9 C1 C5 H3 S4 ",
            "D9 C1 C5 S4 H3 ",
            "D9 H3 C1 S4 C5 ",
            "D9 H3 C1 C5 S4 ",
            "D9 H3 S4 C1 C5 ",
            "D9 H3 S4 C5 C1 ",
            "D9 H3 C5 S4 C1 ",
            "D9 H3 C5 C1 S4 ",
            "D9 C5 C1 H3 S4 ",
            "D9 C5 C1 S4 H3 ",
            "D9 C5 H3 C1 S4 ",
            "D9 C5 H3 S4 C1 ",
            "D9 C5 S4 H3 C1 ",
            "D9 C5 S4 C1 H3 ",
            "S4 D9 C1 H3 C5 ",
            "S4 D9 C1 C5 H3 ",
            "S4 D9 H3 C1 C5 ",
            "S4 D9 H3 C5 C1 ",
            "S4 D9 C5 H3 C1 ",
            "S4 D9 C5 C1 H3 ",
            "S4 C1 D9 H3 C5 ",
            "S4 C1 D9 C5 H3 ",
            "S4 C1 H3 D9 C5 ",
            "S4 C1 H3 C5 D9 ",
            "S4 C1 C5 H3 D9 ",
            "S4 C1 C5 D9 H3 ",
            "S4 H3 C1 D9 C5 ",
            "S4 H3 C1 C5 D9 ",
            "S4 H3 D9 C1 C5 ",
            "S4 H3 D9 C5 C1 ",
            "S4 H3 C5 D9 C1 ",
            "S4 H3 C5 C1 D9 ",
            "S4 C5 C1 H3 D9 ",
            "S4 C5 C1 D9 H3 ",
            "S4 C5 H3 C1 D9 ",
            "S4 C5 H3 D9 C1 ",
            "S4 C5 D9 H3 C1 ",
            "S4 C5 D9 C1 H3 ",
            "C1 S4 D9 H3 C5 ",
            "C1 S4 D9 C5 H3 ",
            "C1 S4 H3 D9 C5 ",
            "C1 S4 H3 C5 D9 ",
            "C1 S4 C5 H3 D9 ",
            "C1 S4 C5 D9 H3 ",
            "C1 D9 S4 H3 C5 ",
            "C1 D9 S4 C5 H3 ",
            "C1 D9 H3 S4 C5 ",
            "C1 D9 H3 C5 S4 ",
            "C1 D9 C5 H3 S4 ",
            "C1 D9 C5 S4 H3 ",
            "C1 H3 D9 S4 C5 ",
            "C1 H3 D9 C5 S4 ",
            "C1 H3 S4 D9 C5 ",
            "C1 H3 S4 C5 D9 ",
            "C1 H3 C5 S4 D9 ",
            "C1 H3 C5 D9 S4 ",
            "C1 C5 D9 H3 S4 ",
            "C1 C5 D9 S4 H3 ",
            "C1 C5 H3 D9 S4 ",
            "C1 C5 H3 S4 D9 ",
            "C1 C5 S4 H3 D9 ",
            "C1 C5 S4 D9 H3 ",
            "H3 S4 C1 D9 C5 ",
            "H3 S4 C1 C5 D9 ",
            "H3 S4 D9 C1 C5 ",
            "H3 S4 D9 C5 C1 ",
            "H3 S4 C5 D9 C1 ",
            "H3 S4 C5 C1 D9 ",
            "H3 C1 S4 D9 C5 ",
            "H3 C1 S4 C5 D9 ",
            "H3 C1 D9 S4 C5 ",
            "H3 C1 D9 C5 S4 ",
            "H3 C1 C5 D9 S4 ",
            "H3 C1 C5 S4 D9 ",
            "H3 D9 C1 S4 C5 ",
            "H3 D9 C1 C5 S4 ",
            "H3 D9 S4 C1 C5 ",
            "H3 D9 S4 C5 C1 ",
            "H3 D9 C5 S4 C1 ",
            "H3 D9 C5 C1 S4 ",
            "H3 C5 C1 D9 S4 ",
            "H3 C5 C1 S4 D9 ",
            "H3 C5 D9 C1 S4 ",
            "H3 C5 D9 S4 C1 ",
            "H3 C5 S4 D9 C1 ",
            "H3 C5 S4 C1 D9 ",
            "C5 S4 C1 H3 D9 ",
            "C5 S4 C1 D9 H3 ",
            "C5 S4 H3 C1 D9 ",
            "C5 S4 H3 D9 C1 ",
            "C5 S4 D9 H3 C1 ",
            "C5 S4 D9 C1 H3 ",
            "C5 C1 S4 H3 D9 ",
            "C5 C1 S4 D9 H3 ",
            "C5 C1 H3 S4 D9 ",
            "C5 C1 H3 D9 S4 ",
            "C5 C1 D9 H3 S4 ",
            "C5 C1 D9 S4 H3 ",
            "C5 H3 C1 S4 D9 ",
            "C5 H3 C1 D9 S4 ",
            "C5 H3 S4 C1 D9 ",
            "C5 H3 S4 D9 C1 ",
            "C5 H3 D9 S4 C1 ",
            "C5 H3 D9 C1 S4 ",
            "C5 D9 C1 H3 S4 ",
            "C5 D9 C1 S4 H3 ",
            "C5 D9 H3 C1 S4 ",
            "C5 D9 H3 S4 C1 ",
            "C5 D9 S4 H3 C1 ",
            "C5 D9 S4 C1 H3 "}));

    static int FIVE_FACTORIAL = 120;

    @Test
    public void correctPermutationsOutputted()
    {


        HandFactory testHandFactory = new HandFactory();
        String[] testHandString = {"D9", "S4", "C1", "H3", "C5"};
        try {
            Hand testHand = testHandFactory.create(testHandString);
            ArrayList<Hand> results = HandPermutationGenerator.permute(testHand);
            for(Hand result : results)
            {
                assertTrue(PERMUTATION_TEST_VALUES.contains(result.toUserString()));
            }
            assertTrue(results.size() == FIVE_FACTORIAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
