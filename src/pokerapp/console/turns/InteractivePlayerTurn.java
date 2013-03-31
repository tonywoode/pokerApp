package pokerapp.console.turns;

import lombok.RequiredArgsConstructor;
import pokerapp.Dealer;
import pokerapp.Deck;
import pokerapp.InteractivePlayer;
import pokerapp.Player;
import pokerapp.console.Console;
import pokerapp.console.ExchangeCardsInterpreter;
import pokerapp.console.ExchangeSetting;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 * Describe whether the class uses/is part of a pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
 * @author Steve
 * @version 1
 */
@RequiredArgsConstructor
public class InteractivePlayerTurn implements ConsolePlayerTurn {
  private final String VALID_INPUT = "(([12345]\\s){0,2}[12345])|^$";
  private final int MAXPOS = 5;

  private final InteractivePlayer player;
  private final ExchangeSetting exchangeSetting;

  @Override
  public void playTurn(Dealer dealer, Console console) {
    console.writeMessage("Your hand is: " + player.getHand().toFancyUserString());
    console.writeMessage("You can change between 0 and " + exchangeSetting.getNumCards() + " cards.");
    console.writeMessage("Write the position of each card you want to exchange, " +
          "separated by spaces. Then press enter");

    String command = console.readString();

    while (!command.matches(VALID_INPUT) || !isUniquePos(command)) {
      console.writeMessage("Please enter valid input. Then press enter");
      command = console.readString();
    }

    ExchangeCardsInterpreter interpreter = new ExchangeCardsInterpreter(command);
    interpreter.execute(player.getHand(), dealer.getDeck());

    console.writeMessage("Your new hand is: " + player.getHand().toFancyUserString());
  }

  /* Designed using variant of the code suggested here: http://stackoverflow
  .com/questions/3951547/java-array-finding-duplicates
  */
  private boolean isUniquePos(String command) {
    if (command.matches(VALID_INPUT) && !command.isEmpty()) {
      boolean[] bitmap = new boolean[MAXPOS + 1];
      java.util.Arrays.fill(bitmap, false);
      for (String strPos : command.split(" ")) {
        int pos = Integer.parseInt(strPos);
        if (!bitmap[pos])
          bitmap[pos] = true;
        else
          return false;
      }
    }
    return true;
  }
}
