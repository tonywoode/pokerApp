package pokerapp.console;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:43
 * To change this template use File | Settings | File Templates.
 */
public class Driver {

  public void gameLoop() {

    Deck deck = null;

    InteractivePlayer interactivePlayer = new InteractivePlayer();

    // TODO: change to use a factory
    ComputerPlayer computerPlayer = new StandardComputerPlayer();

    Dealer dealer = new Dealer();

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
