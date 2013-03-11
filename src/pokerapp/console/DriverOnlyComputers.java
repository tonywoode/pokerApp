package pokerapp.console;

import pokerapp.Card;
import pokerapp.Dealer;
import pokerapp.Deck;
import pokerapp.utils.Constants;

/**
 * @author Ari
 * Date: 11/03/2013
 * Time: 14:08
 * Created with IntelliJ IDEA.
 */
public class DriverOnlyComputers {
  public void gameLoop() {

    final int MAX_PLAYERS = 4;
    final int MIN_PLAYERS = 1;

    Deck deck = Deck.createDeck();
    Dealer dealer = new Dealer(deck);
    IConsole console = new StandardConsole();
    Players players = new Players();


    console.writeMessage("How many computer players do you want to play? (1 - 4)");
    int numberOfPlayers = 0;
    try {
      //numberOfPlayers = console.readInteger(); //TODO: this doesn't work
      numberOfPlayers = MAX_PLAYERS;

      if (numberOfPlayers > MAX_PLAYERS || numberOfPlayers < MIN_PLAYERS) {

        console.writeMessage("That's not between 1 and 4, better luck next time");
        throw new Exception("User entered invalid number of computer players.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    ComputerPlayerFactory computerPlayerFactory = new ComputerPlayerFactory();

    for(int i = MIN_PLAYERS; i <= numberOfPlayers; ++i) {
      //TODO: handle bad input
      console.writeMessage("Choose a name for computer player " + i + " : ");
      String playerName = console.readLine();
      console.writeMessage("");
      //console.writeMessage("Choose difficulty for computer player " + i + " Hard / Standard / Easy (3 / 2 / 1)  : ");
      //char playerDifficulty = console.readString().charAt(1);
      //int playerDifficulty = console.readInteger();
      int[] difficulty = {0,1,2,3,2};
      int playerDifficulty = difficulty[i];//TODO:fix this
      Player p = computerPlayerFactory.makeComputerPlayer(playerName, playerDifficulty);
      players.add(players,p);

    }


    while (true) {

      console.writeMessage("Ready? Play poker!");

      dealer.shuffleCards(deck);
      dealer.dealCards(Constants.HAND_SIZE, players);

      for(Player p : players) {
        console.writeMessage("Player %1$2s has %2$2s", p, p.getHand()); // SF's amazing magic code
        //TODO: can the magic code retrieve symbols instead ?
      }

      console.writeMessage("\n");

      for(Player p : players) {
        p.playTurn(console, deck);
        console.writeMessage("\n");
      }


      Player winner = players.pickWinner();
      console.writeMessage(winner.getPlayerName() + " won with " + winner.getHand()); //TODO: symbols here too

      for(Player p : players) {             //TODO: this doesn't seem to be working?
        for(Card c : p.getHand()) {
          deck.returnToBottom(c);
        }
        p.getHand().clear();
      }

//      if (computerPlayer1 == winner) {
//        console.writeMessage("1 won!"); // use SF magic here
//      } else if(winner == null)
//        console.writeMessage("Draw!");
//      else
//        console.writeMessage("2 won!");

    }


  }
}
