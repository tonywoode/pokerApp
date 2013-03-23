package pokerapp.view.pokergame;

import com.google.common.eventbus.Subscribe;
import pokerapp.console.Player;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.view.Animation;
import pokerapp.view.MsgAnimation;
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
                            ComputerHandView computerHandView, String userMessage) {
    this.pokerGameModel = pokerGameModel;
    this.pokerGameView = pokerGameView;
    this.playerHandPresenterBridge = playerHandPresenterBridge;
    this.computerHandView = computerHandView;
    
    
    pokerGameView.registerSubViews(playerHandPresenterBridge, computerHandView);
    this.pokerGameView.displayMessage(userMessage);
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
    
    pokerGameView.displayMessage("Game Started: Choose Which Cards To Exchange");
    
    
  }

  @Subscribe
  public void turnCompleted(TurnCompletedEvent tce) throws FormatStringException, IOException,
      IllegalFormatCodeException {
    // TODO: let the computer play its turn

    Player winner = pokerGameModel.pickWinner();

    //String winMessage = getWinMessage(winner);

    pokerGameView.displayMessage("Press Start To Begin Another Game....");
    
    computerHandView.showCards();

	pokerGameView.showGameResultMessage(getWinMessage(winner));
    
    //JOptionPane.showMessageDialog(pokerGameView, winMessage);
  }

  private int getWinMessage(Player winner) {
    if (winner == null)
      return 0; //draw
    else if (winner == pokerGameModel.getInteractivePlayer())
      return 1; //you win
    else
      return -1; //you lose
  }
}
