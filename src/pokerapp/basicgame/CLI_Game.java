package pokerapp.basicgame;

import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;

import java.util.Scanner;

/**
 * User: ari
 * Date: 09/03/2013
 * Time: 13:37
 * Created with IntelliJ IDEA.
 */
public class CLI_Game {


    public void run() {
      try {

        while (true) {

          System.out.println("Enter 5 cards (e.g. H4) separated by spaces");

          try {

            Hand hand = createHandFromUserInput();

            if (hand == null) {
              System.out.println("You entered nothing - thanks for playing");
              return; // treat null as signal to exit
            }

            ScoredHand scoredHand = determineHandCategory(hand);

            System.out.println("The hand is: " + scoredHand.getName());

            // TODO: not all categories support the notion of a rank; so how is the next line to be handled?
            // TODO: not all categories support the notion of a singular rank. where multiple ranks are required we could use an object.
            // System.out.println("It has a rank of: " + hand.getRank());

          } catch (Exception e) {
            System.out.println(e.getMessage());
          }

        }

      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    /**
     * User input is converted to a hand
     * @return hand comprising the user input
     * @throws Exception
     */
    private Hand createHandFromUserInput() throws Exception {
      String line = new Scanner(System.in).nextLine();
      return line != "" ? new HandFactory().createFromLine(line) : null;
    }

    /**
     * when passed a hand, the hand is categorised. Category grade is returned
     * @param hand a hand of cards
     * @return categorisation grade
     */
    private ScoredHand determineHandCategory(Hand hand) {
      return new HandScorerBuilder().create().score(hand);
    }
}




