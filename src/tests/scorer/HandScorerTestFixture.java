package tests.scorer;

import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pokerapp.Hand;
import pokerapp.scorer.PokerGameEvaluator;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.utils.textformat.StringFormatter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * <p>
 *   Parameterised test for checking the winner from a range
 *   of different hands
 * </p>
 * <p>
 *   Hands are loaded from a text file called hands.txt
 * </p>
 *
 * @author Steve
 * @version 1
 */

@RunWith(Parameterized.class)
public class HandScorerTestFixture {

  private final Hand expectedWinner;
  private final List<Hand> hands;
  private final PokerGameEvaluator pokerGameEvaluator;
  private final StringFormatter formatter = new StringFormatter();

  public HandScorerTestFixture(Hand expectedWinner, List<Hand> hands) throws IOException {
    this.expectedWinner = expectedWinner;
    this.hands = hands;
    pokerGameEvaluator = PokerGameEvaluator.create();
  }

  @Parameterized.Parameters
  public static Collection<Object[]> dataProvider() throws IOException {
    List<Object[]> data = new ArrayList<>();
    for (GameEvaluatorModel model : GameEvaluatorModel.load("data/hands.txt", HandScorerTestFixture.class)) {
      data.add(new Object[] { model.getWinner(), model.getHands() });
    }
    return data;
  }

  @Test
  public void PickWinner() throws FormatStringException, IllegalFormatCodeException {
    Hand winner = pokerGameEvaluator.pickWinner(hands);

    // test for tie separately
    if (winner == null && expectedWinner != null)
      fail("Did not expect tie");
    else if (winner != null && expectedWinner == null)
      fail("Expected tie");
    else if (winner != expectedWinner) // explicitly want reference equality, not value equality
      fail(formatter.format("Expected {0} to win. Instead {1} won", expectedWinner, winner));
  }
}
