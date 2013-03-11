package pokerapp.console;

import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.Hand;

/**
 * Created with IntelliJ IDEA.
 * @author Steve
 * Date: 22/02/13
 * Time: 20:13
 *
 */
public class ExchangeCardsInterpreter {
  private String command;

  public ExchangeCardsInterpreter(String command) {
    this.command = command;
  }

  public void execute(Hand hand, Deck deck) {
    for (String strPos : command.split(" ")) {
      int pos = Integer.parseInt(strPos);

      Card card = deck.pop();

      Card replacedCard = hand.exchange(pos - 1, card);

      // TODO: Don't think this is the correct behaviour... can we run out of cards?
      // TODO: yes we are running out - is that what we want?
      //deck.returnToBottom(replacedCard);
    }
  }
}
