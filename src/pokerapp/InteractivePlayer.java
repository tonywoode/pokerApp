package pokerapp;

import pokerapp.console.Console;
import pokerapp.console.ExchangeCardsInterpreter;
import pokerapp.console.ExchangeSetting;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

/**
 * @author Steve
 * @author Ari
 * @author Sam
 * @version 1.0
 */
public class InteractivePlayer extends Player {

  public InteractivePlayer(String name) {
    setPlayerName(name);
  }

  public InteractivePlayer() {
    this("");
  }

  @Override
  public void visit(PlayerVisitor visitor) {
    visitor.accept(this);
  }

  // TODO: move this elsewhere
  public String getPlayerNameFromUser(Console console) throws FormatStringException, IllegalFormatCodeException {
    console.writeMessage("What's your name?");
    setPlayerName(console.readLine());
    console.writeMessage("Hello {0}! Welcome to pokerapp.", getPlayerName());
    return getPlayerName();
  }

}
