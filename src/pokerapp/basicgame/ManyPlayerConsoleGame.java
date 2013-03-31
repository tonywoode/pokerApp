package pokerapp.basicgame;

import pokerapp.*;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;
import pokerapp.console.UserConfigurable;
import pokerapp.console.turns.ConsoleGameLoop;
import pokerapp.scorer.PokerGameEvaluator;
import pokerapp.skynet.ComputerPlayerFactory;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.utils.textformat.StringFormatter;

import java.io.IOException;

/**
 * @author Ari
 * @version 1.0
 */
public class ManyPlayerConsoleGame extends Application {
  private final Console console;

  private final Deck deck;
  private final Dealer dealer;
  private final Players players;

  private final ComputerPlayerFactory computerPlayerFactory;

  // default - exchange 3 cards once
  private final ExchangeSetting exchangeSetting = new ExchangeSetting(3, 1);

  private final ConsoleGameLoop consoleGameLoop;

  public ManyPlayerConsoleGame(Console console, Deck deck, Dealer dealer, Players players, ComputerPlayerFactory
      computerPlayerFactory, ConsoleGameLoop consoleGameLoop) {
    this.console = console;
    this.deck = deck;
    this.dealer = dealer;
    this.players = players;
    this.computerPlayerFactory = computerPlayerFactory;
    this.consoleGameLoop = consoleGameLoop;
  }

  public static void main(String[] args) {
    try {
      begin("manyPlayerConsoleGame", "console-game-application-context.xml");
    } catch (IOException e) {
      System.out.println();
    }
  }

  @Override
  public void run() throws FormatStringException, IllegalFormatCodeException, IOException {
    final int MAX_NUMBER_PLAYERS = 4;
    final int MIN_NUMBER_PLAYERS = 1;

    final int MAX_CARDS_EXCHANGE = 5;
    final int MIN_CARDS_EXCHANGE = 0;
    final int DEFAULT_CARDS_EXCHANGE = 3;

    final int MAX_TIMES_EXCHANGE = 5;
    final int MIN_TIMES_EXCHANGE = 1;

    final String NEW_LINE = "\n";

    int numberOfPlayers = MAX_NUMBER_PLAYERS;
    int cardsToExchange = DEFAULT_CARDS_EXCHANGE;
    int timesToExchange = MIN_TIMES_EXCHANGE;


    InteractivePlayer interactivePlayer = new InteractivePlayer();

    console.writeMessage("What's your name?");
    interactivePlayer.setPlayerName(console.readLine());
    console.writeMessage("Hello {0}! Welcome to Poker App.", interactivePlayer.getPlayerName());

    players.register(interactivePlayer);

    UserConfigurable userConfigurableNumPlayers =
        new UserConfigurable("How many computer players do you want to play against?" + NEW_LINE,
            MIN_NUMBER_PLAYERS, MAX_NUMBER_PLAYERS);

    numberOfPlayers = userConfigurableNumPlayers.askUser(console, true);

    console.writeMessage("OK, let's set up exchanges." + NEW_LINE + NEW_LINE);
    console.writeMessage("By default you're allowed to exchange up to three cards..." + NEW_LINE);
    console.writeMessage("...but only for one hand." + NEW_LINE + NEW_LINE);

    UserConfigurable userConfigurableCustomiseExchange = new UserConfigurable("Do you want to customise the way " +
        "exchanges work? (Yes = 1, No = 2)" + NEW_LINE, 1, 2);
    int customiseCardExchange = userConfigurableCustomiseExchange.askUser(console, false);

    switch (customiseCardExchange) {

      case 1:
        UserConfigurable userConfigurableNumCards = new UserConfigurable("How many cards do you want to exchange " +
              "per hand?", MIN_CARDS_EXCHANGE, MAX_CARDS_EXCHANGE);
        cardsToExchange = userConfigurableNumCards.askUser(console, true);

        UserConfigurable userConfigurableNumHands = new UserConfigurable("How many hands do you want to exchange?"
            + NEW_LINE, MIN_TIMES_EXCHANGE, MAX_TIMES_EXCHANGE);
        timesToExchange = userConfigurableNumHands.askUser(console, true);

        exchangeSetting.setNumCards(cardsToExchange);
        exchangeSetting.setNumTimes(timesToExchange);
        console.writeMessage("Excellent, you've decided to exchange " + cardsToExchange + " cards " +
              timesToExchange + " times.", 1);
        break;

      case 2:
        console.writeMessage("No changes made.");     //default values already set
        break;
      default:

    }

    for (int i = MIN_NUMBER_PLAYERS; i <= numberOfPlayers; ++i) {

      console.writeMessage("Choose a name for computer player " + i + " : ");
      String playerName = console.readLine();


      String msg =
          "Choose difficulty for computer player " + playerName +
              " (Easy = 1, Standard = 2, Hard = 3)" + NEW_LINE;
      UserConfigurable userConfigurablePlayerDifficulty = new UserConfigurable(msg, 1, 3);


      int playerDifficulty = 0;
      playerDifficulty = userConfigurablePlayerDifficulty.askUser(console, true);
      Player p = computerPlayerFactory.makeComputerPlayer(playerName, playerDifficulty);
      players.register(p);

    }

    while (true) {

      console.writeMessage("Ready? Play poker!");

      dealer.dealCards(Hand.HAND_SIZE, players);

      for (Player p : players) {

        Class<? extends Player> playerClass = p.getClass();
        String className = playerClass.getSimpleName();
        if ("InteractivePlayer".equals(className)) {
          console.writeMessage("You have " + p.getHand().toFancyUserString());
        } else
          console.writeMessage("Player {0} has {1}", p, p.getHand().toFancyUserString());
      }

      console.writeMessage(NEW_LINE);

      consoleGameLoop.setExchangeSetting(exchangeSetting);

      consoleGameLoop.reset().register(players);

      consoleGameLoop.play(dealer, console);

      GameResult result = players.evaluateGame();

      console.writeMessage(NEW_LINE);
      console.writeMessage("******************************************************");
      console.writeMessage(NEW_LINE);

      if (!result.isTie()) {
        for (Player p : players)
          if (players.isWinner(p))
            console.writeMessage("{0} won with {1}", p.getPlayerName(), p.getHand().toFancyUserString());
      } else {
        // TODO: fix this, obviously
        console.writeMessage("There was a tie... but that's all I know at the moment");
      }

      console.writeMessage(NEW_LINE);
      console.writeMessage("******************************************************");
      console.writeMessage(NEW_LINE);
    }
  }
}
