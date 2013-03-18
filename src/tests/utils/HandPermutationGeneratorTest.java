package tests.utils;

import org.junit.Test;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.utils.HandPermutationGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ I♦EA.
 * User: Samuel Keays
 * Date: 24/02/13
 * Time: 16:46
 * To change this template use File | Settings | File Templates.
 */
public class HandPermutationGeneratorTest {

  static private Set<String> PERMUTATION_TEST_VALUES = new HashSet<String>(Arrays.asList(new String[]{"♦9 ♠4 ♣1 ♥3 ♣5",
      "♦9 ♠4 ♣1 ♣5 ♥3",
      "♦9 ♠4 ♥3 ♣1 ♣5",
      "♦9 ♠4 ♥3 ♣5 ♣1",
      "♦9 ♠4 ♣5 ♥3 ♣1",
     "♦9 ♠4 ♣5 ♣1 ♥3",
     "♦9 ♣1 ♠4 ♥3 ♣5",
     "♦9 ♣1 ♠4 ♣5 ♥3",
     "♦9 ♣1 ♥3 ♠4 ♣5",
     "♦9 ♣1 ♥3 ♣5 ♠4",
     "♦9 ♣1 ♣5 ♥3 ♠4",
     "♦9 ♣1 ♣5 ♠4 ♥3",
     "♦9 ♥3 ♣1 ♠4 ♣5",
     "♦9 ♥3 ♣1 ♣5 ♠4",
     "♦9 ♥3 ♠4 ♣1 ♣5",
     "♦9 ♥3 ♠4 ♣5 ♣1",
     "♦9 ♥3 ♣5 ♠4 ♣1",
     "♦9 ♥3 ♣5 ♣1 ♠4",
     "♦9 ♣5 ♣1 ♥3 ♠4",
     "♦9 ♣5 ♣1 ♠4 ♥3",
     "♦9 ♣5 ♥3 ♣1 ♠4",
     "♦9 ♣5 ♥3 ♠4 ♣1",
     "♦9 ♣5 ♠4 ♥3 ♣1",
     "♦9 ♣5 ♠4 ♣1 ♥3",
     "♠4 ♦9 ♣1 ♥3 ♣5",
     "♠4 ♦9 ♣1 ♣5 ♥3",
     "♠4 ♦9 ♥3 ♣1 ♣5",
     "♠4 ♦9 ♥3 ♣5 ♣1",
     "♠4 ♦9 ♣5 ♥3 ♣1",
     "♠4 ♦9 ♣5 ♣1 ♥3",
     "♠4 ♣1 ♦9 ♥3 ♣5",
     "♠4 ♣1 ♦9 ♣5 ♥3",
     "♠4 ♣1 ♥3 ♦9 ♣5",
     "♠4 ♣1 ♥3 ♣5 ♦9",
     "♠4 ♣1 ♣5 ♥3 ♦9",
     "♠4 ♣1 ♣5 ♦9 ♥3",
     "♠4 ♥3 ♣1 ♦9 ♣5",
     "♠4 ♥3 ♣1 ♣5 ♦9",
     "♠4 ♥3 ♦9 ♣1 ♣5",
     "♠4 ♥3 ♦9 ♣5 ♣1",
     "♠4 ♥3 ♣5 ♦9 ♣1",
     "♠4 ♥3 ♣5 ♣1 ♦9",
     "♠4 ♣5 ♣1 ♥3 ♦9",
     "♠4 ♣5 ♣1 ♦9 ♥3",
     "♠4 ♣5 ♥3 ♣1 ♦9",
     "♠4 ♣5 ♥3 ♦9 ♣1",
     "♠4 ♣5 ♦9 ♥3 ♣1",
     "♠4 ♣5 ♦9 ♣1 ♥3",
     "♣1 ♠4 ♦9 ♥3 ♣5",
     "♣1 ♠4 ♦9 ♣5 ♥3",
     "♣1 ♠4 ♥3 ♦9 ♣5",
     "♣1 ♠4 ♥3 ♣5 ♦9",
     "♣1 ♠4 ♣5 ♥3 ♦9",
     "♣1 ♠4 ♣5 ♦9 ♥3",
     "♣1 ♦9 ♠4 ♥3 ♣5",
     "♣1 ♦9 ♠4 ♣5 ♥3",
     "♣1 ♦9 ♥3 ♠4 ♣5",
     "♣1 ♦9 ♥3 ♣5 ♠4",
     "♣1 ♦9 ♣5 ♥3 ♠4",
     "♣1 ♦9 ♣5 ♠4 ♥3",
     "♣1 ♥3 ♦9 ♠4 ♣5",
     "♣1 ♥3 ♦9 ♣5 ♠4",
     "♣1 ♥3 ♠4 ♦9 ♣5",
     "♣1 ♥3 ♠4 ♣5 ♦9",
     "♣1 ♥3 ♣5 ♠4 ♦9",
     "♣1 ♥3 ♣5 ♦9 ♠4",
     "♣1 ♣5 ♦9 ♥3 ♠4",
     "♣1 ♣5 ♦9 ♠4 ♥3",
     "♣1 ♣5 ♥3 ♦9 ♠4",
     "♣1 ♣5 ♥3 ♠4 ♦9",
     "♣1 ♣5 ♠4 ♥3 ♦9",
     "♣1 ♣5 ♠4 ♦9 ♥3",
     "♥3 ♠4 ♣1 ♦9 ♣5",
     "♥3 ♠4 ♣1 ♣5 ♦9",
     "♥3 ♠4 ♦9 ♣1 ♣5",
     "♥3 ♠4 ♦9 ♣5 ♣1",
     "♥3 ♠4 ♣5 ♦9 ♣1",
     "♥3 ♠4 ♣5 ♣1 ♦9",
     "♥3 ♣1 ♠4 ♦9 ♣5",
     "♥3 ♣1 ♠4 ♣5 ♦9",
     "♥3 ♣1 ♦9 ♠4 ♣5",
     "♥3 ♣1 ♦9 ♣5 ♠4",
     "♥3 ♣1 ♣5 ♦9 ♠4",
     "♥3 ♣1 ♣5 ♠4 ♦9",
     "♥3 ♦9 ♣1 ♠4 ♣5",
     "♥3 ♦9 ♣1 ♣5 ♠4",
     "♥3 ♦9 ♠4 ♣1 ♣5",
     "♥3 ♦9 ♠4 ♣5 ♣1",
     "♥3 ♦9 ♣5 ♠4 ♣1",
     "♥3 ♦9 ♣5 ♣1 ♠4",
     "♥3 ♣5 ♣1 ♦9 ♠4",
     "♥3 ♣5 ♣1 ♠4 ♦9",
     "♥3 ♣5 ♦9 ♣1 ♠4",
     "♥3 ♣5 ♦9 ♠4 ♣1",
     "♥3 ♣5 ♠4 ♦9 ♣1",
     "♥3 ♣5 ♠4 ♣1 ♦9",
     "♣5 ♠4 ♣1 ♥3 ♦9",
     "♣5 ♠4 ♣1 ♦9 ♥3",
     "♣5 ♠4 ♥3 ♣1 ♦9",
     "♣5 ♠4 ♥3 ♦9 ♣1",
     "♣5 ♠4 ♦9 ♥3 ♣1",
     "♣5 ♠4 ♦9 ♣1 ♥3",
     "♣5 ♣1 ♠4 ♥3 ♦9",
     "♣5 ♣1 ♠4 ♦9 ♥3",
     "♣5 ♣1 ♥3 ♠4 ♦9",
     "♣5 ♣1 ♥3 ♦9 ♠4",
     "♣5 ♣1 ♦9 ♥3 ♠4",
     "♣5 ♣1 ♦9 ♠4 ♥3",
     "♣5 ♥3 ♣1 ♠4 ♦9",
     "♣5 ♥3 ♣1 ♦9 ♠4",
     "♣5 ♥3 ♠4 ♣1 ♦9",
     "♣5 ♥3 ♠4 ♦9 ♣1",
     "♣5 ♥3 ♦9 ♠4 ♣1",
     "♣5 ♥3 ♦9 ♣1 ♠4",
     "♣5 ♦9 ♣1 ♥3 ♠4",
     "♣5 ♦9 ♣1 ♠4 ♥3",
     "♣5 ♦9 ♥3 ♣1 ♠4",
     "♣5 ♦9 ♥3 ♠4 ♣1",
     "♣5 ♦9 ♠4 ♥3 ♣1",
     "♣5 ♦9 ♠4 ♣1 ♥3"}));
    
    

  static int FIVE_FACTORIAL = 120;

  @Test
  public void correctPermutationsOutputted() {


    HandFactory testHandFactory = new HandFactory();
    String[] testHandString = {"D9", "S4", "C1", "H3", "C5"};
    try {
      Hand testHand = testHandFactory.create(testHandString);
      ArrayList<Hand> results = HandPermutationGenerator.permute(testHand);
      for (Hand result : results) {
        assertTrue(PERMUTATION_TEST_VALUES.contains(result.toUserString()));
      }
      assertTrue(results.size() == FIVE_FACTORIAL);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}