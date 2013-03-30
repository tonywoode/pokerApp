package pokerapp.basicgame;

import pokerapp.*;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;
import pokerapp.console.UserConfigurable;
import pokerapp.skynet.ComputerPlayerFactory;
import pokerapp.skynet.NamedComputerPlayerFactory;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

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

  private int numberOfPlayers = MAX_NUMBER_PLAYERS;
  private int cardsToExchange = DEFAULT_CARDS_EXCHANGE;
  private int timesToExchange = MIN_TIMES_EXCHANGE;

  public ManyPlayerConsoleGameWithFactory(Console console, Deck deck, Dealer dealer, Players players,
                                          NamedComputerPlayerFactory computerPlayerFactory) {
    this.console = console;
    this.deck = deck;
    this.dealer = dealer;
    this.players = players;
    this.computerPlayerFactory = computerPlayerFactory;
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

      displayInitialHands();

      playGame();

      evaluateGame();

      returnCardsToDealer();

      if (userWantsToLeaveUs())
        break;
    }

    console.writeMessage("Bye bye!");
  }

  private boolean userWantsToLeaveUs() {
    return false;
  }

  private void beginGame() {
    console.writeMessage("Ready? Play poker!");

    dealer.dealCards(Hand.HAND_SIZE, players);
  }

  private void registerInteractivePlayer() {
    InteractivePlayer interactivePlayer = new InteractivePlayer();
    interactivePlayer.getPlayerNameFromUser(console);
    players.register(interactivePlayer);
  }

  private void displayInitialHands() {
    for (Player p : players) {

      Class<? extends Player> playerClass = p.getClass();
      String className = playerClass.getSimpleName();
      if ("InteractivePlayer".equals(className)) {
        console.writeMessage("You have " + p.getHand().toFancyUserString());
      } else
        console.writeMessage("Player {0} has {1}", p, p.getHand().toFancyUserString());
    }

    console.writeMessage(NEW_LINE);
  }

  private void playGame() throws IOException {
    for (Player p : players) {
      p.playTurn(console, deck, exchangeSetting);
      console.writeMessage(NEW_LINE);
    }
  }

  private void returnCardsToDealer() {
    for (Player p : players) { //TODO: Doesn't return cards to the deck properly.
      for (Card c : p.getHand()) {
        deck.returnToBottom(c);
      }
      p.getHand().clear();
    }
  }

  // TODO: this is a bit hacky...
  private void evaluateGame() {
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

  private void configureOpponents() {
    UserConfigurable userConfigurableNumPlayers =
        new UserConfigurable("How many computer players do you want to play against?" + NEW_LINE, MIN_NUMBER_PLAYERS, MAX_NUMBER_PLAYERS);
    int numberOfPlayers;
    int cardsToExchange;
    int timesToExchange;
    numberOfPlayers = userConfigurableNumPlayers.askUser(console, true);

    console.writeMessage("Who do you want to play against?");

    for (ComputerPlayer cp : computerPlayerFactory.getPlayers()) {
      console.writeMessage("{0} - ({1})", cp.getPlayerName(), cp.getStrategyFancyName());
    }

    for (int i = MIN_NUMBER_PLAYERS; i <= numberOfPlayers; ++i) {
      console.writeMessage("Enter your opponent's name: ");
      String name = console.readLine();

      ComputerPlayer cp = computerPlayerFactory.create(name);
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