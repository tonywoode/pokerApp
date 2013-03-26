package pokerapp.view.pokergame;

import com.google.common.eventbus.Subscribe;
import pokerapp.console.Player;
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
		this.pokerGameView.displayMessage(userMessage);

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

		 pokerGameView.displayMessage("Game Started: Choose Which Cards To Exchange");
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
		 // TODO: let the computer play its turn

		 Player winner = pokerGameModel.pickWinner();

		
		 playerHandView.userButtonsEnable(false);
		 pokerGameView.displayMessage("Press Start To Begin Another Game....");

		 computerHandView.showCards();

		 pokerGameView.showGameResultMessage(getWinMessage(winner));
		 pokerGameView.startButtonEnable(true);
		 
		 scoreTally(winner);
	 }

	 /**
	  * Simple switch to announce winner
	  * @param winner player who won
	  * @return 0 if a draw, 1 if player won, -1 if cpu won
	  * @throws IllegalArgumentException
	  */
	 private int getWinMessage(Player winner) throws IllegalArgumentException {
		 if (winner == null)
			 return 0; //draw
		 else if (winner.equals(pokerGameModel.getInteractivePlayer() ) )
			 return 1; //you win
		 else if (winner.equals(pokerGameModel.getComputerPlayer() ) )
			 return -1; //you lose
		 else throw new IllegalArgumentException("Something wrong with winner logic");
	 }
	 
	 /**
	  * Tally's up score for scores panel - adds to last round - sends to view
	  * @param winner the player who won the round
	  */
	 private void scoreTally(Player winner) {
		
		 if (getWinMessage(winner) == 0) //if its a draw
		 {
			 ScoresPanel.setScores(playerScore, cpuScore);
		 }
		 if (getWinMessage(winner) == 1) //if player wins
		 {
			 ScoresPanel.setScores(playerScore , cpuScore += 1); //TODO: that's the wrong way round. Investigate
		 }
		 if (getWinMessage(winner) == -1) //if cpu wins
		 {
			 ScoresPanel.setScores(playerScore  +=  1, cpuScore); //TODO: that's the wrong way round. Investigate
		 }
	 }
	 
	 
}
