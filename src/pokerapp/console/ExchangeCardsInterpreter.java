package pokerapp.console;

import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.Hand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public class ExchangeCardsInterpreter {
  private String command;

  public ExchangeCardsInterpreter(String command) {
    this.command = command;
  }

    public void execute(Hand hand, Deck deck) {
        if(!command.isEmpty()){
            for (String strPos : command.split(" ")) {
                int pos = Integer.parseInt(strPos);

                Card card = deck.pop();

                Card replacedCard = hand.exchange(pos - 1, card);
                // TODO: Don't think this is the correct behaviour... can we run out of cards?
                //deck.returnToBottom(replacedCard);
            }
        }
    }
}
