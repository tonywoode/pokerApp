package pokerapp.console;

import pokerapp.Dealer;
import pokerapp.Deck;

/**
 * Created with IntelliJ IDEA.
 * @author steve
 */
public class Driver {

  public void gameLoop() {

    Deck deck = null;

    InteractivePlayer interactivePlayer = new InteractivePlayer();

    // TODO: change to use a factory
    ComputerPlayer computerPlayer = new StandardComputerPlayer();

    Dealer dealer = new Dealer(deck);

    Players players = new Players(interactivePlayer, computerPlayer);

    IConsole console = null;

    while (true) {

      console.writeMessage("Game beginning");

      deck.shuffle();

      dealer.dealCards(5, players);

      computerPlayer.playTurn(console, deck);

      interactivePlayer.playTurn(console, deck);

      Player winner = players.pickWinner();

      if (interactivePlayer == winner) {
        console.writeMessage("You won!");
      } else {
        console.writeMessage("You lost!");
      }
    }
  }
}
