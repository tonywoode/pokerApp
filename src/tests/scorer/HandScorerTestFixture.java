package tests.scorer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pokerapp.GameResult;
import pokerapp.Player;
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

  private final Player expectedWinner;
  private final List<Player> players;
  protected PokerGameEvaluator pokerGameEvaluator;
  private final StringFormatter formatter = new StringFormatter();

  public HandScorerTestFixture(Player expectedWinner, List<Player> players) throws IOException {
    this.expectedWinner = expectedWinner;
    this.players = players;
    pokerGameEvaluator = PokerGameEvaluator.create();
  }

  @Parameterized.Parameters
  public static Collection<Object[]> dataProvider() throws IOException {
    List<Object[]> data = new ArrayList<>();
    for (GameEvaluatorModel model : GameEvaluatorModel.load("data/hands.txt", HandScorerTestFixture.class)) {
      if (model != null)
        data.add(new Object[] { model.getWinner(), model.getPlayers() });
    }
    return data;
  }

  @Test
  public void PickWinner() throws FormatStringException, IllegalFormatCodeException {
    GameResult result = pokerGameEvaluator.evaluate(players);

    if (expectedWinner != null && result.isTie())
      fail("Did not expect tie");
    else if (expectedWinner == null && !result.isTie())
      fail("Expected a tie, got a winner");
    else if (!result.isTie() && !result.isWinner(expectedWinner))
      fail(formatter.format("Expected {0} to win. Instead {1} won", expectedWinner, result.getWinner()));



  }
}
