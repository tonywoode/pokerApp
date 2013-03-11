package pokerapp.console;

import pokerapp.Deck;

/**
 * Created with IntelliJ IDEA.
 * @author steve
 * Date: 22/02/13
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
public class InteractivePlayer extends Player {

  public InteractivePlayer(String name){
    setPlayerName(name);
  }

  public InteractivePlayer() {
    this("");
  }

  public String getPlayerNameFromUser(IConsole console) {
    console.writeMessage("What's your name?");
    setPlayerName(console.readLine());
    return getPlayerName();
  }

  @Override
  public void playTurn(IConsole console, Deck deck) {

//    console.writeMessage("Your hand is: " + getHand().toUserString());
    console.writeMessage("Your hand is: " + getHand().toFancyUserString());
    console.writeMessage("You can change between 0 and 3 cards.");
    console.writeMessage("Write the position of each card you want to exchange, separated by spaces. Then press enter");

    String command = console.readString();
    ExchangeCardsInterpreter interpreter = new ExchangeCardsInterpreter(command);
    interpreter.execute(getHand(), deck);

//    console.writeMessage("Your new hand is: " + getHand().toUserString());
    console.writeMessage("Your new hand is: " + getHand().toFancyUserString());
  }
}
