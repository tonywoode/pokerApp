package tests.scorer;

import org.junit.Test;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.scorer.HandGrid;
import pokerapp.utils.Constants;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 28/02/13
 * Time: 15:05
 *
 */
public class HandGridTest {
    @Test
    public void testInitialiseMatrix(){

        HandFactory handFactory = new HandFactory();
        String[] testHandString = {"D9", "S4", "C1", "H3", "C5"};

        try {
            Hand testHand = handFactory.create(testHandString);
            HandGrid testHandGrid = new HandGrid(testHand);
            //just testing initialisation that's why it's never used
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testiStraightFlush(){

        HandFactory handFactory = new HandFactory();
        String[] testHandString = {"C10", "C11", "C12", "C13", "C14"};

        try {
            Hand testHand = handFactory.create(testHandString);
            HandGrid testHandGrid = new HandGrid(testHand);
            for (int row = 1; row < Constants.NUM_SUITS + 1; row++) {
                for(int col = 1; col < Constants.MAX_RANKS + 1; col++){
                    System.out.print(testHandGrid.matrix[row][col]);
                }
                System.out.println();
            }
            System.out.println("HIGH STRAIGHT FLUSH\n");
            assertEquals(1, testHandGrid.matrix[1][10]);
            assertEquals(1, testHandGrid.matrix[1][11]);
            assertEquals(1, testHandGrid.matrix[1][12]);
            assertEquals(1, testHandGrid.matrix[1][13]);
            assertEquals(1, testHandGrid.matrix[1][14]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  @Test
  public void testisWheel(){

    HandFactory handFactory = new HandFactory();
    String[] testHandString = {"C2", "C3", "C4", "C5", "D14"};

    try {
      Hand testHand = handFactory.create(testHandString);
      HandGrid testHandGrid = new HandGrid(testHand);
      for (int row = 1; row < Constants.NUM_SUITS + 1; row++) {
        for(int col = 1; col < Constants.MAX_RANKS + 1; col++){
          System.out.print(testHandGrid.matrix[row][col]);
        }
        System.out.println();
      }
      System.out.println("WHEEL\n");
      assertEquals(1, testHandGrid.matrix[1][2]);
      assertEquals(1, testHandGrid.matrix[1][3]);
      assertEquals(1, testHandGrid.matrix[1][4]);
      assertEquals(1, testHandGrid.matrix[1][5]);
      assertEquals(1, testHandGrid.matrix[2][14]);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

    @Test
         public void testFourOAK(){

        HandFactory handFactory = new HandFactory();
        String[] testHandString = {"D9", "S9", "C9", "H3", "H9"};

        try {
            Hand testHand = handFactory.create(testHandString);
            HandGrid testHandGrid = new HandGrid(testHand);
            for (int row = 1; row < Constants.NUM_SUITS + 1; row++) {
                for(int col = 1; col < Constants.MAX_RANKS + 1; col++){
                    System.out.print(testHandGrid.matrix[row][col]);
                }
                System.out.println();
            }
            System.out.println("4 0F A KIND\n");
            assertEquals(1, testHandGrid.matrix[1][9]);
            assertEquals(1, testHandGrid.matrix[2][9]);
            assertEquals(1, testHandGrid.matrix[3][9]);
            assertEquals(1, testHandGrid.matrix[4][9]);
            assertEquals(1, testHandGrid.matrix[3][3]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThreeOAK(){

        HandFactory handFactory = new HandFactory();
        String[] testHandString = {"D6", "S14", "C14", "H14", "H9"};

        try {
            Hand testHand = handFactory.create(testHandString);
            HandGrid testHandGrid = new HandGrid(testHand);
            for (int row = 1; row < Constants.NUM_SUITS + 1; row++) {
                for(int col = 1; col < Constants.MAX_RANKS + 1; col++){
                    System.out.print(testHandGrid.matrix[row][col]);
                }
                System.out.println();
            }
            System.out.println("3 OF A KIND\n");
            assertEquals(1, testHandGrid.matrix[1][14]);
            assertEquals(1, testHandGrid.matrix[2][6]);
            assertEquals(1, testHandGrid.matrix[3][9]);
            assertEquals(1, testHandGrid.matrix[3][14]);
            assertEquals(1, testHandGrid.matrix[4][14]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPair(){

        HandFactory handFactory = new HandFactory();
        String[] testHandString = {"D6", "S13", "C14", "H14", "H9"};

        try {
            Hand testHand = handFactory.create(testHandString);
            HandGrid testHandGrid = new HandGrid(testHand);
            for (int row = 1; row < Constants.NUM_SUITS + 1; row++) {
                for(int col = 1; col < Constants.MAX_RANKS + 1; col++){
                    System.out.print(testHandGrid.matrix[row][col]);
                }
                System.out.println();
            }
            System.out.println("PAIR\n");
            assertEquals(1, testHandGrid.matrix[1][14]);
            assertEquals(1, testHandGrid.matrix[2][6]);
            assertEquals(1, testHandGrid.matrix[3][9]);
            assertEquals(1, testHandGrid.matrix[3][14]);
            assertEquals(1, testHandGrid.matrix[4][13]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTwoPairs(){

        HandFactory handFactory = new HandFactory();
        String[] testHandString = {"D9", "S13", "C14", "H14", "H9"};

        try {
            Hand testHand = handFactory.create(testHandString);
            HandGrid testHandGrid = new HandGrid(testHand);
            for (int row = 1; row < Constants.NUM_SUITS + 1; row++) {
                for(int col = 1; col < Constants.MAX_RANKS + 1; col++){
                    System.out.print(testHandGrid.matrix[row][col]);
                }
                System.out.println();
            }
            System.out.println("2 PAIRS\n");
            assertEquals(1, testHandGrid.matrix[1][14]);
            assertEquals(1, testHandGrid.matrix[2][9]);
            assertEquals(1, testHandGrid.matrix[3][9]);
            assertEquals(1, testHandGrid.matrix[3][14]);
            assertEquals(1, testHandGrid.matrix[4][13]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
