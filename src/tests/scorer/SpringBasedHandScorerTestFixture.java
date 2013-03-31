package tests.scorer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.Player;
import pokerapp.scorer.PokerGameEvaluator;
import pokerapp.scorer.scorers.HandScorer;

import java.io.IOException;
import java.util.List;

/**
 *
 * This test fixture checks that the spring config is correctly
 * loading the HandScorers (i.e., in the correct order).
 *
 * @author Ari
 * @version 1.0
 */
public class SpringBasedHandScorerTestFixture extends HandScorerTestFixture {
  public SpringBasedHandScorerTestFixture(Player expectedWinner, List<Player> players) throws IOException {
    super(expectedWinner, players);

    ApplicationContext appContext = new ClassPathXmlApplicationContext("/console-game-application-context.xml");

    HandScorer handScorer = (HandScorer)appContext.getBean("handScorer");

    this.pokerGameEvaluator = new PokerGameEvaluator(handScorer);
  }
}
