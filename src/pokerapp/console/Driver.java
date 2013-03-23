package pokerapp.console;

import pokerapp.*;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.skynet.ComputerPlayerFactory;
import pokerapp.utils.Constants;

/**
 * A simple driver for the basic game as specified
 * by the assignment's requirements
 *
 * @author Steve
 * @author Ari
 * @version 1.0
 */
public class Driver {

  public void gameLoop() {

    InteractivePlayer interactivePlayer = new InteractivePlayer();

    ComputerPlayerFactory computerPlayerFactory = new ComputerPlayerFactory();

    ComputerPlayer computerPlayer = computerPlayerFactory.makeComputerPlayer("standardComputer", 2);//TODO:magic number

    Deck deck = Deck.createDeck();

    Dealer dealer = new Dealer(deck);

    // Registering players is now not done through the constructor (because of Spring)
    Players players = new Players(new HandScorerBuilder().create()).register(interactivePlayer, computerPlayer);

    Console console = new StandardConsole(formatter);

    ExchangeSetting exchangeSetting = new ExchangeSetting(3, 1);

    console.writeMessage("Game beginning");

    interactivePlayer.getPlayerNameFromUser(console);

    while (true) {

      dealer.dealCards(Constants.HAND_SIZE, players);

      for (Player p : players) {
        console.writeMessage("Player %1$2s has %2$2s", p, p.getHand().toFancyUserString());
        // SF's amazing magic code
      }

      for (Player p : players) {
        //p.playTurn(console, deck);
      }

//      computerPlayer.playTurn(console, deck);

      interactivePlayer.playTurn(console, deck, exchangeSetting);

      Player winner = players.pickWinner();

      if (interactivePlayer == winner) {
        console.writeMessage("You won!"); // use SF magic here
      } else if (winner == null)
        console.writeMessage("Draw!");
      else
        console.writeMessage("You lost!");

    }
  }
}
