package pokerapp.basicgame;

import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.scorer.HandCategoryResolverBuilder;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.resolvers.HandCategoryResolver;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 24/02/13
 * Time: 02:15
 * To change this template use File | Settings | File Templates.
 */
public class InteractiveHandEvaluator {

  public void run() {
    try {

      while (true) {

        System.out.println("Enter 5 cards (e.g. H4) separated by spaces");

        try {

        Hand hand = createHandFromUserInput();

        if (hand == null)
          return; // treat null as signal to exit

        HandCategory category = determineHandCategory(hand);

        System.out.println("The hand is: " + category.getName());

        // TODO: not all categories support the notion of a rank; so how is the next line to be handled?
        System.out.println("It has a rank of: " + category.getRank());

        } catch (Exception e) {
          System.out.println(e.getMessage());
        }

      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private Hand createHandFromUserInput() throws Exception {
    String line = new Scanner(System.in).nextLine();
    return line != "" ? new HandFactory().createFromLine(line) : null;
  }

  private HandCategory determineHandCategory(Hand hand) {
    HandCategoryResolver resolver = new HandCategoryResolverBuilder().create();

    return resolver.resolve(hand);
  }



}
