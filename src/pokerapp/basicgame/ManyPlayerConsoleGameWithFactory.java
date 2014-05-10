package pokerapp.basicgame;

import pokerapp.*;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;
import pokerapp.console.UserConfigurable;
import pokerapp.console.WinMessageRenderer;
import pokerapp.console.turns.ConsoleGameLoop;
import pokerapp.skynet.NamedComputerPlayerFactory;

import java.io.IOException;

/**
 * @author Ari
 * @version 1.0
 */
public class ManyPlayerConsoleGameWithFactory extends Application {
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

  private final WinMessageRenderer winMessageRenderer;

  private int numberOfPlayers = MAX_NUMBER_PLAYERS;
  private int cardsToExchange = DEFAULT_CARDS_EXCHANGE;
  private int timesToExchange = MIN_TIMES_EXCHANGE;

  public ManyPlayerConsoleGameWithFactory(Console console, Deck deck, Dealer dealer, Players players,
                                          NamedComputerPlayerFactory computerPlayerFactory, ConsoleGameLoop consoleGameLoop,
                                          WinMessageRenderer winMessageRenderer) {
    this.console = console;
    this.deck = deck;
    this.dealer = dealer;
    this.players = players;
    this.computerPlayerFactory = computerPlayerFactory;
    this.consoleGameLoop = consoleGameLoop;
    this.winMessageRenderer = winMessageRenderer;
  }

  public static void main(String[] args) {
    try {
      begin("manyPlayerConsoleGameWithFactory", "console-game-application-context.xml");
    } catch (IOException e) {
      System.out.println("Error in application. Exiting.");
    }
  }

  @Override
  public void run() throws IOException {
    registerInteractivePlayer();

    configureOpponents();

    configureExchanges();

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

  private void registerInteractivePlayer() {
    InteractivePlayer interactivePlayer = new InteractivePlayer();

    console.writeMessage("What's your name?");
    interactivePlayer.setPlayerName(console.readLine());
    console.writeMessage("Hello {0}! Welcome to Poker App.", interactivePlayer.getPlayerName());

    players.register(interactivePlayer);
  }

  private void playGame() throws IOException {
    consoleGameLoop.setExchangeSetting(exchangeSetting);

    consoleGameLoop.reset().register(players);

    consoleGameLoop.play(dealer, console);
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

      winMessageRenderer.writeMessage(result, console);

    } else {
      // TODO: fix this, obviously
      console.writeMessage("There was a tie... but that's all I know at the moment");
    }

    console.writeMessage(NEW_LINE);
    console.writeMessage("******************************************************");
    console.writeMessage(NEW_LINE);
  }

  private void configureOpponents() {
    UserConfigurable userConfigurableNumPlayers =
        new UserConfigurable("How many computer players do you want to play against?" + NEW_LINE, MIN_NUMBER_PLAYERS, MAX_NUMBER_PLAYERS);
    int numberOfPlayers;
    int cardsToExchange;
    int timesToExchange;
    numberOfPlayers = userConfigurableNumPlayers.askUser(console, true);

    console.writeMessage("Who do you want to play against?");

    int index = 1;
    for (ComputerPlayer cp : computerPlayerFactory.getPlayers()) {
      console.writeMessage("{0}.\t{1} - ({2})", index++, cp.getPlayerName(), cp.getStrategyFancyName());
    }

    for (int i = MIN_NUMBER_PLAYERS; i <= numberOfPlayers; ++i) {
      console.writeMessage("Enter your opponent's number: ");
      int cpNumber = console.readInteger();

      ComputerPlayer cp = computerPlayerFactory.create(cpNumber - 1);
      players.register(cp);
    }
  }

  private int configureExchanges() {
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
    return numberOfPlayers;
  }
}
