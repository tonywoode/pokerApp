package tests.scorer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.Hand;
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
  public SpringBasedHandScorerTestFixture(Hand expectedWinner, List<Hand> hands) throws IOException {
    super(expectedWinner, hands);

    ApplicationContext appContext = new ClassPathXmlApplicationContext("/console-game-application-context.xml");

    HandScorer handScorer = (HandScorer)appContext.getBean("handScorer");

    this.pokerGameEvaluator = new PokerGameEvaluator(handScorer);
  }
}
