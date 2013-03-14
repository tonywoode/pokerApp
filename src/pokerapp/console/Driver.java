package pokerapp.console;

import pokerapp.Dealer;
import pokerapp.Deck;
import pokerapp.utils.Constants;

/**
 * @author   Steve
 * @author   Ari
 * @version  1.0
 * @param    //TODO:Parameter Description
 */
public class Driver {

  public void gameLoop() {

    InteractivePlayer interactivePlayer = new InteractivePlayer();

    // TODO: change to use a factory
    ComputerPlayer computerPlayer = new StandardComputerPlayer();

    Deck deck = Deck.createDeck();

    Dealer dealer = new Dealer(deck);

    Players players = new Players(interactivePlayer, computerPlayer);

    IConsole console = new StandardConsole();

    ExchangeSetting exchangeSetting = new ExchangeSetting(3,1);

    while (true) {

      console.writeMessage("Game beginning");

      interactivePlayer.getPlayerNameFromUser(console);

      dealer.shuffleCards(deck);

      dealer.dealCards(Constants.HAND_SIZE, players);

      for(Player p : players){
        console.writeMessage("Player %1$2s has %2$2s", p, p.getHand());
        // SF's amazing magic code
      }

      for(Player p : players) {
        //p.playTurn(console, deck);
      }

//      computerPlayer.playTurn(console, deck);

      interactivePlayer.playTurn(console, deck, exchangeSetting);

      Player winner = players.pickWinner();

      if (interactivePlayer == winner) {
        console.writeMessage("You won!"); // use SF magic here
      } else if(winner == null)
          console.writeMessage("Draw!");
      else
        console.writeMessage("You lost!");

    }
  }
}
