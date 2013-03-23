package pokerapp.console;

import pokerapp.*;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.skynet.ComputerPlayerFactory;
import pokerapp.utils.Constants;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.utils.textformat.StringFormatter;

/**
 * @author Ari
 * @version 1.0
 */
public class DriverWithComputers {


  private final Console console = new StandardConsole(new StringFormatter());
  private final ExchangeSetting exchangeSetting = new ExchangeSetting(3, 1);//default - exchange 3 cards once

  public void gameLoop() throws FormatStringException, IllegalFormatCodeException {

    final int MAX_NUMBER_PLAYERS = 4;
    final int MIN_NUMBER_PLAYERS = 1;
    final int DEFAULT_NUMBER_PLAYERS = MAX_NUMBER_PLAYERS;

    final int MAX_CARDS_EXCHANGE = 5;
    final int MIN_CARDS_EXCHANGE = 0;
    final int DEFAULT_CARDS_EXCHANGE = 3;

    final int MAX_TIMES_EXCHANGE = 5;
    final int MIN_TIMES_EXCHANGE = 1;
    final int DEFAULT_TIMES_EXCHANGE = MIN_TIMES_EXCHANGE;

    final String NEW_LINE = "\n";

    int numberOfPlayers = DEFAULT_NUMBER_PLAYERS;
    int cardsToExchange = DEFAULT_CARDS_EXCHANGE;
    int timesToExchange = DEFAULT_TIMES_EXCHANGE;


    Deck deck = Deck.createDeck();
    Dealer dealer = new Dealer(deck);
    Players players = new Players(new HandScorerBuilder().create());


    try {

      InteractivePlayer interactivePlayer = new InteractivePlayer();
      interactivePlayer.getPlayerNameFromUser(console);
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

    } catch (Exception e1) {
      e1.printStackTrace();
    }

    ComputerPlayerFactory computerPlayerFactory = new ComputerPlayerFactory();

    for (int i = MIN_NUMBER_PLAYERS; i <= numberOfPlayers; ++i) {

      console.writeMessage("Choose a name for computer player " + i + " : ");
      String playerName = console.readLine();


      String msg =
          "Choose difficulty for computer player " + playerName +
              " (Easy = 1, Standard = 2, Hard = 3)" + NEW_LINE;
      UserConfigurable userConfigurablePlayerDifficulty = new UserConfigurable(msg, 1, 3);


      int playerDifficulty = 0;
      try {
        playerDifficulty = userConfigurablePlayerDifficulty.askUser(console, true);
      } catch (Exception e) {
        e.printStackTrace();
      }
      Player p = computerPlayerFactory.makeComputerPlayer(playerName, playerDifficulty);
      players.register(p);

    }

    while (true) {

      console.writeMessage("Ready? Play poker!");

      dealer.dealCards(Constants.HAND_SIZE, players);

      for (Player p : players) {

        Class<? extends Player> playerClass = p.getClass();
        String className = playerClass.getSimpleName();
        if ("InteractivePlayer".equals(className)) {
          console.writeMessage("You have " + p.getHand().toFancyUserString());
        } else
          console.writeMessage("Player %1$2s has %2$2s", p, p.getHand().toFancyUserString());
      }

      console.writeMessage(NEW_LINE);

      for (Player p : players) {
        p.playTurn(console, deck, exchangeSetting);
        console.writeMessage(NEW_LINE);
      }


      Player winner = players.pickWinner();
      console.writeMessage(winner.getPlayerName() + " won with " + winner.getHand());
      //TODO: unicode for each card
      for (Player p : players) {             //TODO: this doesn't seem to be working?
        for (Card c : p.getHand()) {
          deck.returnToBottom(c);
        }
        p.getHand().clear();
      }

    }


  }
}
