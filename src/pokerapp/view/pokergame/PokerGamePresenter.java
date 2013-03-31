package pokerapp.view.pokergame;

import com.google.common.eventbus.Subscribe;
import pokerapp.GameResult;
import pokerapp.Player;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.view.ScoresPanel;
import pokerapp.view.playerhand.ComputerHandView;
import pokerapp.view.playerhand.PlayerHandPresenterBridge;
import pokerapp.view.playerhand.PlayerHandView;
import pokerapp.view.playerhand.TurnCompletedEvent;
import javax.swing.*;
import java.io.IOException;

/**
 * Presenter for one round of a GUI game - MVP pattern
 * @author Steve
 * @author Tony
 */

public class PokerGamePresenter {
	private final PokerGameModel pokerGameModel;
	private final PokerGameView pokerGameView;
	private final PlayerHandPresenterBridge playerHandPresenterBridge;
	private final ComputerHandView computerHandView;
	private final PlayerHandView playerHandView;
	private int playerScore = 0;
	private int cpuScore = 0;
	
	public PokerGamePresenter(PokerGameModel pokerGameModel, PokerGameView pokerGameView,
			PlayerHandPresenterBridge playerHandPresenterBridge,
			ComputerHandView computerHandView, String userMessage, PlayerHandView playerHandView) {
		this.pokerGameModel = pokerGameModel;
		this.pokerGameView = pokerGameView;
		this.playerHandPresenterBridge = playerHandPresenterBridge;
		this.computerHandView = computerHandView; 
		this.playerHandView = playerHandView;
	
		pokerGameView.registerSubViews(playerHandPresenterBridge, computerHandView);
		this.pokerGameView.displayMessage(userMessage); //singleton

	}

	/**
	 * Starts the game in the frame
	 */
	 public void play() {
		pokerGameView.setTitle("Pokerapp");
		pokerGameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pokerGameView.setVisible(true);
		pokerGameView.setResizable(false);
		playerHandView.userButtonsEnable(false);
		pokerGameView.startButtonEnable(true);
	 }

	 /**
	  * Actions to take on the game beginning - set message, hands, trigger correct buttons
	  * @param bge game event starting trigger
	  * @throws FormatStringException 
	  * @throws IOException
	  * @throws IllegalFormatCodeException
	  */
	 @Subscribe
	 public void gameBeginning(BeginGameEvent bge) throws FormatStringException, IOException, IllegalFormatCodeException {
		 pokerGameModel.dealCards();

		 playerHandPresenterBridge.setPlayer(pokerGameModel.getInteractivePlayer());
		 computerHandView.setHand(pokerGameModel.getComputerPlayer().getHand());
		 
		 new Thread(new Runnable() {
			    public void run() {
			    	pokerGameView.displayMessage("Game Started: Choose Which Cards To Exchange");
			    }
			}).start();

		 
		 playerHandView.userButtonsEnable(true);
		 pokerGameView.startButtonEnable(false);
	 }


	 /**
	  * Actions to take when a round is complete - message, hand presentation, winnder tallying
	  * @param tce round end trigger
	  * @throws FormatStringException
	  * @throws IOException
	  * @throws IllegalFormatCodeException
	  */
	 @Subscribe
	 public void turnCompleted(TurnCompletedEvent tce) throws FormatStringException, IOException,
	 IllegalFormatCodeException {
		 pokerGameModel.letComputerPlayerPlay();

     GameResult result = pokerGameModel.evaluate();

		 playerHandView.userButtonsEnable(false);
		 
		 computerHandView.showCards();

		 pokerGameView.showGameResultMessage(getWinMessage(result));

		 pokerGameView.startButtonEnable(true);
		 
		 scoreTally(result);
		 
		 new Thread(new Runnable() {
			    public synchronized void run() {
			    	pokerGameView.displayMessage("Press Start To Begin Another Game....");
			    }
			}).start();	 
}

	 /**
	  * Simple switch to announce winner
	  * @param winner player who won
	  * @return 0 if a draw, 1 if player won, -1 if cpu won
	  * @throws IllegalArgumentException
	  */
	 private int getWinMessage(GameResult result) throws IllegalArgumentException {
		 if (result.isTie())
			 return 0; //draw
		 else if (result.isWinner(pokerGameModel.getInteractivePlayer()))
			 return 1; //you win
		 else if (result.isWinner(pokerGameModel.getComputerPlayer()))
			 return -1; //you lose
		 else throw new IllegalArgumentException("Something wrong with winner logic");
	 }
	 
	 /**
	  * Tally's up score for scores panel - adds to last round - sends to view
	  * @param winner the player who won the round
	  */
	 private void scoreTally(GameResult result) {
		 int msg = getWinMessage(result);

     switch(msg) {
       case 0: // draw
         ScoresPanel.setScores(playerScore, cpuScore);
         break;
       case 1: // IP wins
         ScoresPanel.setScores(++playerScore , cpuScore);
         break;
       case -1: // CP wins
         ScoresPanel.setScores(playerScore, ++cpuScore);
         break;
     }
   }
}
