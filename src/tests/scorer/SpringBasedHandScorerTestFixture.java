package tests.scorer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.Player;
import pokerapp.scorer.PokerGameEvaluator;
import pokerapp.scorer.scorers.HandScorer;

import java.io.IOException;
import java.util.List;

/**
 * @param //TODO:Parameter Description
 * @author Ari
 * @version 1.0
 * @return //TODO:Return Description
 * @throws //TODO:ExceptionType
 */
public class SpringBasedHandScorerTestFixture extends HandScorerTestFixture {
  public SpringBasedHandScorerTestFixture(Player expectedWinner, List<Player> players) throws IOException {
    super(expectedWinner, players);

    ApplicationContext appContext = new ClassPathXmlApplicationContext("/console-game-application-context.xml");

    HandScorer handScorer = (HandScorer)appContext.getBean("handScorer");

    this.pokerGameEvaluator = new PokerGameEvaluator(handScorer);
  }
}
