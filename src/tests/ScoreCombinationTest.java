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
import pokerapp.utils.HandPermutationGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;

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
            ArrayList<Hand> handPerms = HandPermutationGenerator.permute(createHand);
            for(Hand hands : handPerms){
                expectedScoreHash.put(hands,nextLine[1]);
            }
        }
    }

    @Test
    public void testHashHands() throws FileNotFoundException {
        Iterator it = expectedScoreHash.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            assertEquals(handScorerChain.score((Hand)pairs.getKey()).getName(),(String)pairs.getValue());
        }
    }

}
