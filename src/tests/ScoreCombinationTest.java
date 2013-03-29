package tests;

import au.com.bytecode.opencsv.CSVReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scorers.HandScorer;
import pokerapp.utils.HandPermutationGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

/**
 * Created with IntelliJ IDEA.
 * @author Samuel Keays
 * @author Steve Faulmann
 * Date: 23/03/13
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Parameterized.class)
public class ScoreCombinationTest {

    public ScoreCombinationTest(Hand testHand, String expectedResult) {
        this.testHand = testHand;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static Collection<Object[]> parameters() throws IOException {
        List<Object[]> output = new ArrayList<>();

        CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(ScoreCombinationTest.class.getResourceAsStream("/handtypes.csv"))));
        String [] nextLine;

        HandFactory handFactory = new HandFactory();
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            Hand createHand = handFactory.createFromLine(nextLine[0]);
            ArrayList<Hand> handPerms = HandPermutationGenerator.permute(createHand);
            for(Hand hand : handPerms){
                Object[] testData = new Object[] { hand, nextLine[1] };
                output.add(testData);
            }
        }

        return output;
    }

    public Hand testHand;
    public String expectedResult;

    @Test
    public void testHashHands() throws IOException {
        HandScorerBuilder buildHand = new HandScorerBuilder();
        System.out.println(testHand.toUserString());
        HandScorer handScorerChain= buildHand.create();
        assertEquals(expectedResult,handScorerChain.score(testHand).getName());
    }

}
