package pokerapp.view.pokergame;

import com.google.common.eventbus.Subscribe;
import pokerapp.Player;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.view.playerhand.ComputerHandView;
import pokerapp.view.playerhand.PlayerHandPresenterBridge;
import pokerapp.view.playerhand.TurnCompletedEvent;

import javax.swing.*;
import java.io.IOException;

/**
 * Presenter for GUI game - MVP pattern
 * @author Steve
 * @author Tony
 */

public class PokerGamePresenter {
  private final PokerGameModel pokerGameModel;
  private final PokerGameView pokerGameView;
  private final PlayerHandPresenterBridge playerHandPresenterBridge;
  private final ComputerHandView computerHandView;

  public PokerGamePresenter(PokerGameModel pokerGameModel, PokerGameView pokerGameView,
                            PlayerHandPresenterBridge playerHandPresenterBridge,
                            ComputerHandView computerHandView) {
    this.pokerGameModel = pokerGameModel;
    this.pokerGameView = pokerGameView;
    this.playerHandPresenterBridge = playerHandPresenterBridge;
    this.computerHandView = computerHandView;

    pokerGameView.registerSubViews(playerHandPresenterBridge, computerHandView);
  }

  public void play() {
    pokerGameView.setTitle("Pokerapp");
    pokerGameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pokerGameView.setVisible(true);
    pokerGameView.setResizable(false);
  }

  @Subscribe
  public void gameBeginning(BeginGameEvent bge) throws FormatStringException, IOException, IllegalFormatCodeException {
    pokerGameModel.dealCards();

    playerHandPresenterBridge.setPlayer(pokerGameModel.getInteractivePlayer());
    computerHandView.setHand(pokerGameModel.getComputerPlayer().getHand());
  }

  @Subscribe
  public void turnCompleted(TurnCompletedEvent tce) throws FormatStringException, IOException,
      IllegalFormatCodeException {
    // TODO: let the computer play its turn

    Player winner = pokerGameModel.pickWinner();

    String winMessage = getWinMessage(winner);

    computerHandView.showCards();

    JOptionPane.showMessageDialog(pokerGameView, winMessage);
  }

  private String getWinMessage(Player winner) {
    if (winner == null)
      return "Tie";
    else if (winner == pokerGameModel.getInteractivePlayer())
      return "You won!";
    else
      return "You lost!";
  }

}
