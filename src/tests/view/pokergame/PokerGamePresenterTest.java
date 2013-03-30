package tests.view.pokergame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.GameResult;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.Player;
import pokerapp.scorer.PokerGameEvaluator;
import pokerapp.scorer.scorers.HandScorer;
import pokerapp.view.events.EventSource;
import pokerapp.view.playerhand.ComputerHandView;
import pokerapp.view.playerhand.PlayerHandPresenterBridge;
import pokerapp.view.playerhand.PlayerHandView;
import pokerapp.view.pokergame.PokerGameModel;
import pokerapp.view.pokergame.PokerGamePresenter;
import pokerapp.view.pokergame.PokerGameView;
import tests.scorer.MockPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

/**
 * <p>
 *   Tests the main GUI Presenter. Focuses on game evaluation.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class PokerGamePresenterTest {
  private PokerGamePresenter presenter;
  private PokerGameModel pokerGameModel = null;
  private StubPokerGameView pokerGameView = null;
  private PokerGameEvaluator evaluator;

  public class StubPokerGameView extends PokerGameView {
    @Getter @Setter
    private int expectedMessage;

    public StubPokerGameView() {
      super(null);
      this.expectedMessage = -2;
    }

    @Override
    public void showGameResultMessage(int winMessage) {
      assertEquals("Win Message is incorrect", expectedMessage, winMessage);
    }

    @Override
    public void registerSubViews(final PlayerHandPresenterBridge playerHandPresenterBridge,
                                 final ComputerHandView computerHandView) {

    }
  }


  @Before
  public void setUp() {
    evaluator = loadEvaluator();

    pokerGameModel = mock(PokerGameModel.class);

    pokerGameView = new StubPokerGameView();
    PlayerHandPresenterBridge playerHandPresenterBridge = mock(PlayerHandPresenterBridge.class);
    ComputerHandView computerHandView = mock(ComputerHandView.class);
    String userMessage = "";
    PlayerHandView playerHandView = mock(PlayerHandView.class);

    presenter = new PokerGamePresenter(pokerGameModel, pokerGameView, playerHandPresenterBridge, computerHandView, userMessage, playerHandView);


  }

  private PokerGameEvaluator loadEvaluator() {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/console-game-application-context.xml");

    HandScorer handScorer = (HandScorer)appContext.getBean("handScorer");

    return new PokerGameEvaluator(handScorer);
  }

  @Test
  public void testSimpleScore() throws IOException {
    HandFactory handFactory = new HandFactory();
    Hand p1Hand = handFactory.createFromLine("H8 D8 H13 D2 C14"),
         p2Hand = handFactory.createFromLine("C9 H3 C4 C11 D3");

    Player p1 = new MockPlayer(p1Hand, 1),
           p2 = new MockPlayer(p2Hand, 2);

    List<Player> players = new ArrayList<>();
    players.add(p1);
    players.add(p2);

    GameResult result = evaluator.evaluate(players);

    when(pokerGameModel.evaluate()).thenReturn(result);
    when(pokerGameModel.getInteractivePlayer()).thenReturn(p1);
    when(pokerGameModel.getComputerPlayer()).thenReturn(p2);

    pokerGameView.setExpectedMessage(1);

    presenter.turnCompleted(null);
  }
}
