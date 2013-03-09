package pokerapp;

import pokerapp.basicgame.InteractiveHandEvaluator;

/**
 * Runs the Hand Evaluator in the console so you can manually type in 5 cards and pokerapp will rate them
 * @author Steve
 * @version 1.0
 */
public class Main {

  public static void main(String[] args) {
    new InteractiveHandEvaluator().run();
  }
}
