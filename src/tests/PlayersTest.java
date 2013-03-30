package tests;

import org.junit.Test;
import pokerapp.*;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.PokerGameEvaluator;
import pokerapp.skynet.EasyComputerPlayerStrategy;
import pokerapp.skynet.HardComputerPlayerStrategy;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;

/**
 * @author Ari
 * @version 1.0
 */
public class PlayersTest {
  @Test
  public void testPickWinner() throws Exception {

    HandFactory handFactory = new HandFactory();
    String[] noPairString = {"D6", "S13", "C11", "H14", "H9"};
    String[] pairString = {"D14", "S13", "C11", "H14", "H9"};
    String[] twoPairString = {"D14", "S13", "C14", "H13", "H9"};
    String[] threeOAKString = {"D14", "S13", "C14", "H14", "H9"};
    String[] straightString = {"D12", "S13", "C14", "H11", "H10"};
    String[] flushString = {"D14", "D13", "D3", "D4", "D9"};
    String[] fullHouseString = {"D14", "D13", "H14", "H13", "S13"};
    String[] fourOAKString = {"D14", "S14", "C14", "H14", "H9"};
    String[] straightFlushString = {"D14", "D2", "D3", "D4", "D5"};  //wheel
    String[] royalFlushString = {"D14", "D13", "D12", "D11", "D10"};

    HashMap<Integer, String[]> testHands = new HashMap<>();
    testHands.put(1, noPairString);
    testHands.put(2, pairString);
    testHands.put(3, twoPairString);
    testHands.put(4, threeOAKString);
    testHands.put(5, straightString);
    testHands.put(6, flushString);
    testHands.put(7, fullHouseString);
    testHands.put(8, fourOAKString);
    testHands.put(9, straightFlushString);
    testHands.put(10, royalFlushString);

    Player p1 = new ComputerPlayer("p1", new HardComputerPlayerStrategy());
    Player p2 = new ComputerPlayer("p2", new EasyComputerPlayerStrategy());

    for(int iter1 = 1; iter1 <= 10; ++iter1) {
      for(int iter2 = 1; iter2 <= 10; ++iter2) {
        Hand hand1 = handFactory.createFromArray(testHands.get(iter1));
        Hand hand2 = handFactory.createFromArray(testHands.get(iter2));
        p1.receiveHand(hand1);
        p2.receiveHand(hand2);

        Players testSubjects = new Players(PokerGameEvaluator.create());
        testSubjects.register(p1, p2);

        Player player;
        if(iter1 > iter2){
             player = p1;
        } else {
          if(iter2 > iter1)
            player = p2;
          else player = null;
        }

        String testResult =
            "Hand " + iter1 + " p1: " + p1.getHand().toFancyUserString() +
           " Hand " + iter2 + " p2: " + p2.getHand().toFancyUserString();
        System.out.println(testResult);


        // TODO: was using this:
        //    assertEquals(player, testSubjects.pickWinner());

      }
    }
  }
}
