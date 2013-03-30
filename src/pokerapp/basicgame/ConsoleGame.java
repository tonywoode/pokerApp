package pokerapp.basicgame;

import pokerapp.*;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;
import pokerapp.scorer.PokerGameEvaluator;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import java.io.IOException;

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
  private final PokerGameEvaluator pokerGameEvaluator;

  private static final int HAND_SIZE = 5;

  /**
   * Note that Lombok has been removed from this class because I couldn't get
   * it to work with final members.
   */
  public ConsoleGame(Console console, InteractivePlayer ip, ComputerPlayer cp, Dealer dealer, Deck deck,
                     Players players, PokerGameEvaluator pokerGameEvaluator) {
    this.console = console;
    this.interactivePlayer = ip;
    this.computerPlayer = cp;
    this.dealer = dealer;
    this.deck = deck;
    this.players = players;
    this.pokerGameEvaluator = pokerGameEvaluator;
    players.register(computerPlayer, interactivePlayer);
  }

  public static void main(String[] args) throws IOException {
    begin("consoleGame", "console-game-application-context.xml");
  }

  /**
   * Play a single game of poker with 1 computer player.
   */
  public void run() throws FormatStringException, IllegalFormatCodeException, IOException {
    console.writeMessage("Let's play poker!");

    interactivePlayer.setPlayerName(interactivePlayer.getPlayerNameFromUser(console));

    ExchangeSetting exchangeSetting = new ExchangeSetting(3, 1);

    dealer.dealCards(HAND_SIZE, players);

    for (Player p : players)
      console.writeMessage("Player {0} has {1}", p, p.getHand().toFancyUserString());

    // TODO: The play order does not follow the spec
    for (Player p : players)
      p.playTurn(console, deck, exchangeSetting);

    GameResult result = pokerGameEvaluator.evaluate(players.getPlayers());

    if (result.isWinner(interactivePlayer))
      console.writeMessage("You won!");
    else if (result.isTie())
      console.writeMessage("Draw!");
    else
      console.writeMessage("You lost!");
  }
}
