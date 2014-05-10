package pokerapp.basicgame;

import com.beust.jcommander.JCommander;
import pokerapp.*;
import pokerapp.basicgame.jcommander.PokerAppCommandLineOptions;
import pokerapp.basicgame.jcommanderfactories.IConsoleOptionsFactoryCoR;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;
import pokerapp.console.UserConfigurable;
import pokerapp.console.jcommandergame.*;
import pokerapp.console.turns.ConsoleGameLoop;
import pokerapp.skynet.NamedComputerPlayerFactory;

import java.io.IOException;

/**
 * @author Ari
 * @version 1.0
 */
public class ManyPlayerConsoleGameWithFactory extends Application {

  private static String[] CONSOLE_INPUTS;

  private PokerAppCommandLineOptions pokerAppCommandLineOptions;
  private JCommander jCommander;
  private PokerCommanderGame pokerCommanderGame;
  private IConsoleOptionsFactoryCoR pokerGameCoRFactory;

  private final int MAX_NUMBER_PLAYERS = 4;
  private final int MIN_NUMBER_PLAYERS = 1;

  private final int MAX_CARDS_EXCHANGE = 5;
  private final int MIN_CARDS_EXCHANGE = 0;
  private final int DEFAULT_CARDS_EXCHANGE = 3;

  private final int MAX_TIMES_EXCHANGE = 5;
  private final int MIN_TIMES_EXCHANGE = 1;

  private final String NEW_LINE = "\n";

  private final Console console;

  private final Deck deck;
  private final Dealer dealer;
  private final Players players;

  private final NamedComputerPlayerFactory computerPlayerFactory;

  // default - exchange 3 cards once
  private final ExchangeSetting exchangeSetting = new ExchangeSetting(3, 1);

  private final ConsoleGameLoop consoleGameLoop;

  private int numberOfPlayers = MAX_NUMBER_PLAYERS;
  private int cardsToExchange = DEFAULT_CARDS_EXCHANGE;
  private int timesToExchange = MIN_TIMES_EXCHANGE;

    public ManyPlayerConsoleGameWithFactory(Console console, Deck deck, Dealer dealer, Players players,
                                          NamedComputerPlayerFactory computerPlayerFactory, ConsoleGameLoop consoleGameLoop,
                                          PokerAppCommandLineOptions pokerAppCommandLineOptions, JCommander jCommander) {
    this.console = console;
    this.deck = deck;
    this.dealer = dealer;
    this.players = players;
    this.computerPlayerFactory = computerPlayerFactory;
    this.consoleGameLoop = consoleGameLoop;
    this.pokerAppCommandLineOptions = pokerAppCommandLineOptions;
    this.jCommander = jCommander;
  }

  public static void main(String[] args) {
    try {
      CONSOLE_INPUTS = args;
      begin("manyPlayerConsoleGameWithFactory", "console-game-application-context.xml");
    } catch (IOException e) {
      System.out.println("Error in application. Exiting.");
    }
  }

  @Override
  public void run() throws IOException {

    parseCommands();

    configureGame();

    while (true) {

      beginGame();

      playGame();

      evaluateGame();

      returnCardsToDealer();

      if (userWantsToLeaveUs())
        break;
    }

    console.writeMessage("\nBye bye!");
  }

    private void configureGame() {
       pokerGameCoRFactory.create(pokerCommanderGame, pokerAppCommandLineOptions);
    }


    private void parseCommands() {
        jCommander.addCommand(this.pokerAppCommandLineOptions);
        jCommander.parse(CONSOLE_INPUTS);
    }

    private boolean userWantsToLeaveUs() {
    console.writeMessage("Play again? Press 'q' to quit");

    String result = console.readString();

    if (result == null) return false;

    result = result.toLowerCase();

    return result != null && result != "" && result.charAt(0) == 'q';
    //TODO: StringIndexOutOfBoundsException if user presses enter and then letter other than q
  }

  private void beginGame() {
    console.writeMessage("Ready? Play poker!");

    dealer.dealCards(Hand.HAND_SIZE, players);
  }

  private void playGame() throws IOException {
    consoleGameLoop.play(pokerCommanderGame);
  }

  private void returnCardsToDealer() {
    for (Player p : players) {
      for (Card c : p.getHand()) {
        deck.returnToBottom(c);
      }
      p.getHand().clear();
    }
  }

  private void evaluateGame() {
    GameResult result = players.evaluateGame();

    console.writeMessage(NEW_LINE);
    console.writeMessage("******************************************************");
    console.writeMessage(NEW_LINE);

    if (!result.isTie()) {
      for (Player p : result.getPlayersInRankOrder())
        if (players.isWinner(p))
          console.writeMessage("{0} won with {1}", p.getPlayerName(), p.getHand().toFancyUserString());
      for (Player p : result.getPlayersInRankOrder())
        if (!players.isWinner(p))
          console.writeMessage("{0} lost with {1}", p.getPlayerName(), p.getHand().toFancyUserString());
    } else {
      // TODO: fix this, obviously
      console.writeMessage("There was a tie... but that's all I know at the moment");
    }

    console.writeMessage(NEW_LINE);
    console.writeMessage("******************************************************");
    console.writeMessage(NEW_LINE);
  }
}
