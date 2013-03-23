package tests;

import au.com.bytecode.opencsv.CSVReader;
import lombok.Getter;
import lombok.Setter;
import org.junit.Before;
import org.junit.Test;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scorers.HandScorer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 23/03/13
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
public class ScoreCombinationTest {
    private HandScorer handScorerChain;
    private  HashMap<Hand,String> expectedScoreHash;
    private HandFactory handFactory;

    @Before
    public void initialize() throws IOException {
        HandScorerBuilder buildHand = new HandScorerBuilder();
        handScorerChain= buildHand.create();
        expectedScoreHash = new HashMap();
        CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream(
                        "/handtypes.csv"))));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            Hand createHand = handFactory.create(nextLine[0]);

         //   expectedScoreHash.put(createHand);
        }

    }

    @Test
    public void testHashHands()
    {

        //handScorerChain.score(testHand);
    }

}
