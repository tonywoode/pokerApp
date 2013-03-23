package pokerapp.basicgame;

import pokerapp.Application;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.console.Console;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scorers.HandScorer;

import java.io.IOException;
import java.util.Scanner;

/**
 * User can specify a hand of cards and evaluator will return rank
 * @author Steve
 * @version 1.0
 */

public class InteractiveHandEvaluator extends Application {
  private final Console console;
  private final HandScorer handScorer;
  private final HandFactory handFactory;

  public InteractiveHandEvaluator(Console console, HandScorer handScorer, HandFactory handFactory) {
    this.console = console;
    this.handScorer = handScorer;
    this.handFactory = handFactory;
  }

  public static void main(String[] args) throws IOException {
    begin("interactiveHandEvaluator", "console-game-application-context.xml");
  }

  @Override
  public void run() {
    try {
      while (true) {
        console.writeMessage("Enter 5 cards (e.g. H4) separated by spaces");

        Hand hand = createHandFromUserInput();

        if (hand == null)
          return; // treat null as signal to exit

        ScoredHand scoredHand = handScorer.score(hand);

        console.writeMessage("The hand is: " + scoredHand.getName());
      }

    } catch (Exception e) {
      console.writeMessage(e.getMessage());
    }
  }

  /**
   * User input is converted to a hand
   * @return hand comprising the user input
   * @throws Exception
   */
  private Hand createHandFromUserInput() throws IllegalArgumentException {
    String line = console.readLine();
    return line != "" ? handFactory.createFromLine(line) : null;
  }
}
