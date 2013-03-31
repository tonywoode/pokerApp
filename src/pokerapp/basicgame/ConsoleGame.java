package pokerapp.basicgame;

import pokerapp.*;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;
import pokerapp.console.turns.ConsoleGameLoop;
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
  private final ConsoleGameLoop consoleGameLoop;

  private static final int HAND_SIZE = 5;

  /**
   * Note that Lombok has been removed from this class because I couldn't get
   * it to work with final members.
   */
  public ConsoleGame(Console console, InteractivePlayer ip, ComputerPlayer cp, Dealer dealer, Deck deck,
                     Players players, PokerGameEvaluator pokerGameEvaluator, ConsoleGameLoop consoleGameLoop) {
    this.console = console;
    this.interactivePlayer = ip;
    this.computerPlayer = cp;
    this.dealer = dealer;
    this.deck = deck;
    this.players = players;
    this.pokerGameEvaluator = pokerGameEvaluator;
    this.consoleGameLoop = consoleGameLoop;
  }

  public static void main(String[] args) throws IOException {
    begin("consoleGame", "console-game-application-context.xml");
  }

  /**
   * Play a single game of poker with 1 computer player.
   */
  public void run() throws FormatStringException, IllegalFormatCodeException, IOException {
    players.register(computerPlayer, interactivePlayer);

    console.writeMessage("Let's play poker!");

    console.writeMessage("What's your name?");
    interactivePlayer.setPlayerName(console.readLine());
    console.writeMessage("Hello {0}! Welcome to Poker App.", interactivePlayer.getPlayerName());

    ExchangeSetting exchangeSetting = new ExchangeSetting(3, 1);

    dealer.dealCards(HAND_SIZE, players);

    for (Player p : players)
      console.writeMessage("Player {0} has {1}", p, p.getHand().toFancyUserString());

    consoleGameLoop.setExchangeSetting(exchangeSetting);

    consoleGameLoop.reset().register(players);

    consoleGameLoop.play(dealer, console);

    GameResult result = pokerGameEvaluator.evaluate(players.getPlayers());

    if (result.isWinner(interactivePlayer))
      console.writeMessage("You won!");
    else if (result.isTie())
      console.writeMessage("Draw!");
    else
      console.writeMessage("You lost!");
  }
}
