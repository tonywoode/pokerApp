package pokerapp.basicgame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.*;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

/**
 * Spring-based console game loop
 *
 * @author Steve
 */
public class ConsoleGame extends Application {
  private final Console console;
  private final InteractivePlayer interactivePlayer;
  private final ComputerPlayer computerPlayer;
  private final Dealer dealer;
  private final Deck deck;
  private final Players players;

  private static final int HAND_SIZE = 5;

  public ConsoleGame(Console console, InteractivePlayer ip, ComputerPlayer cp, Dealer dealer, Deck deck,
                     Players players) {
    this.console = console;
    this.interactivePlayer = ip;
    this.computerPlayer = cp;
    this.dealer = dealer;
    this.deck = deck;
    this.players = players;
  }

  public static void main(String[] args) {
    begin("consoleGame", "console-game-application-context.xml");
  }

  /**
    * Separate initialisation function used by Spring, because
    * Lombok's auto generated constructor does not do this for us
    * <p/>
    * Note that Lombok has been removed from this class because I couldn't get
    * it to work with final members. TODO: fix this.
    */
  public void initialise() {
    players.register(computerPlayer, interactivePlayer);
  }

  /**
   * Play a single game of poker with 1 computer player.
   */
  public void run() throws FormatStringException, IllegalFormatCodeException {
    console.writeMessage("Let's play poker!");

    interactivePlayer.setPlayerName(interactivePlayer.getPlayerNameFromUser(console));

    ExchangeSetting exchangeSetting = new ExchangeSetting(3, 1);

    dealer.dealCards(HAND_SIZE, players);

    for (Player p : players)
      //TODO:implement custom String formatting
      console.writeMessage("Player {0} has {1}", p, p.getHand());

    // TODO: The play order does not follow the spec
    //for(Player p : players.reverse()) // TODO: .reverse() is an issue!
    for (Player p : players)
      p.playTurn(console, deck, exchangeSetting);

    Player winner = players.pickWinner();

    if (winner == interactivePlayer)
      console.writeMessage("You won!");
    else if (winner == computerPlayer)
      console.writeMessage("Draw!");
    else
      console.writeMessage("You lost!");
  }
}
